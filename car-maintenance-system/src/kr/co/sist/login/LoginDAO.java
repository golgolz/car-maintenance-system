package kr.co.sist.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import kr.co.sist.dao.DBConnection;
import kr.co.sist.user.register.user.UserInfoVO;

public class LoginDAO {
  private static LoginDAO loginDAO;
  private UserInfoVO userInfoVO;

  // 현재 로그인한 유저의 정보를 담을 수 있는 변수 currentUser

  private LoginDAO() {}

  public static LoginDAO getInstance() {
    if (loginDAO == null) {
      loginDAO = new LoginDAO();
    }
    return loginDAO;
  }

  /**
   * 회원의 모든 정보를 가져오는 메서드
   * 
   * @param id
   * @param pass
   * @return
   * @throws SQLException
   */
  // public UserInfoVO selectUserInfo(UserInfoVO uiVO) throws SQLException {
  // Connection con = null;
  // PreparedStatement pstmt = null;
  // ResultSet rs = null;
  // DBConnection dbCon = DBConnection.getInstance();
  //
  // try {
  // con = dbCon.getConnection();
  // StringBuilder selectLogin = new StringBuilder("select * from owner where owner_id = ? and pw =
  // ?");
  //
  // pstmt = con.prepareStatement(selectLogin.toString());
  // pstmt.setString(1, uiVO.getId());
  // pstmt.setString(2, uiVO.getPw());
  //
  // rs = pstmt.executeQuery();
  //
  // if (rs.next()) {
  // UserInfoVO user = new UserInfoVO();
  // user.setId(rs.getString("owner_id"));
  // user.setName(rs.getString("pw"));
  // return user;
  // } else {
  // JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다.");
  // return null;
  // }
  //
  // } finally {
  // dbCon.dbClose(con, pstmt, rs);
  // }
  //
  // }//end selectLogin

  /**
   * 유저의 로그인을 확인하는 메서드
   * 
   * @param owner_id
   * @param pw
   * @return
   * @throws SQLException
   */
  public LoginVO selectLoginInfo(String owner_id, String pw) throws SQLException {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    DBConnection dbCon = DBConnection.getInstance();
    LoginVO lVO = null;
    try {
      con = dbCon.getConnection();
      StringBuilder selectLogin = new StringBuilder("select owner_id,pw from owner where owner_id = ? and pw = ?");

      pstmt = con.prepareStatement(selectLogin.toString());
      pstmt.setString(1, owner_id);
      pstmt.setString(2, pw);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        lVO = new LoginVO(rs.getString("owner_id"), rs.getString("pw"));
      }
    } finally {
      dbCon.dbClose(con, pstmt, rs);
    }
    return lVO;
  }

  /**
   * 관리자의 로그인을 확인하는 메서드
   * 
   * @param owner_id
   * @param pw
   * @return
   * @throws SQLException
   */
  public LoginVO selectLoginAdmin(String admin_id, String admin_pw) throws SQLException {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    DBConnection dbCon = DBConnection.getInstance();
    LoginVO lVO = null;
    try {
      con = dbCon.getConnection();
      StringBuilder selectLogin =
          new StringBuilder("select admin_id,admin_pw from car_admin where admin_id = ? and admin_pw = ?");

      pstmt = con.prepareStatement(selectLogin.toString());
      pstmt.setString(1, admin_id);
      pstmt.setString(2, admin_pw);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        lVO = new LoginVO(rs.getString("admin_id"), rs.getString("admin_pw"));
      }
    } finally {
      dbCon.dbClose(con, pstmt, rs);
    }
    return lVO;
  }

}
