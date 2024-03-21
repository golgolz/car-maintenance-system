package kr.co.sist.admin.manage.inventory;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class InventoryView extends JFrame {

  private InventoryEvent inventoryEvent;

  private JLabel jlInventory;
  private JButton jbtnSelect;
  private JButton jbtnAdd;
  private JButton jbtnUpdate;

  private JTextField jtaSelect;

  private DefaultTableModel dtmDefaultInventoryData;
  private JTable jtInventoryDataTable;
  private JScrollPane jspInventoryData;

  private JDialog jdInventoryAddDialogView;
  private JDialog jdInventoryModifyDialogView;



  public InventoryView() {
    super("차량 정보 관리");

    inventoryEvent = new InventoryEvent(this);

    jlInventory = new JLabel("부품 재고 관리");
    jbtnSelect = new JButton("조회");
    jbtnAdd = new JButton("추가");
    jbtnUpdate = new JButton("변경");
    jtaSelect = new JTextField(10);

    String[] header = {"코드", "이름", "판매가격", "재고량", "입고 일자"};
    String[][] contents =
        {{"ENGO0321", "엔진오일", "20000", "15", "2024-03-10"}, {"AUTO0302", "오토미션오일", "30000", "14", "2024-02-10"}};

    dtmDefaultInventoryData = new DefaultTableModel(contents, header);
    jtInventoryDataTable = new JTable(dtmDefaultInventoryData);
    jspInventoryData = new JScrollPane(jtInventoryDataTable);
    // jtInventoryDataTable.setModel(dtmDefaultInventoryData);
    // jspInventoryDataScroll.setViewportView(jtInventoryDataTable); // 테이블 스크롤 형식 설정

    jdInventoryAddDialogView = new JDialog();
    jdInventoryModifyDialogView = new JDialog();



    setLayout(null);

    jlInventory.setBounds(20, 10, 100, 30);
    jtaSelect.setBounds(580, 15, 150, 30);
    jbtnSelect.setBounds(740, 15, 80, 30);
    jspInventoryData.setBounds(20, 80, 780, 300);
    jbtnAdd.setBounds(600, 390, 80, 30);
    jbtnUpdate.setBounds(700, 390, 80, 30);

    add(jlInventory);
    add(jtaSelect);
    add(jbtnSelect);

    add(jbtnAdd);
    add(jbtnUpdate);

    add(jspInventoryData);


    jbtnAdd.addActionListener(inventoryEvent);
    addWindowListener(inventoryEvent);

    setBounds(200, 320, 840, 480);


    setVisible(true);
    setResizable(false);
  }// InventoryView


  public InventoryEvent getInventoryEvent() {
    return inventoryEvent;
  }


  public JLabel getJlInventory() {
    return jlInventory;
  }


  public JButton getJbtnSelect() {
    return jbtnSelect;
  }


  public JButton getJbtnAdd() {
    return jbtnAdd;
  }


  public JButton getJbtnUpdate() {
    return jbtnUpdate;
  }


  public JTextField getJtaSelect() {
    return jtaSelect;
  }


  public DefaultTableModel getDtmDefaultInventoryData() {
    return dtmDefaultInventoryData;
  }


  public JTable getJtInventoryDataTable() {
    return jtInventoryDataTable;
  }


  public JScrollPane getJspInventoryData() {
    return jspInventoryData;
  }


  public JDialog getJdInventoryAddDialogView() {
    return jdInventoryAddDialogView;
  }


  public JDialog getJdInventoryModifyDialogView() {
    return jdInventoryModifyDialogView;
  }


  public static void main(String[] args) {
    new InventoryView();
  }

}
