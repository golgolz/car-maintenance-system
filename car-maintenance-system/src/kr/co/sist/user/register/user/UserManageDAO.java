package kr.co.sist.user.register.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kr.co.sist.admin.register.car.RegisteredCarVO;
import kr.co.sist.dao.DBConnection;

public class UserManageDAO {

    static private UserManageDAO userManageDAO;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private UserManageDAO() {}

    static public UserManageDAO getInstance() {
        if (userManageDAO == null) {
            userManageDAO = new UserManageDAO();
        }
        return userManageDAO;
    }

    /////////////////////// 중복확인///////////////////////////////////
    public boolean checkId(String owner_id) throws SQLException {
        boolean boolId = false;

        DBConnection dbConn = DBConnection.getInstance();
        try {
            conn = dbConn.getConnection();
            String checkId = "select owner_id from owner where owner_id=?";
            pstmt = conn.prepareStatement(checkId);
            pstmt.setString(1, owner_id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                boolId = true;
                // System.out.println(boolId);
                // 중복검사 통과하는 코드
            }
        } finally {
            dbConn.dbClose(conn, pstmt, rs);
        }

        return boolId;
    }

    //////////////////////////////////////////////////////////////////

    public void addUser(String owner_id, String pw, String tel, String name, String addr) throws SQLException {
        DBConnection dbconn = DBConnection.getInstance();

        try {
            conn = dbconn.getConnection();
            String insertUser =
                    "INSERT INTO owner(owner_id, pw, tel, name, addr, delete_flag) VALUES (?, ?, ?, ?, ?, 'x')";
            pstmt = conn.prepareStatement(insertUser);

            pstmt.setString(1, owner_id);
            pstmt.setString(2, pw);
            pstmt.setString(3, tel);
            pstmt.setString(4, name);
            pstmt.setString(5, addr);

            pstmt.executeUpdate();
        } finally {
            dbconn.dbClose(conn, pstmt, rs);
        }
    }

    public void addCar(String car_id, String car_model, String production_date, String drive_distance)
            throws SQLException {
        DBConnection dbconn = DBConnection.getInstance();

        try {
            conn = dbconn.getConnection();
            String insertUser =
                    "insert into resisted_car(CAR_ID, CARIDENTITY_NUMBER, OWNER_ID, CAR_MODEL, PRODUCTION_DATE, REGISTRATION_DATE, CAR_YEAR, DRIVE_DISTANCE, RECALL_FLAG, DELETE_FLAG)\n"
                            + "values(?, null, null, ?, ?, sysdate, null, ?, null, 'x')";
            pstmt = conn.prepareStatement(insertUser);

            pstmt.setString(1, car_id);
            pstmt.setString(2, car_model);
            pstmt.setString(3, production_date);
            pstmt.setString(4, drive_distance);

            pstmt.executeUpdate();
        } finally {
            dbconn.dbClose(conn, pstmt, rs);
        }
    }

    public List<UserInfoVO> selectAllUser() throws SQLException {
        List<UserInfoVO> user = new ArrayList<UserInfoVO>();

        DBConnection dbConn = DBConnection.getInstance();
        try {
            conn = dbConn.getConnection();
            StringBuilder selectUser = new StringBuilder();
            selectUser.append("   SELECT o.owner_id, o.name, o.addr, o.tel, r.car_id  ").append("   FROM owner o   ")
                    .append("   JOIN (  ").append("    SELECT owner_id, car_id, registration_date,   ")
                    .append("           ROW_NUMBER() OVER (PARTITION BY owner_id ORDER BY registration_date DESC) AS row_num")
                    .append("    FROM resisted_car   ").append(") r ON o.owner_id = r.owner_id   ")
                    .append("   WHERE r.row_num = 1  ");
            pstmt = conn.prepareStatement(selectUser.toString());

            rs = pstmt.executeQuery();

            UserInfoVO uiVO = null;
            RegisteredCarVO rcVO = null;
            while (rs.next()) {
                rcVO = new RegisteredCarVO(rs.getString("car_id"));
                uiVO = new UserInfoVO(rs.getString("owner_id"), rs.getString("name"), rs.getString("tel"),
                        rs.getString("addr"), new ArrayList<RegisteredCarVO>(Arrays.asList(rcVO)));
                user.add(uiVO);
            }
        } finally {
            dbConn.dbClose(conn, pstmt, rs);
        }

        return user;
    }// selectAllUser

    public UserInfoVO selectOneUser(String ownerId) throws SQLException {

        DBConnection dbConn = DBConnection.getInstance();
        UserInfoVO uiVO = null;
        try {
            conn = dbConn.getConnection();
            StringBuilder selectUser = new StringBuilder();
            selectUser.append("   SELECT o.owner_id, o.name, o.addr, o.tel, r.car_id  ").append("   FROM owner o   ")
                    .append("   JOIN (  ").append("    SELECT owner_id, car_id, registration_date,   ")
                    .append("           ROW_NUMBER() OVER (PARTITION BY owner_id ORDER BY registration_date DESC) AS row_num")
                    .append("    FROM resisted_car   ").append(") r ON o.owner_id = r.owner_id   ")
                    .append("   WHERE o.owner_id = ? AND r.row_num = 1  ");
            pstmt = conn.prepareStatement(selectUser.toString());

            pstmt.setString(1, ownerId);

            rs = pstmt.executeQuery();

            RegisteredCarVO rcVO = null;
            while (rs.next()) {
                // rcVO = new RegisteredCarVO(rs.getString("car_id"));
                uiVO = new UserInfoVO(rs.getString("owner_id"), rs.getString("name"), rs.getString("tel"),
                        rs.getString("addr"), new ArrayList<RegisteredCarVO>(Arrays.asList(rcVO)));
            }
        } finally {
            dbConn.dbClose(conn, pstmt, rs);
        }
        return uiVO;
    }// selectAllUser


}
