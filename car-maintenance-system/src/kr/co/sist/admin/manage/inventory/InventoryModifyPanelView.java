package kr.co.sist.admin.manage.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InventoryModifyPanelView extends JFrame {
  private InventoryModifyEvent inventoryModifyEvent;
  private InventoryView inventoryView;

  private JLabel jlPrice;
  private JLabel jlCount;
  private JTextField jtaPrice;
  private JTextField jtaCount;
  private JButton jbtnModify;
  private JButton jbtnDelete;
  private JButton jbtnCancel;

  public InventoryModifyPanelView(InventoryView inventoryView) {
    super("재고 변경");
    this.inventoryView = inventoryView;

    jlPrice = new JLabel("재고량");
    jlCount = new JLabel("판매 가격");
    jtaPrice = new JTextField(10);
    jtaCount = new JTextField(10);
    jbtnModify = new JButton("변경");
    jbtnDelete = new JButton("삭제");
    jbtnCancel = new JButton("취소");

    setLayout(null);

    jlPrice.setBounds(20, 20, 225, 20);
    jtaPrice.setBounds(20, 40, 225, 30); // 20 이격
    jlCount.setBounds(20, 70, 225, 20);// 30 이격
    jtaCount.setBounds(20, 90, 225, 30);

    jbtnDelete.setBounds(20, 260, 70, 40);
    jbtnModify.setBounds(100, 260, 70, 40);
    jbtnCancel.setBounds(180, 260, 70, 40);

    add(jlPrice);
    add(jtaPrice);
    add(jlCount);
    add(jtaCount);
    add(jbtnModify);
    add(jbtnDelete);
    add(jbtnCancel);

    inventoryModifyEvent = new InventoryModifyEvent(this, inventoryView);

    jbtnModify.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        inventoryModifyEvent.modifyInventory();
      }
    });

    jbtnDelete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        inventoryModifyEvent.deleteInventory();
      }
    });


    setBounds(200, 320, 285, 370);
    setVisible(true);
    setResizable(false);
  }

  // Getter methods
  public JLabel getJlPrice() {
    return jlPrice;
  }

  public JLabel getJlCount() {
    return jlCount;
  }

  public JTextField getJtaPrice() {
    return jtaPrice;
  }

  public JTextField getJtaCount() {
    return jtaCount;
  }

  public JButton getJbtnModify() {
    return jbtnModify;
  }

  public JButton getJbtnDelete() {
    return jbtnDelete;
  }

  public JButton getJbtnCancel() {
    return jbtnCancel;
  }
}
