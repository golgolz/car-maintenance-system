package kr.co.sist.user.monthly;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import kr.co.sist.FontSingleton;

public class MonthlyCarMaintenanceView extends JFrame {

  private MonthlyCarMaintenanceEvent monthlyCarMaintenanceEvent;

  private JLabel jlMonthlyCarMaintenanceLabel;
  private JLabel jlUserName;

  private DefaultComboBoxModel dcmMaintenanceList;
  private JComboBox<String> jcbMonthlyMaintenanceList;

  private JButton jbtnSelect;
  private JButton jbtnDetailedSelect;

  private DefaultTableModel dtmMonthlyCarMaintenanceData;
  private JTable jtabMonthlyCarMaintenanceData;
  private JScrollPane jspMonthlyCarMaintenanceData;

  private DefaultTableModel dtmDetailedCarMaintenanceData;
  private JTable jtDetailedCarMaintenanceData;
  private JScrollPane jspDetailedCarMaintenanceData;

  public MonthlyCarMaintenanceView() {
    super("정비 정산");

    // 배경색
    this.getContentPane().setBackground(Color.decode("#002347"));

    // createDateInfo() 호출 시점 변경
    jcbMonthlyMaintenanceList = new JComboBox<>(createDateInfo());



    jlMonthlyCarMaintenanceLabel = new JLabel("차량 정비 정산");
    jlUserName = new JLabel("우미연 고객님");

    jbtnSelect = new JButton("조회");
    jbtnDetailedSelect = new JButton("세부 조회");

    String[] header = {"이름", "정비 일자",};
    String[][] contents = {{" ", " "}};

    String[] header2 = {"이름", "판매 가격", "수량", "총 가격"};
    String[][] contents2 = {{" ", " ", " ", " "}};


    dtmMonthlyCarMaintenanceData = new DefaultTableModel(contents, header);
    jtabMonthlyCarMaintenanceData = new JTable(dtmMonthlyCarMaintenanceData);
    jspMonthlyCarMaintenanceData = new JScrollPane(jtabMonthlyCarMaintenanceData);

    dtmDetailedCarMaintenanceData = new DefaultTableModel(contents2, header2);
    jtDetailedCarMaintenanceData = new JTable(dtmDetailedCarMaintenanceData);
    jspDetailedCarMaintenanceData = new JScrollPane(jtDetailedCarMaintenanceData);

    // 테이블 헤더 폰트 설정 방법
    jtabMonthlyCarMaintenanceData.getTableHeader().setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
    // 테이블 정렬
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    jtabMonthlyCarMaintenanceData.setDefaultRenderer(Object.class, centerRenderer);



    // 생성자 내에서 monthlyCarMaintenanceEvent 초기화
    monthlyCarMaintenanceEvent = new MonthlyCarMaintenanceEvent(this);

    // JComboBox 초기화 후 ActionListener 추가
    jcbMonthlyMaintenanceList.addActionListener(monthlyCarMaintenanceEvent);
    // 활성화된 행을 불러오는 MouseListner 추가
    jtabMonthlyCarMaintenanceData.addMouseListener(monthlyCarMaintenanceEvent);


    jbtnDetailedSelect.addActionListener(monthlyCarMaintenanceEvent);

    jbtnSelect.addActionListener(monthlyCarMaintenanceEvent);

    // 테이블 헤더 폰트 설정 방법
    jtDetailedCarMaintenanceData.getTableHeader().setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
    // 테이블 정렬
    DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    jtDetailedCarMaintenanceData.setDefaultRenderer(Object.class, centerRenderer2);

    setLayout(null);


    jlMonthlyCarMaintenanceLabel.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
    jlUserName.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
    jbtnSelect.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.PLAIN, 14f));
    jbtnDetailedSelect.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.PLAIN, 14f));

    jlMonthlyCarMaintenanceLabel.setBounds(20, 20, 200, 30);
    jlUserName.setBounds(600, 20, 200, 30);
    jcbMonthlyMaintenanceList.setBounds(20, 60, 100, 30);
    jbtnSelect.setBounds(140, 60, 100, 30);
    jbtnDetailedSelect.setBounds(680, 60, 100, 30);
    jspMonthlyCarMaintenanceData.setBounds(20, 100, 780, 130);
    jspDetailedCarMaintenanceData.setBounds(20, 260, 780, 170);
    add(jlMonthlyCarMaintenanceLabel);
    add(jlUserName);
    add(jcbMonthlyMaintenanceList);
    // add(jbtnSelect);
    add(jbtnDetailedSelect);
    add(jspMonthlyCarMaintenanceData);
    add(jspDetailedCarMaintenanceData);

    jbtnSelect.setBackground(Color.decode("#5586EB")); // 파란색
    jbtnDetailedSelect.setBackground(Color.decode("#5586EB")); // 파란색

    jlMonthlyCarMaintenanceLabel.setForeground(Color.WHITE);
    jlUserName.setForeground(Color.WHITE);
    jbtnSelect.setForeground(Color.WHITE);
    jbtnDetailedSelect.setForeground(Color.WHITE);



    setBounds(200, 320, 840, 480);
    setVisible(true);
    setResizable(false);

    setLocationRelativeTo(null);
  }

  public String[] createDateInfo() {
    MonthlyCarMaintenanceDAO mcmDAO = MonthlyCarMaintenanceDAO.getInstance();
    List<String> getDate = null;
    try {
      getDate = mcmDAO.getAllMaintenanceDates();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // List를 배열로 변환
    String[] result = new String[getDate.size()];
    result = getDate.toArray(result);

    return result;
  }// createDateInfo


  public MonthlyCarMaintenanceEvent getMonthlyCarMaintenanceEvent() {
    return monthlyCarMaintenanceEvent;
  }



  public JLabel getJlMonthlyCarMaintenanceLabel() {
    return jlMonthlyCarMaintenanceLabel;
  }



  public JLabel getJlUserName() {
    return jlUserName;
  }



  public DefaultComboBoxModel getDcmMaintenanceList() {
    return dcmMaintenanceList;
  }



  public JComboBox<String> getJcbMonthlyMaintenanceList() {
    return jcbMonthlyMaintenanceList;
  }



  public JButton getJbtnSelect() {
    return jbtnSelect;
  }



  public JButton getJbtnDetailedSelect() {
    return jbtnDetailedSelect;
  }



  public DefaultTableModel getDtmMonthlyCarMaintenanceData() {
    return dtmMonthlyCarMaintenanceData;
  }



  public JTable getJtabMonthlyCarMaintenanceData() {
    return jtabMonthlyCarMaintenanceData;
  }



  public JScrollPane getJspMonthlyCarMaintenanceData() {
    return jspMonthlyCarMaintenanceData;
  }



  public DefaultTableModel getDtmDetailedCarMaintenanceData() {
    return dtmDetailedCarMaintenanceData;
  }



  public JTable getJtDetailedCarMaintenanceData() {
    return jtDetailedCarMaintenanceData;
  }



  public JScrollPane getJspDetailedCarMaintenanceData() {
    return jspDetailedCarMaintenanceData;
  }



  public static void main(String[] args) {
    new MonthlyCarMaintenanceView();
  }
}
