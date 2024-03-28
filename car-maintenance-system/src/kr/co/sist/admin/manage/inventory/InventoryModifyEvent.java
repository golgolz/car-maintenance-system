package kr.co.sist.admin.manage.inventory;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InventoryModifyEvent {
  private InventoryModifyPanelView modifyPanelView;
  private InventoryView inventoryView;
  private InventoryDAO inventoryDAO;

  public InventoryModifyEvent(InventoryModifyPanelView modifyPanelView, InventoryView inventoryView2) {
    this.modifyPanelView = modifyPanelView;
    this.inventoryView = inventoryView2;
    this.inventoryDAO = new InventoryDAO();

    // 테이블에 마우스 클릭 이벤트 리스너 등록
    inventoryView.getJtInventoryDataTable().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int selectedRow = inventoryView.getJtInventoryDataTable().getSelectedRow();
        if (selectedRow != -1) {
          // 테이블에서 선택된 행의 데이터를 가져와서 입력 필드에 설정
          DefaultTableModel model = (DefaultTableModel) inventoryView.getJtInventoryDataTable().getModel();
          String partPrice = model.getValueAt(selectedRow, 3).toString();
          String partCount = model.getValueAt(selectedRow, 4).toString();
          modifyPanelView.getJtaPrice().setText(partPrice);
          modifyPanelView.getJtaCount().setText(partCount);
        }
      }
    });

    // 수정 버튼 클릭 이벤트 리스너 등록
    modifyPanelView.getJbtnModify().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        modifyInventory();
      }
    });

    // 삭제 버튼 클릭 이벤트 리스너 등록
    modifyPanelView.getJbtnDelete().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        deleteInventory();
      }
    });
  }

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == modifyPanelView.getJbtnModify()) {// 추가 패널로 화면 이동
      modifyInventory();
    } else if (ae.getSource() == inventoryView.getJbtnUpdate()) {// 변경 패널로 화면 이동
      new InventoryModifyPanelView(inventoryView);
    } else if (ae.getSource() == modifyPanelView.getJbtnDelete()) {
      // jbtnSelect 버튼을 눌렀을 때
      deleteInventory();
    }
  }

  // 부품 정보 수정 메소드
  void modifyInventory() {
    int selectedRow = inventoryView.getJtInventoryDataTable().getSelectedRow();
    if (selectedRow != -1) {
      String partCode = inventoryView.getJtInventoryDataTable().getValueAt(selectedRow, 0).toString();
      String newPriceText = modifyPanelView.getJtaPrice().getText().trim();
      String newCountText = modifyPanelView.getJtaCount().getText().trim();

      if (!newPriceText.isEmpty() && !newCountText.isEmpty()) {
        try {
          int newPrice = Integer.parseInt(newPriceText);
          int newCount = Integer.parseInt(newCountText);
          // 수정 DAO 메소드 호출
          try {
            inventoryDAO.updateInventory(partCode, newPrice, newCount);
          } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          JOptionPane.showMessageDialog(modifyPanelView, "부품 정보가 수정되었습니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(modifyPanelView, "가격과 수량은 숫자로 입력해야 합니다.", "Error", JOptionPane.ERROR_MESSAGE);
        }
      } else {
        JOptionPane.showMessageDialog(modifyPanelView, "가격과 수량을 입력해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(modifyPanelView, "부품을 선택해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  // 부품 정보 삭제 메소드
  void deleteInventory() {
    int selectedRow = inventoryView.getJtInventoryDataTable().getSelectedRow();
    if (selectedRow != -1) {
      String partCode = inventoryView.getJtInventoryDataTable().getValueAt(selectedRow, 0).toString();
      int confirm =
          JOptionPane.showConfirmDialog(modifyPanelView, "정말로 삭제하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
      if (confirm == JOptionPane.YES_OPTION) {
        // 삭제 DAO 메소드 호출
        try {
          inventoryDAO.deleteInventory(partCode);
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        JOptionPane.showMessageDialog(modifyPanelView, "부품 정보가 삭제되었습니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(modifyPanelView, "부품을 선택해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
