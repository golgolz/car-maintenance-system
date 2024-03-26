package kr.co.sist.admin.recall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kr.co.sist.dao.DBConnection;

public class RecallDAO {
    static private RecallDAO recallDAO;
    private List<RecallInfoVO> recallInfos;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;

    private RecallDAO() {
        try {
            selectAllRecallInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static public RecallDAO getInstance() {
        if (recallDAO == null) {
            recallDAO = new RecallDAO();
        }

        return recallDAO;
    }

    public String[] selectUserCarInfo(String ownerId) throws SQLException {
        List<String> userCarInfo = new ArrayList<String>();

        DBConnection dbConn = DBConnection.getInstance();

        try {
            conn = dbConn.getConnection();
            StringBuilder selectQuery = new StringBuilder("select car_id from resisted_car where owner_id = ?");
            pstmt = conn.prepareStatement(selectQuery.toString());
            pstmt.setString(1, ownerId);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                userCarInfo.add(resultSet.getString("car_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.dbClose(conn, pstmt, resultSet);
        }

        return userCarInfo.toArray(new String[0]);
    }

    public void selectAllRecallInfo() throws SQLException {
        recallInfos = new ArrayList<RecallInfoVO>();
        DBConnection dbConn = DBConnection.getInstance();

        try {
            StringBuilder selectQuery = new StringBuilder();
            selectQuery.append(
                    " select part_info.part_name, cmir.content, cmir.car_model, cmir.image, cmir.recall_occurrence_date ")
                    .append(" from car_model_info_recall cmir ")
                    .append(" join part_info on part_info.part_code = cmir.part_code ")
                    .append(" join resisted_car on resisted_car.car_model = cmir.car_model ");
            conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(selectQuery.toString());

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                recallInfos.add(new RecallInfoVO(resultSet.getString("part_name"), resultSet.getString("content"),
                        resultSet.getString("car_model"), resultSet.getDate("recall_occurrence_date"),
                        resultSet.getString("image")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.dbClose(conn, pstmt, resultSet);
        }
    }

    public RecallInfoVO selectOneRecallInfo(String carId) throws SQLException {
        RecallInfoVO recallInfo = null;
        DBConnection dbConn = DBConnection.getInstance();

        try {
            StringBuilder selectQuery = new StringBuilder();
            selectQuery.append(
                    " select part_info.part_name, cmir.content, cmir.car_model, cmir.image, cmir.recall_occurrence_date ")
                    .append(" from car_model_info_recall cmir ")
                    .append(" join part_info on part_info.part_code = cmir.part_code ")
                    .append(" join resisted_car on resisted_car.car_model = cmir.car_model ")
                    .append(" where resisted_car.car_id = ? ");
            conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(selectQuery.toString());
            pstmt.setString(1, carId);

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                recallInfo = new RecallInfoVO(resultSet.getString("part_name"), resultSet.getString("content"),
                        resultSet.getString("car_model"), resultSet.getDate("recall_occurrence_date"),
                        resultSet.getString("image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.dbClose(conn, pstmt, resultSet);
        }

        return recallInfo;
    }

    public int selectOneRecallTarget(String carId) throws SQLException {
        int cnt = 0;
        DBConnection dbConn = DBConnection.getInstance();

        try {
            conn = dbConn.getConnection();
            StringBuilder selectQuery = new StringBuilder();
            selectQuery.append(" select car_model_info_recall.car_model, vehicle_info_number.year ")
                    .append(" from resisted_car ")
                    .append(" join vehicle_info_number on substr(resisted_car.caridentity_number, length(caridentity_number) - 6, 1) = vehicle_info_number.letter ")
                    .append(" join car_model_info_recall on to_char(car_model_info_recall.recall_occurrence_date, ?) = vehicle_info_number.year ")
                    .append(" where resisted_car.caridentity_number = (select caridentity_number from resisted_car where car_id = ?) ");
            pstmt = conn.prepareStatement(selectQuery.toString());
            pstmt.setString(1, "yyyy");
            pstmt.setString(2, carId);

            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.dbClose(conn, pstmt, resultSet);
        }

        return cnt;
    }

    public List<RecallTargetVO> selectRecallTargets(String carId, String ownerId) {
        List<RecallTargetVO> recallTargets = new ArrayList<RecallTargetVO>();

        return recallTargets;
    }
}
