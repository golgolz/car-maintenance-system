package kr.co.sist.user.preventi;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import kr.co.sist.FontSingleton;
import kr.co.sist.admin.preventi.management.PreventiTargetDAO;
import kr.co.sist.admin.preventi.management.PreventiTargetVO;

@SuppressWarnings("serial")
public class PreventiAlarmView extends JFrame {
    private DefaultTableModel preventiAlarms;
    private JTable preventiAlarmTable;

    public PreventiAlarmView() {
        super("예방 정비");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));
        PreventiAlarmEvent preventiAlarmEvent = new PreventiAlarmEvent(this);

        JLabel jlblTitle = new JLabel("예방 정비 대상");
        preventiAlarms = new DefaultTableModel();
        createPersonalPreventi();
        preventiAlarmTable = new JTable(preventiAlarms);
        JScrollPane preventiTargetScroll = new JScrollPane(preventiAlarmTable);
        JButton jbtnReservation = new JButton("예약하기");
        JButton jbtnCancle = new JButton("취소");

        jlblTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        preventiAlarmTable.setFont(FontSingleton.getInstance().bonGodic.deriveFont(14f));
        preventiAlarmTable.getTableHeader().setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jbtnReservation.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 14f));
        jbtnCancle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 14f));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        preventiAlarmTable.setDefaultRenderer(Object.class, centerRenderer);
        preventiAlarmTable.getColumnModel().getColumn(0).setMaxWidth(100);
        preventiAlarmTable.getColumnModel().getColumn(1).setMaxWidth(160);
        preventiAlarmTable.getColumnModel().getColumn(1).setMinWidth(130);

        jbtnReservation.setBackground(Color.decode("#237bca"));
        jbtnReservation.setForeground(Color.WHITE);
        jbtnCancle.setBackground(Color.decode("#555555"));
        jbtnCancle.setForeground(Color.WHITE);

        jlblTitle.setBounds(17, 0, 250, 80);
        preventiTargetScroll.setBounds(20, 80, 770, 280);
        jbtnReservation.setBounds(200, 380, 100, 40);
        jbtnCancle.setBounds(500, 380, 100, 40);

        jbtnReservation.addActionListener(preventiAlarmEvent);
        jbtnCancle.addActionListener(preventiAlarmEvent);

        jlblTitle.setForeground(Color.WHITE);

        add(jlblTitle);
        add(preventiTargetScroll);
        add(jbtnReservation);
        add(jbtnCancle);

        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void createPersonalPreventi() {
        String[] headerInfo = {"모델", "차량번호", "정비필요항목"};
        List<PreventiTargetVO> personalPreventi = PreventiTargetDAO.getInstance().selectPersonalPreventi("lee");
        Object[][] preventiReservationData = new Object[personalPreventi.size()][3];

        for (int i = 0; i < personalPreventi.size(); i++) {
            preventiReservationData[i][0] = personalPreventi.get(i).getCarModel();
            preventiReservationData[i][1] = personalPreventi.get(i).getCarId();
            preventiReservationData[i][2] = personalPreventi.get(i).partToString();
        }
        preventiAlarms = new DefaultTableModel(preventiReservationData, headerInfo);
    }
}
