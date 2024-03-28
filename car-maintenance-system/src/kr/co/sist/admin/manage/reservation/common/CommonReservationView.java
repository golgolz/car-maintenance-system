package kr.co.sist.admin.manage.reservation.common;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CommonReservationView extends JFrame {

    private JLabel jlbCommonReservationTitle, jlbCarIdTitle, jlbOwnerName;
    private JTextField jtfCarId, jtfOwnerName;
    private JButton jbtnSearch;

    public CommonReservationView() {
        super("차량 정비 관리 시스템");

        jlbCommonReservationTitle = new JLabel("일반 정비 신청 차량");
        jlbCarIdTitle = new JLabel("차량번호");
        jlbOwnerName = new JLabel("고객명");

        jbtnSearch = new JButton("검색");

        jtfCarId = new JTextField();
        jtfOwnerName = new JTextField();

        String[] HeaderInfo = {"차량번호", "고객명", "ID", "모델", "주행거리", "정비상태", "차량 제조일", "예약일", "에약사유"};
        String[][] dumpData = null;
        DefaultTableModel commonReservation = new DefaultTableModel(dumpData, HeaderInfo);
        JTable commonReservationTable = new JTable(commonReservation);
        JScrollPane jsp = new JScrollPane(commonReservationTable);

        commonReservationTable = new JTable(commonReservation);

        setLayout(null);

        jlbCommonReservationTitle.setBounds(50, 0, 100, 100);
        jlbCarIdTitle.setBounds(50, 50, 100, 100);
        jlbOwnerName.setBounds(230, 90, 100, 25);

        jtfCarId.setBounds(110, 90, 100, 25);
        jtfOwnerName.setBounds(275, 90, 100, 25);

        jbtnSearch.setBounds(390, 90, 60, 25);
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
