package kr.co.sist.user.preventi;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class PreventiAlarmView extends JFrame {
    private DefaultTableModel preventiAlarms;
    private JTable preventiAlarmTable;

    public PreventiAlarmView() {
        super("예방 정비");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));

        JLabel jlblTitle = new JLabel("예방 정비 대상");
        preventiAlarms = new DefaultTableModel();
        createMaintenanceDialog();
        preventiAlarmTable = new JTable(preventiAlarms);
        JScrollPane preventiTargetScroll = new JScrollPane(preventiAlarmTable);

        jlblTitle.setFont(new Font("나눔고딕", Font.BOLD, 27));
        preventiAlarmTable.setFont(new Font("나눔고딕", Font.PLAIN, 14));

        jlblTitle.setBounds(17, 0, 250, 80);
        preventiTargetScroll.setBounds(20, 140, 770, 280);

        // jbtnSearch.addActionListener(new PreventiReservationEvent(this));

        jlblTitle.setForeground(Color.WHITE);

        add(jlblTitle);
        add(preventiTargetScroll);

        setSize(840, 480);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void createMaintenanceDialog() {
        String[] headerInfo = {"모델", "차량번호", "정비필요항목"};
        Object[][] preventiReservationData = {{"K5", "222가1234", "엔진오일"}, {"레이", "222가1234", "에어컨필터,연료필터카트리지"}};
        preventiAlarms = new DefaultTableModel(preventiReservationData, headerInfo);
    }
}
