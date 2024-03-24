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
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;

    private RecallDAO() {}

    static public RecallDAO getInstance() {
        if (recallDAO == null) {
            recallDAO = new RecallDAO();
        }

        return recallDAO;
    }

    public RecallInfoVO selectOneRecallInfo(String carId) {
        RecallInfoVO recallInfo = null;
        DBConnection dbConn = DBConnection.getInstance();

        try {
            StringBuilder selectQuery = new StringBuilder();
            selectQuery.append(" select part_info.part_name, cmir.car_model, cmir.image, cmir.content ")
                    .append(" from car_model_info_recall cmir ")
                    .append(" join part_info on part_info.part_code = cmir.part_code ")
                    .append(" join resisted_car on resisted_car.car_model = cmir.car_model ")
                    .append(" where resisted_car.car_id = ? ");
            conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(selectQuery.toString());
            pstmt.setString(1, carId);

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                recallInfo = new RecallInfoVO(resultSet.getString("part_name"), resultSet.getString("car_model"),
                        resultSet.getString("image"));
                // System.out.println(resultSet.getString("content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbConn.dbClose(conn, pstmt, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return recallInfo;
    }

    public List<RecallTargetVO> selectAllRecallTarget() {
        List<RecallTargetVO> recallTargets = new ArrayList<RecallTargetVO>();

        return recallTargets;
    }

    public List<RecallTargetVO> selectRecallTargets(String carId, String ownerId) {
        List<RecallTargetVO> recallTargets = new ArrayList<RecallTargetVO>();

        return recallTargets;
    }
}
