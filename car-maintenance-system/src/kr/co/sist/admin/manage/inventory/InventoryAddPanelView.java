package kr.co.sist.admin.manage.inventory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InventoryAddPanelView extends JFrame {

  private InventoryAddEvent inventoryAddEvent;

  private JLabel jlPartCode;
  private JLabel jlName;
  private JLabel jlPrice;
  private JLabel jlCount;

  private JTextField jtfPartCode;
  private JTextField jtfName;
  private JTextField jtfPrice;
  private JTextField jtfCount;

  private JButton jbtnConfirm;
  private JButton jbtnCancel;

  public InventoryAddPanelView() {

    super("부품 추가");

    jlPartCode = new JLabel("부품코드");
    jlName = new JLabel("이름");
    jlPrice = new JLabel("판매 가격");
    jlCount = new JLabel("재고량");

    jtfPartCode = new JTextField();
    jtfName = new JTextField();
    jtfPrice = new JTextField();
    jtfCount = new JTextField();

    jbtnConfirm = new JButton("확인");
    jbtnCancel = new JButton("취소");

    setLayout(null);

    jlPartCode.setBounds(20, 20, 225, 20);
    jtfPartCode.setBounds(20, 40, 225, 30); // 20 이격
    jlName.setBounds(20, 70, 225, 20);// 30 이격
    jtfName.setBounds(20, 90, 225, 30);
    jlPrice.setBounds(20, 120, 225, 20);
    jtfPrice.setBounds(20, 140, 225, 30);
    jlCount.setBounds(20, 170, 225, 20);
    jtfCount.setBounds(20, 190, 225, 30);

    jbtnConfirm.setBounds(20, 260, 70, 40);
    jbtnCancel.setBounds(180, 260, 70, 40);

    add(jlPartCode);
    add(jtfPartCode);
    add(jlName);
    add(jtfName);
    add(jlPrice);
    add(jtfPrice);
    add(jlCount);
    add(jtfCount);
    add(jbtnConfirm);
    add(jbtnCancel);

    inventoryAddEvent = new InventoryAddEvent(this);

    jbtnConfirm.addActionListener(inventoryAddEvent);
    jbtnCancel.addActionListener(inventoryAddEvent);

    setBounds(200, 320, 285, 370);


    setVisible(true);
    setResizable(false);

  }// InventoryAddPanelView



  public InventoryAddEvent getInventoryAddEvent() {
    return inventoryAddEvent;
  }



  public JLabel getJlPartCode() {
    return jlPartCode;
  }



  public JLabel getJlName() {
    return jlName;
  }



  public JLabel getJlPrice() {
    return jlPrice;
  }



  public JLabel getJlCount() {
    return jlCount;
  }



  public JTextField getJtfPartCode() {
    return jtfPartCode;
  }



  public JTextField getJtfName() {
    return jtfName;
  }



  public JTextField getJtfPrice() {
    return jtfPrice;
  }



  public JTextField getJtfCount() {
    return jtfCount;
  }



  public JButton getJbtnConfirm() {
    return jbtnConfirm;
  }



  public JButton getJbtnCancel() {
    return jbtnCancel;
  }



  public static void main(String[] args) {
    new InventoryAddPanelView();
  }

}
