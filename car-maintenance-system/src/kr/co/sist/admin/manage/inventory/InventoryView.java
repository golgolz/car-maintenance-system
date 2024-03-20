package kr.co.sist.admin.manage.inventory;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InventoryView {
  private JLabel inventoryLabel;
  private JButton selectBtn;
  private JButton addBtn;
  private JButton updateBtn;

  private JTextField selectField;

  private DefaultTableModel defaultInventoryData;
  private JTable inventoryDataTable;
  private JScrollPane inventoryDataScroll;

  private JDialog inventoryAddDialogView;
  private JDialog inventoryModifyDialogView;

  InventoryView() {
    inventoryLabel = new JLabel();
    selectBtn = new JButton("조회");
    addBtn = new JButton("추가");
    updateBtn = new JButton("변경");
    selectField = new JTextField("재고명을 입력하세요");
    defaultInventoryData = new DefaultTableModel();
    inventoryDataTable = new JTable();
    inventoryDataScroll = new JScrollPane();
    inventoryAddDialogView = new JDialog();
    inventoryModifyDialogView = new JDialog();


  }

}
