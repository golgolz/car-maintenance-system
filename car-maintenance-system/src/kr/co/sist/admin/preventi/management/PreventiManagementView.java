package kr.co.sist.admin.preventi.management;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PreventiManagementView extends JFrame {
    private JTextField jtfCarId;
    private JTextField jtfOwnerId;
    private DefaultTableModel preventiTargets;
    private JTable preventiTargetTable;

    public PreventiManagementView() {
        super("예방 정비 대상 차량");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));

        JLabel jlblTitle = new JLabel("예방 정비 대상 차량");
        JLabel jlblCarId = new JLabel("차량 번호");
        jtfCarId = new JTextField(10);
        JLabel jlblOwnerId = new JLabel("사용자 ID");
        jtfOwnerId = new JTextField(10);
        JButton jbtnSearch = new JButton("검색");
        JButton jbtnPreventiPolicy = new JButton("예방 정비 지침 확인");
        JButton jbtnMaintenanceHistory = new JButton("보기");
        preventiTargets = new DefaultTableModel();
        createMaintenanceHistoryDialog();
        preventiTargetTable = new JTable(preventiTargets);
        JScrollPane preventiTargetScroll = new JScrollPane(preventiTargetTable);

        jlblTitle.setFont(new Font("나눔고딕", Font.BOLD, 27));
        jlblCarId.setFont(new Font("나눔고딕", Font.PLAIN, 17));
        jlblOwnerId.setFont(new Font("나눔고딕", Font.PLAIN, 17));
        jbtnSearch.setFont(new Font("나눔고딕", Font.PLAIN, 14));
        jbtnPreventiPolicy.setFont(new Font("나눔고딕", Font.PLAIN, 14));
        preventiTargetTable.setFont(new Font("나눔고딕", Font.PLAIN, 14));

        jlblTitle.setBounds(17, 0, 250, 80);
        jlblCarId.setBounds(20, 87, 100, 30);
        jtfCarId.setBounds(100, 87, 100, 30);
        jlblOwnerId.setBounds(220, 87, 100, 30);
        jtfOwnerId.setBounds(300, 87, 100, 30);
        jbtnSearch.setBounds(450, 87, 60, 30);
        jbtnPreventiPolicy.setBounds(630, 30, 160, 30);
        preventiTargetScroll.setBounds(20, 140, 770, 280);

        jlblTitle.setForeground(Color.WHITE);
        jlblCarId.setForeground(Color.WHITE);
        jlblOwnerId.setForeground(Color.WHITE);
        jbtnSearch.setForeground(Color.WHITE);
        jbtnPreventiPolicy.setForeground(Color.WHITE);
        jbtnSearch.setBackground(Color.decode("#065535"));
        jbtnPreventiPolicy.setBackground(Color.decode("#065535"));

        jbtnPreventiPolicy.addActionListener(new PreventiManagementEvent(this));

        add(jlblTitle);
        add(jlblCarId);
        add(jtfCarId);
        add(jlblOwnerId);
        add(jtfOwnerId);
        add(jbtnSearch);
        add(jbtnPreventiPolicy);
        add(preventiTargetScroll);

        setSize(840, 480);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void createMaintenanceHistoryDialog() {
        String[] headerInfo = {"차량번호", "ID", "모델", "주행거리", "예약여부", "정비이력", "정비상태", "제조일", "예약일", "점검사유"};
        Object[][] preventiTargetData =
                {{"111가4567", "lee", "K5", "29,193km", "N", "보기", "입고전", "20-09-09", "없음", "엔진오일"},
                        {"111가4567", "lee", "K5", "29,193km", "N", "보기", "입고전", "20-09-09", "없음", "엔진오일"}};
        preventiTargets = new DefaultTableModel(preventiTargetData, headerInfo);
    }
}
