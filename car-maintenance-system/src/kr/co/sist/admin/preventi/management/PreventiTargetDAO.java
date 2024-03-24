package kr.co.sist.admin.preventi.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kr.co.sist.admin.register.car.RegisteredCarVO;
import kr.co.sist.dao.DBConnection;

public class PreventiTargetDAO {
    static private PreventiTargetDAO preventiTargetDAO;
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet resultSet;

    private PreventiTargetDAO() {}

    static public PreventiTargetDAO getInstance() {
        if (preventiTargetDAO == null) {
            preventiTargetDAO = new PreventiTargetDAO();
        }

        return preventiTargetDAO;
    }

    public int insertAllPreventiTargets(List<RegisteredCarVO> registeredCars) {
        int cnt = 0;

        return cnt;
    }

    public List<PreventiTargetVO> selectAllPreventi() {
        List<PreventiTargetVO> preventiTargets = new ArrayList<PreventiTargetVO>();
        DBConnection dbConn = DBConnection.getInstance();
        StringBuilder selectQuery = new StringBuilder();

        selectQuery.append("select preventi_repair.car_id as car_id, ").append(" owner.owner_id as owner_id, ")
                .append(" resisted_car.car_model as car_model, ").append(" owner.tel,")
                .append(" resisted_car.drive_distance as drive_distance, ")
                .append(" case when reservation.car_id is null then ? else ? end as reservation_status, ")
                .append(" case when reserved_car.car_id is null then ? ")
                .append(" when reserved_car.repair_car = ? then ? ").append(" when reserved_car.repair_car = ? then ? ")
                .append(" when reserved_car.repair_car = ? then ? ")
                .append(" else reserved_car.repair_car end as maintenance_status, ")
                .append(" preventi_repair.production_date as production_date, ")
                .append(" reservation.reservation_date, ").append(" part_info.part_name ").append(" from owner owner ")
                .append(" join resisted_car on resisted_car.owner_id = owner.owner_id ")
                .append(" join preventi_repair on preventi_repair.car_id = resisted_car.car_id ")
                .append(" join reserved_car on resisted_car.car_id = reserved_car.car_id ")
                .append(" join car_maintenance_settlement on car_maintenance_settlement.car_id = reserved_car.car_id ")
                .append(" join reservation on reservation.car_id = preventi_repair.car_id ")
                .append(" join part_info on car_maintenance_settlement.maintenance_classification = part_info.part_name ");
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

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                preventiTargets.add(new PreventiTargetVO(resultSet.getString("car_id"), resultSet.getString("owner_id"),
                        resultSet.getString("tel"), resultSet.getString("car_model"),
                        resultSet.getInt("drive_distance"),
                        resultSet.getString("reservation_status").equals("o") ? "Y" : "N",
                        resultSet.getString("maintenance_status"), resultSet.getDate("production_date"),
                        resultSet.getDate("reservation_date"), resultSet.getString("part_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preventiTargets;
    }

    public List<PreventiTargetVO> selectPreventis(String carId, String ownerId) {
        List<PreventiTargetVO> preventiTargets = new ArrayList<PreventiTargetVO>();
        DBConnection dbConn = DBConnection.getInstance();
        StringBuilder selectQuery = new StringBuilder();

        selectQuery.append("select preventi_repair.car_id as car_id, ").append(" owner.owner_id as owner_id, ")
                .append(" resisted_car.car_model as car_model, ").append(" owner.tel,")
                .append(" resisted_car.drive_distance as drive_distance, ")
                .append(" case when reservation.car_id is null then ? else ? end as reservation_status, ")
                .append(" case when reserved_car.car_id is null then ? ")
                .append(" when reserved_car.repair_car = ? then ? ").append(" when reserved_car.repair_car = ? then ? ")
                .append(" when reserved_car.repair_car = ? then ? ")
                .append(" else reserved_car.repair_car end as maintenance_status, ")
                .append(" preventi_repair.production_date as production_date, ")
                .append(" reservation.reservation_date, ").append(" part_info.part_name ").append(" from owner owner ")
                .append(" join resisted_car on resisted_car.owner_id = owner.owner_id ")
                .append(" join preventi_repair on preventi_repair.car_id = resisted_car.car_id ")
                .append(" join reserved_car on resisted_car.car_id = reserved_car.car_id ")
                .append(" join car_maintenance_settlement on car_maintenance_settlement.car_id = reserved_car.car_id ")
                .append(" join reservation on reservation.car_id = preventi_repair.car_id ")
                .append(" join part_info on car_maintenance_settlement.maintenance_classification = part_info.part_name ")
                .append(" where 1=1 ");

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
                preventiTargets.add(new PreventiTargetVO(resultSet.getString("car_id"), resultSet.getString("owner_id"),
                        resultSet.getString("tel"), resultSet.getString("car_model"),
                        resultSet.getInt("drive_distance"),
                        resultSet.getString("reservation_status").equals("o") ? "Y" : "N",
                        resultSet.getString("maintenance_status"), resultSet.getDate("production_date"),
                        resultSet.getDate("reservation_date"), resultSet.getString("part_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preventiTargets;
    }

    public int deleteAllPreventiTargets() {
        int cnt = 0;

        return cnt;
    }
}
