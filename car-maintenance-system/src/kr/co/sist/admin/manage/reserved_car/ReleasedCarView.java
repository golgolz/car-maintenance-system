package kr.co.sist.admin.manage.reserved_car;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ReleasedCarView extends JFrame {
    private JLabel jlbReleasedCarTitle, jlbCarIdTitle, jlbIdTitle;
    private JTextField jtfCarId, jtfId;
    private JButton jbtnSearch;

    public ReleasedCarView() {
        super("차량 정비 관리 시스템");

        jlbReleasedCarTitle = new JLabel("출고 차량 조회");
        jlbCarIdTitle = new JLabel("차량번호");
        jlbIdTitle = new JLabel("ID");

        jtfCarId = new JTextField();
        jtfId = new JTextField();

        jbtnSearch = new JButton("검색");

        String[] Header = {"차량번호", "연식", "주행거리", "정비입고일", "정비출고일", "고객명"};
        String[][] dumpData = null;
        DefaultTableModel releasedCarModel = new DefaultTableModel(dumpData, Header);
        JTable releasedCarTable = new JTable(releasedCarModel);
        JScrollPane jsp = new JScrollPane(releasedCarTable);

        releasedCarTable = new JTable(releasedCarModel);

        setLayout(null);
        jlbReleasedCarTitle.setBounds(50, 0, 100, 100);
        jlbCarIdTitle.setBounds(50, 50, 100, 100);
        jlbIdTitle.setBounds(230, 90, 100, 25);

        jtfCarId.setBounds(110, 90, 100, 25);
        jtfId.setBounds(250, 90, 100, 25);

        jbtnSearch.setBounds(380, 90, 60, 25);
        jsp.setBounds(50, 125, 730, 280);

        add(jlbReleasedCarTitle);
        add(jlbCarIdTitle);
        add(jlbIdTitle);

        add(jtfCarId);
        add(jtfId);

        add(jbtnSearch);

        add(releasedCarTable);
        add(jsp);

        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // public static void main(String[] args) {
    // new ReleasedCarView();
    // }
}

