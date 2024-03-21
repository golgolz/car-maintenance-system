package kr.co.sist.admin.manage.inventory;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InventoryView extends JFrame {
  private JLabel jlInventoryLabel;
  private JButton jbtnSelectBtn;
  private JButton jbtnAddBtn;
  private JButton jbtnUpdateBtn;

  private JTextField jtaSelectField;

  private DefaultTableModel dtmDefaultInventoryData;
  private JTable jtInventoryDataTable;
  private JScrollPane jspInventoryDataScroll;

  private JDialog jdlInventoryAddDialogView;
  private JDialog jblInventoryModifyDialogView;

  public InventoryView() {
    super("차량 정보 관리");

    jlInventoryLabel = new JLabel("부품 재고 관리");
    jbtnSelectBtn = new JButton("조회");
    jbtnAddBtn = new JButton("추가");
    jbtnUpdateBtn = new JButton("변경");
    jtaSelectField = new JTextField("재고명을 입력하세요");

    dtmDefaultInventoryData = new DefaultTableModel(new Object[][] {{}, {}, {}, {}, {}}, new String[] {});
    jtInventoryDataTable = new JTable();
    jspInventoryDataScroll = new JScrollPane();

    jdlInventoryAddDialogView = new JDialog();
    jblInventoryModifyDialogView = new JDialog();

    jtInventoryDataTable.setModel(dtmDefaultInventoryData);
    jspInventoryDataScroll.setViewportView(jtInventoryDataTable); // 테이블 스크롤 형식 설정

    jlInventoryLabel.setBounds(20, 20, 20, 10);

    add(jlInventoryLabel);

    setBounds(100, 100, 840, 480);


    setVisible(true);
  }

  public static void main(String[] args) {
    new InventoryView();
  }

}
