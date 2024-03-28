package kr.co.sist.admin.manage.reservation.common;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MaintenanceProgressView extends JFrame {

  private JLabel jlMaintenanceProgressViewTitle;
  private JLabel jlPartCode;
  private JLabel jlPartName;
  private JLabel jlPartCnt;
  private JLabel jlTotalPrice;
  private JButton jbtnInsert;
  private JButton jbtnDelete;
  private JButton jbtnConfirm;
  private JButton jbtnCancel;
  private JTextField jtfPartCode;
  private JTextField jtfPartName;
  private JTextField jtfPartCnt;
  private JTextArea jtaTotalPrice;
  private DefaultTableModel maintenanceProgress;
  private JTable maintenanceProgressTable;
  private JScrollPane jsp;

  public MaintenanceProgressView() {
    super("차량정비관리시스템");

    jlMaintenanceProgressViewTitle = new JLabel("정비 진행");
    jlPartCode = new JLabel("부품코드");
    jlPartName = new JLabel("부품명");
    jlPartCnt = new JLabel("수량");
    jlTotalPrice = new JLabel("총액");
    jbtnInsert = new JButton("추가");
    jbtnDelete = new JButton("삭제");
    jbtnConfirm = new JButton("정비완료");
    jbtnCancel = new JButton("취소");
    jtfPartCode = new JTextField();
    jtfPartName = new JTextField();
    jtfPartCnt = new JTextField();
    jtaTotalPrice = new JTextArea();

    String[] HeaderInfo = {"부품코드", "부품명", "수량", "가격"};
    String[][] dumpData = null;
    maintenanceProgress = new DefaultTableModel(dumpData, HeaderInfo);
    maintenanceProgressTable = new JTable(maintenanceProgress);
    jsp = new JScrollPane(maintenanceProgressTable);

    maintenanceProgressTable = new JTable(maintenanceProgress);

    setLayout(null);

    jlMaintenanceProgressViewTitle.setBounds(20, 10, 100, 30);
    jlPartCode.setBounds(20, 40, 100, 30);
    jtfPartCode.setBounds(80, 40, 100, 30);// 60 이격
    jlPartName.setBounds(190, 40, 100, 30);// 110 이격
    jtfPartName.setBounds(235, 40, 100, 30);
    jlPartCnt.setBounds(345, 40, 100, 30);
    jtfPartCnt.setBounds(380, 40, 100, 30);
    jbtnInsert.setBounds(490, 40, 60, 30);
    jbtnDelete.setBounds(560, 40, 60, 30);
    jsp.setBounds(20, 80, 610, 110);
    jlTotalPrice.setBounds(500, 200, 100, 30);
    jtaTotalPrice.setBounds(530, 200, 100, 30);
    jbtnCancel.setBounds(20, 235, 100, 30);
    jbtnConfirm.setBounds(530, 235, 100, 30);

    add(jlMaintenanceProgressViewTitle);
    add(jlPartCode);
    add(jlPartName);
    add(jlPartCnt);
    add(jlTotalPrice);
    add(jbtnInsert);
    add(jbtnDelete);
    add(jbtnConfirm);
    add(jbtnCancel);
    add(jtfPartCode);
    add(jtfPartName);
    add(jtfPartCnt);
    add(jtaTotalPrice);

    add(maintenanceProgressTable);
    add(jsp);

    setSize(655, 315);
    setVisible(true);
  }

  public JLabel getJlMaintenanceProgressViewTitle() {
    return jlMaintenanceProgressViewTitle;
  }

  public JLabel getJlPartCode() {
    return jlPartCode;
  }

  public JLabel getJlPartName() {
    return jlPartName;
  }

  public JLabel getJlPartCnt() {
    return jlPartCnt;
  }

  public JLabel getJlTotalPrice() {
    return jlTotalPrice;
  }

  public JButton getJbtnInsert() {
    return jbtnInsert;
  }

  public JButton getJbtnDelete() {
    return jbtnDelete;
  }

  public JButton getJbtnConfirm() {
    return jbtnConfirm;
  }

  public JButton getJbtnCancel() {
    return jbtnCancel;
  }

  public JTextField getJtfPartCode() {
    return jtfPartCode;
  }

  public JTextField getJtfPartName() {
    return jtfPartName;
  }

  public JTextField getJtfPartCnt() {
    return jtfPartCnt;
  }

  public JTextArea getJtaTotalPrice() {
    return jtaTotalPrice;
  }

  public DefaultTableModel getMaintenanceProgress() {
    return maintenanceProgress;
  }

  public JTable getMaintenanceProgressTable() {
    return maintenanceProgressTable;
  }

  public JScrollPane getJsp() {
    return jsp;
  }

  public static void main(String[] args) {
    new MaintenanceProgressView();
  }
}
