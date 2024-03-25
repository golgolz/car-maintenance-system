package kr.co.sist.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import kr.co.sist.dao.DBConnection;

public class LoginDAO {
  private static LoginDAO loginDAO;

  // 현재 로그인한 유저의 정보를 담을 수 있는 변수 currentUser

  private LoginDAO() {}

  public static LoginDAO getInstance() {
    if (loginDAO == null) {
      loginDAO = new LoginDAO();
    }
    return loginDAO;
  }

  public void selectLogin(LoginVO lVO) throws SQLException {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    DBConnection dbCon = DBConnection.getInstance();

    try {
      String id = "car";
      String pw = "golgol";

      con = dbCon.getConnection();
      StringBuilder selectLogin = new StringBuilder();
      selectLogin.append("  select name ").append("  from owner ")
          .append("  where id='" + lVO.getId() + "'and pw='" + lVO + "'");
    } finally {
      dbCon.dbClose(con, pstmt, rs);
    }

    LoginDAO lDAO = new LoginDAO();


  }

}
