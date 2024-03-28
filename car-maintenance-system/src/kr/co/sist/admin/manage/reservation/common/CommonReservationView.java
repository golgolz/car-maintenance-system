package kr.co.sist.admin.manage.reservation.common;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import kr.co.sist.FontSingleton;

@SuppressWarnings("serial")
public class CommonReservationView extends JFrame {

    private JLabel jlbCommonReservationTitle, jlbCarIdTitle, jlbOwnerName;
    private JTextField jtfCarId, jtfOwnerName;
    private JButton jbtnSearch;

    public CommonReservationView() {
        super("차량 정비 관리 시스템");
        this.getContentPane().setBackground(Color.decode("#002347"));
        setLayout(null);

        jlbCommonReservationTitle = new JLabel("일반 정비 신청 차량");
        jlbCarIdTitle = new JLabel("차량번호");
        jlbOwnerName = new JLabel("고객명");
        jbtnSearch = new JButton("검색");
        jtfCarId = new JTextField();
        jtfOwnerName = new JTextField();

        String[] HeaderInfo = {"차량번호", "고객명", "ID", "모델", "주행거리", "정비상태", "차량 제조일", "예약일", "예약사유"};
        String[][] dumpData = null;
        DefaultTableModel commonReservation = new DefaultTableModel(dumpData, HeaderInfo);
        JTable commonReservationTable = new JTable(commonReservation);
        commonReservationTable.getTableHeader().setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        commonReservationTable.setFont(FontSingleton.getInstance().bonGodic.deriveFont(11f));

        JScrollPane jsp = new JScrollPane(commonReservationTable);
        commonReservationTable = new JTable(commonReservation);

        jlbCommonReservationTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        jlbCarIdTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jlbOwnerName.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jbtnSearch.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));

        jlbCommonReservationTitle.setForeground(Color.WHITE);
        jlbCarIdTitle.setForeground(Color.WHITE);
        jlbOwnerName.setForeground(Color.WHITE);
        jbtnSearch.setForeground(Color.WHITE);
        jbtnSearch.setBackground(Color.decode("#065535"));

        jlbCommonReservationTitle.setBounds(50, 0, 400, 100);
        jlbCarIdTitle.setBounds(50, 50, 100, 100);
        jtfCarId.setBounds(120, 90, 100, 25);
        jlbOwnerName.setBounds(240, 90, 100, 25);
        jtfOwnerName.setBounds(295, 90, 100, 25);
        jbtnSearch.setBounds(410, 90, 70, 25);
        jsp.setBounds(50, 125, 730, 280);

        add(jlbCommonReservationTitle);
        add(jlbCarIdTitle);
        add(jlbOwnerName);
        add(jtfCarId);
        add(jtfOwnerName);
        add(jbtnSearch);
        add(commonReservationTable);
        add(jsp);

        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);
    }// CommonReservationView

    // public String[][] createCommonReservationData() throws SQLException {
    // List<CommonReservationVO> tempCommonReservation = CommonReservationDAO.
    // }
    // public static void main(String[] args) {
    // new CommonReservationView();
    // }
}// class
