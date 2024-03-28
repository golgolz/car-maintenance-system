package kr.co.sist.admin.register.car;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import kr.co.sist.FontSingleton;

// 참고 코드 : admin.preventi.policy.PreventiPolicyDialog.java(JTable)
@SuppressWarnings("serial")
public class AdminRegisteredCarView extends JFrame {

    private JLabel jlbRegisteredTitle, jlbCarIdTitle, jlbIdTitle;
    private JTextField jtfCarId, jtfId;
    private JButton jbtnSearch, jbtnAddCar, jbtnModify, jbtnRemove;
    private DefaultTableModel carRegist;
    private JTable carTable;

    public AdminRegisteredCarView() throws SQLException {
        super("차량 정비 관리 시스템");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));
        jlbRegisteredTitle = new JLabel("등록 차량관리");
        jlbRegisteredTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        jlbCarIdTitle = new JLabel("차량번호");
        jlbCarIdTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jlbIdTitle = new JLabel("ID");
        jlbIdTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));

        jtfCarId = new JTextField();
        jtfCarId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jtfId = new JTextField();
        jtfId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));

        jbtnSearch = new JButton("조회");
        jbtnSearch.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jbtnAddCar = new JButton("추가");
        jbtnAddCar.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jbtnModify = new JButton("수정");
        jbtnModify.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jbtnRemove = new JButton("삭제");
        jbtnRemove.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));

        String[] CarTableHeader = {"차량번호", "사용자ID", "모델", "연식", "등록일", "주행거리"};
        String[][] dumpData = null;
        carRegist = new DefaultTableModel(dumpData, CarTableHeader);
        carTable = new JTable(carRegist);
        JScrollPane jsp = new JScrollPane(carTable);

        carTable.getTableHeader().setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        // carTable = new JTable(carRegist);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        carTable.setDefaultRenderer(Object.class, centerRenderer);

        AdminRegisteredCarEvent adminRegisteredCarEvent = new AdminRegisteredCarEvent(this);

        carTable.addMouseListener(adminRegisteredCarEvent);
        jbtnAddCar.addActionListener(adminRegisteredCarEvent);
        jbtnModify.addActionListener(adminRegisteredCarEvent);
        jbtnSearch.addActionListener(adminRegisteredCarEvent);
        // jbtnRemove.addMouseListener(adminRegisteredCarEvent);
        jbtnRemove.addActionListener(adminRegisteredCarEvent);

        setLayout(null);
        jlbRegisteredTitle.setBounds(50, 0, 10000, 100);
        jlbCarIdTitle.setBounds(50, 50, 100, 100);
        jlbIdTitle.setBounds(230, 90, 100, 25);

        jtfCarId.setBounds(120, 90, 100, 25);
        jtfId.setBounds(250, 90, 100, 25);

        jbtnSearch.setBounds(380, 90, 70, 25);
        jbtnAddCar.setBounds(540, 90, 70, 25);
        jbtnModify.setBounds(620, 90, 70, 25);
        jbtnRemove.setBounds(700, 90, 70, 25);

        jsp.setBounds(50, 125, 730, 280);

        jlbRegisteredTitle.setForeground(Color.WHITE);
        jlbCarIdTitle.setForeground(Color.WHITE);
        jlbIdTitle.setForeground(Color.WHITE);
        jbtnAddCar.setForeground(Color.WHITE);
        jbtnModify.setForeground(Color.WHITE);
        jbtnRemove.setForeground(Color.WHITE);
        jbtnSearch.setForeground(Color.WHITE);

        jbtnSearch.setBackground(Color.decode("#47C83E"));
        jbtnAddCar.setBackground(Color.decode("#47C83E"));
        jbtnModify.setBackground(Color.decode("#5586EB"));
        jbtnRemove.setBackground(Color.decode("#FF0000"));

        add(jlbRegisteredTitle);
        add(jlbCarIdTitle);
        add(jlbIdTitle);

        add(jtfCarId);
        add(jtfId);

        add(jbtnSearch);
        add(jbtnAddCar);
        add(jbtnModify);
        add(jbtnRemove);

        // add(carTable);
        add(jsp);



        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);

    }// RegisteredCarView



    public JTable getCarTable() {
        return carTable;
    }



    public JButton getJbtnSearch() {
        return jbtnSearch;
    }

    public JButton getJbtnAddCar() {
        return jbtnAddCar;
    }

    public JButton getJbtnModify() {
        return jbtnModify;
    }

    public JButton getJbtnRemove() {
        return jbtnRemove;
    }



    public JLabel getJlbRegisteredTitle() {
        return jlbRegisteredTitle;
    }



    public JLabel getJlbCarIdTitle() {
        return jlbCarIdTitle;
    }



    public JLabel getJlbIdTitle() {
        return jlbIdTitle;
    }



    public JTextField getJtfCarId() {
        return jtfCarId;
    }



    public JTextField getJtfId() {
        return jtfId;
    }



    public DefaultTableModel getCarRegist() {
        return carRegist;
    }


}// class

