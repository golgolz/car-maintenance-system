package kr.co.sist.admin.manage.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InventoryEvent extends WindowAdapter implements ActionListener {

  private InventoryView inventoryView;
  private InventoryAddPanelView inventoryAddPanelView;
  private InventoryModifyPanelView inventoryModifyPanelView;

  public InventoryEvent(InventoryView inventoryView) {
    this.inventoryView = inventoryView;
    // this.inventoryAddPanelView = inventoryAddPanelView;

    inventoryView.getJbtnSelect().addActionListener(this); // 조회 버튼
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == inventoryView.getJbtnAdd()) {// 추가 패널로 화면 이동
      new InventoryAddPanelView();
    } else if (ae.getSource() == inventoryView.getJbtnUpdate()) {// 변경 패널로 화면 이동
      new InventoryModifyPanelView(inventoryView);
    } else if (ae.getSource() == inventoryView.getJbtnSelect()) {
      // jbtnSelect 버튼을 눌렀을 때
      searchAndDisplayInventory();
    }
  }

  private void searchAndDisplayInventory() {
    String searchValue = inventoryView.getJtaSelect().getText().trim();

    // 입력된 검색어 확인
    if (searchValue.isEmpty()) {
      JOptionPane.showMessageDialog(null, "검색어를 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
      return;
    }

    try {
      // InventoryDAO 객체 생성
      InventoryDAO inventoryDAO = InventoryDAO.getInstance();
      // Inventory 테이블에서 검색하여 결과 가져오기
      List<InventoryVO> searchResult = inventoryDAO.selectInventory(searchValue);

      // 가져온 결과가 없으면 메시지 출력 후 종료
      if (searchResult.isEmpty()) {
        JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        return;
      }

      // 테이블 모델 가져오기
      DefaultTableModel model = (DefaultTableModel) inventoryView.getJtInventoryDataTable().getModel();
      // 모델 초기화
      model.setRowCount(0);

      // 검색 결과를 테이블에 추가
      for (InventoryVO inventoryVO : searchResult) {
        Object[] row = {inventoryVO.getPartCode(), inventoryVO.getPartName(), inventoryVO.getPartInputDate(),
            inventoryVO.getPartPrice(), inventoryVO.getPartCnt()};
        model.addRow(row);
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(null, "데이터베이스 오류: " + ex.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
    }
  }

  @Override
  public void windowClosing(WindowEvent e) {
    inventoryView.dispose();
  }



}
