package kr.co.sist.admin.manage.inventory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kr.co.sist.dao.DBConnection;

public class InventoryDAO {
  // 싱글턴 패턴
  private static InventoryDAO ivDAO;

  // 생성자
  InventoryDAO() {

  }// MonthlyCarMaintenanceVDAO

  static InventoryDAO getInstance() {
    if (ivDAO == null) {
      ivDAO = new InventoryDAO();
    }
    return ivDAO;
  }// getInstance

  public List<InventoryVO> selectInventory(String partName) throws SQLException {// 조회

    DBConnection dbConn = DBConnection.getInstance();
    List<InventoryVO> inventoryList = new ArrayList<>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = dbConn.getConnection();
      String query = "SELECT * FROM inventory WHERE part_name LIKE ?";
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, "%" + partName + "%");
      rs = pstmt.executeQuery();

      while (rs.next()) {
        String partCode = rs.getString("part_code");
        String retrievedPartName = rs.getString("part_name");
        int partPrice = rs.getInt("part_price");
        int partCnt = rs.getInt("part_cnt");
        Date partInputDate = rs.getDate("part_inputdate");

        InventoryVO inventoryVO = new InventoryVO(partCode, retrievedPartName, partPrice, partCnt, partInputDate);
        inventoryList.add(inventoryVO);
      }
    } finally {
      dbConn.dbClose(conn, pstmt, rs);
    }

    return inventoryList;
  }// selectInventory


  // 부품 정보 추가 메서드
  public void addPartInfo(String partCode, String partName) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      conn = DBConnection.getInstance().getConnection();
      String insertPartInfoQuery = "INSERT INTO part_info (part_code, part_name) VALUES (?, ?)";
      pstmt = conn.prepareStatement(insertPartInfoQuery);
      pstmt.setString(1, partCode);
      pstmt.setString(2, partName);
      pstmt.executeUpdate();
    } finally {
      // Close resources
      DBConnection.getInstance().close(conn, pstmt);
    }
  }

  // 재고 추가 메서드
  public void addInventory(InventoryVO inventoryVO) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      conn = DBConnection.getInstance().getConnection();

      // 부품 정보가 이미 존재하는지 확인
      String checkPartInfoQuery = "SELECT COUNT(*) FROM part_info WHERE part_code = ?";
      pstmt = conn.prepareStatement(checkPartInfoQuery);
      pstmt.setString(1, inventoryVO.getPartCode());
      ResultSet rs = pstmt.executeQuery();

      if (rs.next() && rs.getInt(1) == 0) {
        // 부품 정보가 없는 경우 부품 정보를 추가
        addPartInfo(inventoryVO.getPartCode(), inventoryVO.getPartName());
      }

      // 재고 추가
      String insertInventoryQuery =
          "INSERT INTO inventory (part_code, part_name, part_inputdate, part_price, part_cnt, delete_flag) "
              + "VALUES (?, ?, sysdate, ?, ?, 'x')";
      pstmt = conn.prepareStatement(insertInventoryQuery);
      pstmt.setString(1, inventoryVO.getPartCode());
      pstmt.setString(2, inventoryVO.getPartName());
      pstmt.setInt(3, inventoryVO.getPartPrice());
      pstmt.setInt(4, inventoryVO.getPartCnt());
      pstmt.executeUpdate();
    } finally {
      // Close resources
      DBConnection.getInstance().close(conn, pstmt);
    }
  }

  // 수정
  public void updateInventory(String partCode, int newPrice, int newCnt) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      conn = DBConnection.getInstance().getConnection();
      String updateInventoryQuery = "UPDATE inventory SET part_price = ?, part_cnt = ? WHERE part_code = ?";
      pstmt = conn.prepareStatement(updateInventoryQuery);
      pstmt.setInt(1, newPrice);
      pstmt.setInt(2, newCnt);
      pstmt.setString(3, partCode);

      int rowsAffected = pstmt.executeUpdate();
      if (rowsAffected == 0) {
        // 변경할 부품 정보가 존재하지 않는 경우 예외 처리
        throw new SQLException("부품 정보가 존재하지 않습니다.");
      }
    } finally {
      // Close resources
      DBConnection.getInstance().close(conn, pstmt);
    }
  }

  // 삭제
  public void deleteInventory(String partCode) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      conn = DBConnection.getInstance().getConnection();
      String deleteInventoryQuery = "DELETE FROM inventory WHERE part_code = ?";
      pstmt = conn.prepareStatement(deleteInventoryQuery);
      pstmt.setString(1, partCode);

      int rowsAffected = pstmt.executeUpdate();
      if (rowsAffected == 0) {
        // 삭제할 부품 정보가 존재하지 않는 경우 예외 처리
        throw new SQLException("부품 정보가 존재하지 않습니다.");
      }
    } finally {
      // Close resources
      DBConnection.getInstance().close(conn, pstmt);
    }
  }

}


