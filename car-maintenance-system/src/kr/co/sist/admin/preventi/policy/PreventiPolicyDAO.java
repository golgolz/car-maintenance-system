package kr.co.sist.admin.preventi.policy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kr.co.sist.dao.DBConnection;

public class PreventiPolicyDAO {
    private static PreventiPolicyDAO preventiPolicyDAO;
    private List<PreventiPolicyVO> policies;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;

    private PreventiPolicyDAO() {}

    public static PreventiPolicyDAO getInstance() {
        if (preventiPolicyDAO == null) {
            preventiPolicyDAO = new PreventiPolicyDAO();
        }

        return preventiPolicyDAO;
    }

    public List<PreventiPolicyVO> getPolicies() {
        if (policies == null) {
            try {
                policies = selectAllPolicies();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return policies;
    }

    public List<PreventiPolicyVO> selectAllPolicies() throws SQLException {
        List<PreventiPolicyVO> policies = new ArrayList<PreventiPolicyVO>();

        DBConnection dbConn = DBConnection.getInstance();

        try {
            conn = dbConn.getConnection();
            StringBuilder selectQuery = new StringBuilder();
            selectQuery.append("select inventory.part_code, inventory.part_name, distance, production_date, content")
                    .append(" from preventi_policy ")
                    .append(" join inventory on inventory.part_code = preventi_policy.part_code ");
            pstmt = conn.prepareStatement(selectQuery.toString());

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                policies.add(new PreventiPolicyVO(resultSet.getString("part_code"), resultSet.getString("part_name"),
                        resultSet.getInt("distance"), resultSet.getInt("production_date"),
                        resultSet.getString("content")));
            }
        } finally {
            dbConn.dbClose(conn, pstmt, resultSet);
        }
        return policies;
    }
}
