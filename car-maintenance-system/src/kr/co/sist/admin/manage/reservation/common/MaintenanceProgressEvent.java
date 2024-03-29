package kr.co.sist.admin.manage.reservation.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MaintenanceProgressEvent implements ActionListener {

  private MaintenanceProgressView maintenanceProgressView;
  private MaintenanceProgressDAO maintenanceProgressDAO;



  public MaintenanceProgressEvent(MaintenanceProgressView view, MaintenanceProgressDAO dao) {
    this.maintenanceProgressView = view;
    this.maintenanceProgressDAO = dao;

    // 버튼에 이벤트 리스너 추가
    view.getJbtnInsert().addActionListener(this);
    view.getJbtnDelete().addActionListener(this);
    view.getJbtnConfirm().addActionListener(this);
    view.getJbtnCancel().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == maintenanceProgressView.getJbtnInsert()) {
      insertPartInfo();
    } else if (e.getSource() == maintenanceProgressView.getJbtnConfirm()) {
      confirmMaintenance();
    }
  }

  private void confirmMaintenance() {
    DefaultTableModel model = maintenanceProgressView.getMaintenanceProgress();
    HashMap<String, Integer> partsCountMap = new HashMap<>();
    HashMap<String, String> partsNameMap = new HashMap<>();

    // 테이블의 데이터를 순회하며 부품 코드와 수량을 합산합니다.
    for (int i = 0; i < model.getRowCount(); i++) {
      String partCode = (String) model.getValueAt(i, 0);
      int partCnt = (Integer) model.getValueAt(i, 2);
      partsCountMap.merge(partCode, partCnt, Integer::sum);
      partsNameMap.putIfAbsent(partCode, (String) model.getValueAt(i, 1));
    }

    // 합산된 데이터를 바탕으로 DB에 삽입합니다.
    partsCountMap.forEach((partCode, partCnt) -> {
      try {
        String partName = partsNameMap.get(partCode);
        maintenanceProgressDAO.addPartInfo(partCode, partCnt, partName, "일반"); // 예시에서 '일반'는
                                                                               // maintenanceClassification입니다.
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "데이터베이스 삽입 중 오류가 발생했습니다.");
        e.printStackTrace();
      }
    });

    JOptionPane.showMessageDialog(null, "정비 정보가 성공적으로 등록되었습니다.");
  }

  private void insertPartInfo() {
    String partCode = maintenanceProgressView.getJtfPartCode().getText();
    String partName = maintenanceProgressView.getJtfPartName().getText();
    int partCnt;

    try {
      partCnt = Integer.parseInt(maintenanceProgressView.getJtfPartCnt().getText());
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null, "수량은 숫자여야 합니다.");
      return;
    }

    try {
      // 부품 코드가 일치하는 데이터 가져오기
      List<MaintenanceProgressVO> maintenanceProgressList = maintenanceProgressDAO.getGeneralMaintenanceData();
      boolean found = false;
      for (MaintenanceProgressVO data : maintenanceProgressList) {
        if (data.getPartCode().equals(partCode)) {
          found = true;

          // 총 가격 계산
          int totalPrice = data.getPartPrice() * partCnt;

          // 테이블에 데이터 추가
          maintenanceProgressView.getMaintenanceProgress()
              .addRow(new Object[] {partCode, partName, partCnt, totalPrice});

          // 입력 필드 초기화
          maintenanceProgressView.getJtfPartCode().setText("");
          maintenanceProgressView.getJtfPartName().setText("");
          maintenanceProgressView.getJtfPartCnt().setText("");
          updateTotalPrice();

          JOptionPane.showMessageDialog(null, "부품 정보가 추가되었습니다.");
          break;
        }
      }
      if (!found) {
        JOptionPane.showMessageDialog(null, "해당 부품 코드의 데이터가 존재하지 않습니다.");
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(null, "데이터베이스 오류가 발생했습니다.");
    }
  }

  public void updateTotalPrice() {
    int total = 0;
    DefaultTableModel model = (DefaultTableModel) maintenanceProgressView.getMaintenanceProgressTable().getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
      total += (Integer) model.getValueAt(i, 3); // 가정: 4번째 열이 가격 정보를 담고 있음
    }
    maintenanceProgressView.updateTotalPriceInTextArea(String.valueOf(total));
  }

}
