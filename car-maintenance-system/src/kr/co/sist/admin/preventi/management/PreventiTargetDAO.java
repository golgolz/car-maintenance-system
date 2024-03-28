package kr.co.sist.admin.preventi.management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kr.co.sist.admin.preventi.policy.PreventiPolicyDAO;
import kr.co.sist.admin.preventi.policy.PreventiPolicyVO;
import kr.co.sist.dao.DBConnection;

public class PreventiTargetDAO {
    static private PreventiTargetDAO preventiTargetDAO;
    private HashMap<String, List<Integer>> preventiTargetOwnerIdMap;
    private List<PreventiTargetVO> totalPreventiTarget;
    private List<PreventiTargetInsertVO> preventiTargetsInsert;
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet resultSet;

    private PreventiTargetDAO() {
        deleteAllPreventiTargets();
        try {
            createPreventiTargetsData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static public PreventiTargetDAO getInstance() {
        if (preventiTargetDAO == null) {
            preventiTargetDAO = new PreventiTargetDAO();
        }

        return preventiTargetDAO;
    }

    public void createPreventiTargetsData() throws SQLException {
        DBConnection dbConn = DBConnection.getInstance();
        preventiTargetsInsert = new ArrayList<PreventiTargetInsertVO>();

        try {
            conn = dbConn.getConnection();
            StringBuilder selectQuery = new StringBuilder();
            selectQuery.append("select resisted_car.car_id, resisted_car.production_date,")
                    .append(" case when reserved_car.drive_distance is null then resisted_car.drive_distance ")
                    .append(" when reserved_car.drive_distance >= resisted_car.drive_distance then reserved_car.drive_distance ")
                    .append(" else resisted_car.drive_distance end as drive_distance ").append(" from reserved_car ")
                    .append(" right outer join resisted_car on resisted_car.car_id = reserved_car.car_id ");
            pstmt = conn.prepareStatement(selectQuery.toString());

            resultSet = pstmt.executeQuery();
            StringBuilder parts = new StringBuilder();
            int driveDistance = 0;
            List<PreventiPolicyVO> policies = PreventiPolicyDAO.getInstance().getPolicies();

            Date productionDate = null;
            LocalDate productionLocalDate = null;
            LocalDate currentDate = LocalDate.now();
            LocalDate elevenMonthsAfter = null;
            LocalDate twelveMonthsAfter = null;

            while (resultSet.next()) {
                driveDistance = resultSet.getInt("drive_distance");
                productionDate = resultSet.getDate("production_date");
                productionLocalDate = productionDate.toLocalDate();

                // 예방 정비 지침 주행거리 및 제조일 연산
                for (PreventiPolicyVO policy : policies) {
                    if ((driveDistance % policy.getDistancePeriod()) <= 2000) {
                        parts.append(policy.getPartCode());
                    } else if (policy.getProductionPeriod() != 0) {
                        elevenMonthsAfter = productionLocalDate.plusMonths(11);
                        twelveMonthsAfter = productionLocalDate.plusMonths(12);

                        if (currentDate.isBefore(twelveMonthsAfter) && currentDate.isAfter(elevenMonthsAfter)) {
                            // System.out.println("현재 날짜가 주어진 날짜로부터 11개월 이내에 포함됩니다.");
                            parts.append(policy.getPartCode());
                        }
                    }

                    if (!parts.toString().isBlank()) {
                        preventiTargetsInsert.add(new PreventiTargetInsertVO(resultSet.getString("car_id"),
                                productionDate, parts.toString(), driveDistance));
                    }
                    parts.setLength(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.dbClose(conn, pstmt, resultSet);
        }

        insertAllPreventiTargets();
    }

    public int insertAllPreventiTargets() throws SQLException {
        int cnt = 0;

        DBConnection dbConn = DBConnection.getInstance();
        try {
            conn = dbConn.getConnection();
            StringBuilder insertQuery = new StringBuilder();
            for (int i = 0; i < preventiTargetsInsert.size(); i++) {
                insertQuery.append(
                        " insert into preventi_repair(car_id, production_date, part_code, drive_distance) values(?, ?, ?, ?) ");
                pstmt = conn.prepareStatement(insertQuery.toString());
                pstmt.setString(1, preventiTargetsInsert.get(i).getCarId());
                pstmt.setDate(2, preventiTargetsInsert.get(i).getProductionDate());
                pstmt.setString(3, preventiTargetsInsert.get(i).getPartCode());
                pstmt.setInt(4, preventiTargetsInsert.get(i).getDriveDistance());
                pstmt.execute();
                insertQuery.setLength(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.dbClose(conn, pstmt, resultSet);
        }

        return cnt;
    }

    public List<PreventiTargetVO> selectAllPreventi() throws SQLException {
        List<PreventiTargetVO> preventiTargets = new ArrayList<PreventiTargetVO>();
        totalPreventiTarget = new ArrayList<PreventiTargetVO>();
        preventiTargetOwnerIdMap = new HashMap<String, List<Integer>>();
        HashMap<String, Integer> preventiTargetMap = new HashMap<String, Integer>();
        DBConnection dbConn = DBConnection.getInstance();
        StringBuilder selectQuery = new StringBuilder();
        int cnt = 0;

        selectQuery.append("select preventi_repair.car_id as car_id, ").append(" owner.owner_id as owner_id, ")
                .append(" resisted_car.car_model as car_model, ").append(" owner.tel,")
                .append(" resisted_car.drive_distance as drive_distance, ")
                .append(" case when reservation.car_id is null then ? else ? end as reservation_status, ")
                .append(" case when reserved_car.car_id is null then ? ")
                .append(" when reserved_car.maintenance_status = ? then ? ")
                .append(" when reserved_car.maintenance_status = ? then ? ")
                .append(" else reserved_car.maintenance_status end as maintenance_status, ")
                .append(" preventi_repair.production_date as production_date, ")
                .append(" reservation.reservation_date, ").append(" part_info.part_name ").append(" from owner owner ")
                .append(" join resisted_car on resisted_car.owner_id = owner.owner_id ")
                .append(" join preventi_repair on preventi_repair.car_id = resisted_car.car_id ")
                .append(" left outer join reserved_car on resisted_car.car_id = reserved_car.car_id ")
                .append(" left outer join car_maintenance_settlement on car_maintenance_settlement.car_id = resisted_car.car_id ")
                .append(" left outer join reservation on reservation.car_id = preventi_repair.car_id ")
                .append(" join part_info on preventi_repair.part_code = part_info.part_code ");
        try {
            conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(selectQuery.toString());

            pstmt.setString(1, "x");
            pstmt.setString(2, "o");
            pstmt.setString(3, "입고전");
            pstmt.setString(4, "x");
            pstmt.setString(5, "정비대기");
            pstmt.setString(6, "o");
            pstmt.setString(7, "정비완료");

            resultSet = pstmt.executeQuery();

            PreventiTargetVO tempVO = null;
            List<Integer> tempInts = null;
            PreventiTargetVO totalTempVO = null;
            String ownerId = null;
            String carId = null;
            String partName = null;

            while (resultSet.next()) {
                ownerId = resultSet.getString("owner_id");
                carId = resultSet.getString("car_id");
                partName = resultSet.getString("part_name");

                if (!preventiTargetMap.containsKey(carId)) {
                    preventiTargetMap.put(carId, cnt);
                    cnt++;
                    tempVO = new PreventiTargetVO(carId, ownerId, resultSet.getString("tel"),
                            resultSet.getString("car_model"), resultSet.getInt("drive_distance"),
                            resultSet.getString("reservation_status").equals("o") ? "Y" : "N",
                            resultSet.getString("maintenance_status"), resultSet.getDate("production_date"),
                            resultSet.getString("reservation_date"), partName);

                    preventiTargets.add(tempVO);
                } else {
                    preventiTargets.get(preventiTargetMap.get(carId)).addPart(partName);
                }

                if (!preventiTargetOwnerIdMap.containsKey(ownerId)) {
                    preventiTargetOwnerIdMap.put(ownerId,
                            new ArrayList<Integer>(Arrays.asList(totalPreventiTarget.size())));

                    tempVO = new PreventiTargetVO(carId, ownerId, resultSet.getString("tel"),
                            resultSet.getString("car_model"), resultSet.getInt("drive_distance"),
                            resultSet.getString("reservation_status").equals("o") ? "Y" : "N",
                            resultSet.getString("maintenance_status"), resultSet.getDate("production_date"),
                            resultSet.getString("reservation_date"), partName);
                    totalPreventiTarget.add(tempVO);
                } else {
                    tempInts = preventiTargetOwnerIdMap.get(ownerId);
                    for (int i = 0; i < tempInts.size(); i++) {
                        totalTempVO = totalPreventiTarget.get(tempInts.get(i));
                        if (carId.equals(totalTempVO.getCarId())) {
                            totalPreventiTarget.get(tempInts.get(i)).addPart(partName);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.dbClose(conn, pstmt, resultSet);
        }

        return preventiTargets;
    }

    public List<PreventiTargetVO> selectPreventis(String carId, String ownerId) throws SQLException {
        List<PreventiTargetVO> preventiTargets = new ArrayList<PreventiTargetVO>();
        HashMap<String, Integer> preventiTargetCarIdMap = new HashMap<String, Integer>();
        DBConnection dbConn = DBConnection.getInstance();
        StringBuilder selectQuery = new StringBuilder();
        int cnt = 0;

        selectQuery.append("select preventi_repair.car_id as car_id, ").append(" owner.owner_id as owner_id, ")
                .append(" resisted_car.car_model as car_model, ").append(" owner.tel,")
                .append(" resisted_car.drive_distance as drive_distance, ")
                .append(" case when reservation.car_id is null then ? else ? end as reservation_status, ")
                .append(" case when reserved_car.car_id is null then ? ")
                .append(" when reserved_car.maintenance_status = ? then ? ")
                .append(" when reserved_car.maintenance_status = ? then ? ")
                .append(" when reserved_car.maintenance_status = ? then ? ")
                .append(" else reserved_car.maintenance_status end as maintenance_status, ")
                .append(" preventi_repair.production_date as production_date, ")
                .append(" reservation.reservation_date, ").append(" part_info.part_name ").append(" from owner owner ")
                .append(" join resisted_car on resisted_car.owner_id = owner.owner_id ")
                .append(" left join preventi_repair on preventi_repair.car_id = resisted_car.car_id ")
                .append(" join reserved_car on resisted_car.car_id = reserved_car.car_id ")
                .append(" join car_maintenance_settlement on car_maintenance_settlement.car_id = reserved_car.car_id ")
                .append(" join reservation on reservation.car_id = preventi_repair.car_id ")
                .append(" join part_info on preventi_repair.part_code = part_info.part_code ").append(" where 1=1 ");

        boolean carExist = false;
        boolean ownerExist = false;

        if (!carId.isEmpty()) {
            selectQuery.append(" and preventi_repair.car_id = ? ");
            carExist = true;
        }
        if (!ownerId.isEmpty()) {
            selectQuery.append(" and owner.owner_id = ? ");
            ownerExist = true;
        }

        try {
            conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(selectQuery.toString());

            pstmt.setString(1, "x");
            pstmt.setString(2, "o");
            pstmt.setString(3, "입고전");
            pstmt.setString(4, "0");
            pstmt.setString(5, "입고전");
            pstmt.setString(6, "1");
            pstmt.setString(7, "정비대기");
            pstmt.setString(8, "2");
            pstmt.setString(9, "정비완료");
            if (carExist && !ownerExist) {
                pstmt.setString(10, carId);
            } else if (!carExist && ownerExist) {
                pstmt.setString(10, ownerId);
            } else if (carExist && ownerExist) {
                pstmt.setString(10, carId);
                pstmt.setString(11, ownerId);
            }

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                if (!preventiTargetCarIdMap.containsKey(resultSet.getString("car_id"))) {
                    preventiTargetCarIdMap.put(resultSet.getString("car_id"), cnt);
                    cnt++;
                    preventiTargets.add(new PreventiTargetVO(resultSet.getString("car_id"),
                            resultSet.getString("owner_id"), resultSet.getString("tel"),
                            resultSet.getString("car_model"), resultSet.getInt("drive_distance"),
                            resultSet.getString("reservation_status").equals("o") ? "Y" : "N",
                            resultSet.getString("maintenance_status"), resultSet.getDate("production_date"),
                            resultSet.getString("reservation_date"), resultSet.getString("part_name")));
                } else {
                    preventiTargets.get(preventiTargetCarIdMap.get(resultSet.getString("car_id")))
                            .addPart(resultSet.getString("part_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.dbClose(conn, pstmt, resultSet);
        }

        return preventiTargets;
    }

    public List<PreventiTargetVO> selectPersonalPreventi(String ownerId) {
        if (totalPreventiTarget == null) {
            try {
                selectAllPreventi();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        List<PreventiTargetVO> searchResult = new ArrayList<PreventiTargetVO>();
        List<Integer> ownCars = preventiTargetOwnerIdMap.get(ownerId);

        if (ownCars != null) {
            for (Integer ownNum : ownCars) {
                searchResult.add(totalPreventiTarget.get(ownNum));
            }
        }

        return searchResult;
    }

    public void deleteAllPreventiTargets() {
        DBConnection dbConn = DBConnection.getInstance();
        try {
            conn = dbConn.getConnection();
            StringBuilder deleteQuery = new StringBuilder("delete from preventi_repair");
            pstmt = conn.prepareStatement(deleteQuery.toString());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbConn.dbClose(conn, pstmt, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
