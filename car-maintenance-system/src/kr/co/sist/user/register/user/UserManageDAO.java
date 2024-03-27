package kr.co.sist.user.register.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
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

  /////////////////////////////////////////////////////////////////////
  public boolean checkId(String owner_id) throws SQLException {
    boolean boolId = false;

    DBConnection dbConn = DBConnection.getInstance();
    Connection connection = null;
    PreparedStatement pstmtPreparedStatement = null;
    ResultSet rs = null;
    try {
      conn = dbConn.getConnection();
      String checkId = "select owner_id from owner where owner_id=?";
      pstmt = connection.prepareStatement(checkId);
      pstmt.setString(1, owner_id);
      rs = pstmtPreparedStatement.executeQuery();

      if (rs.next()) {
        if (rs.getString("owner_id").isEmpty()) {
          boolId = true;
          // 중복검사 통과하는 코드
        } else {
          JOptionPane.showMessageDialog(null, "이름 중복");
        }
      }
    } finally {
      dbConn.dbClose(conn, pstmt, rs);
    }

    return boolId;
  }

  /////////////////////////////////////////////////////////////////////
  public List<UserInfoVO> selectAllUser(String ownerId) throws SQLException {
    List<UserInfoVO> user = new ArrayList<UserInfoVO>();

    DBConnection dbConn = DBConnection.getInstance();
    try {
      conn = dbConn.getConnection();
      StringBuilder selectUser = new StringBuilder();
      selectUser.append("   SELECT o.owner_id, o.name, o.addr, o.tel, r.car_id  ").append("   FROM owner o   ")
          .append("   JOIN (  ").append("    SELECT owner_id, car_id, registration_date,   ")
          .append("           ROW_NUMBER() OVER (PARTITION BY owner_id ORDER BY registration_date DESC) AS row_num")
          .append("    FROM resisted_car   ").append(") r ON o.owner_id = r.owner_id   ")
          .append("   WHERE o.owner_id = 'lee' AND r.row_num = 1  ");
      pstmt = conn.prepareStatement(selectUser.toString());

      pstmt.setString(1, ownerId);

      rs = pstmt.executeQuery();

      UserInfoVO uiVO = null;
      RegisteredCarVO rcVO = null;
      while (rs.next()) {
        rcVO = new RegisteredCarVO(rs.getString("car_id"));
        uiVO = new UserInfoVO(rs.getString("owner_id"), rs.getString("pw"), false, rs.getString("name"),
            rs.getString("tel"), rs.getString("addr"), new ArrayList<RegisteredCarVO>(Arrays.asList(rcVO)));
        user.add(uiVO);
      }
    } finally {
      dbConn.dbClose(conn, pstmt, rs);
    }

    return user;
  }// selectAllUser



}
