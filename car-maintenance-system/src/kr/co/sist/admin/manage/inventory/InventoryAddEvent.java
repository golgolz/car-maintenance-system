package kr.co.sist.admin.manage.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class InventoryAddEvent implements ActionListener {
  private InventoryAddPanelView addPanelView;

  public InventoryAddEvent(InventoryAddPanelView addPanelView) {
    this.addPanelView = addPanelView;
    // 확인 버튼에 이벤트 리스너 등록
    addPanelView.getJbtnConfirm().addActionListener(this);
    // 취소 버튼에 이벤트 리스너 등록
    addPanelView.getJbtnCancel().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == addPanelView.getJbtnConfirm()) {
      // 확인 버튼이 클릭된 경우
      addInventory();
    } else if (e.getSource() == addPanelView.getJbtnCancel()) {
      // 취소 버튼이 클릭된 경우
      clearFields();
    }
  }

  // 재고 추가 메소드
  private void addInventory() {
    // 필드에서 값 읽기
    String partCode = addPanelView.getJtfPartCode().getText().trim();
    String partName = addPanelView.getJtfName().getText().trim();
    String partPriceText = addPanelView.getJtfPrice().getText().trim();
    String partCntText = addPanelView.getJtfCount().getText().trim();

    // 입력 값 검증 (빈 값 검사 및 숫자 포맷 검사)
    if (partCode.isEmpty() || partName.isEmpty() || partPriceText.isEmpty() || partCntText.isEmpty()) {
      JOptionPane.showMessageDialog(addPanelView, "모든 필드를 입력해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    if (!isNumeric(partPriceText) || !isNumeric(partCntText)) {
      JOptionPane.showMessageDialog(addPanelView, "가격과 수량은 숫자로 입력해야 합니다.", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    int partPrice = Integer.parseInt(partPriceText);
    int partCnt = Integer.parseInt(partCntText);

    InventoryVO inventoryVO = new InventoryVO(partCode, partName, partPrice, partCnt);

    try {
      // 부품 정보 추가
      PartInfoDAO partInfoDAO = new PartInfoDAO();
      PartInfoVO partInfoVO = new PartInfoVO(partCode, partName);
      partInfoDAO.insertPartInfo(partInfoVO);

      // 재고 추가
      InventoryDAO inventoryDAO = new InventoryDAO();
      inventoryDAO.addInventory(inventoryVO);

      JOptionPane.showMessageDialog(addPanelView, "부품 정보 및 재고가 추가되었습니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
      clearFields();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(addPanelView, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
      clearFields(); // 실패해도 필드를 정리합니다.
    }
  }

  // 숫자인지 검증하는 메소드 (예시)
  private boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  // 입력 필드를 정리하는 메소드
  private void clearFields() {
    addPanelView.getJtfPartCode().setText("");
    addPanelView.getJtfName().setText("");
    addPanelView.getJtfPrice().setText("");
    addPanelView.getJtfCount().setText("");
  }
}
