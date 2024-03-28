package kr.co.sist.admin.manage.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import kr.co.sist.dao.DBConnection;

public class PartInfoDAO {

  public void insertPartInfo(PartInfoVO partInfoVO) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      conn = DBConnection.getInstance().getConnection();
      String insertPartInfoQuery = "INSERT INTO part_info (part_code, part_name) VALUES (?, ?)";
      pstmt = conn.prepareStatement(insertPartInfoQuery);
      pstmt.setString(1, partInfoVO.getPartCode());
      pstmt.setString(2, partInfoVO.getPartName());

      pstmt.executeUpdate();
    } finally {
      // Close resources
      DBConnection.getInstance().close(conn, pstmt);
    }
  }
}
