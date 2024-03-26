package kr.co.sist.admin.register.car;

import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
        jlbRegisteredTitle = new JLabel("등록 차량관리");
        jlbCarIdTitle = new JLabel("차량번호");
        jlbIdTitle = new JLabel("ID");

        jtfCarId = new JTextField();
        jtfId = new JTextField();

        jbtnSearch = new JButton("조회");
        jbtnAddCar = new JButton("추가");
        jbtnModify = new JButton("수정");
        jbtnRemove = new JButton("삭제");

        String[] CarTableHeader = {"차량번호", "사용자ID", "모델", "연식", "등록일", "주행거리"};
        String[][] dumpData = null;
        carRegist = new DefaultTableModel(dumpData, CarTableHeader);
        carTable = new JTable(carRegist);
        JScrollPane jsp = new JScrollPane(carTable);

        // carTable = new JTable(carRegist);

        AdminRegisteredCarEvent adminRegisteredCarEvent = new AdminRegisteredCarEvent(this);

        carTable.addMouseListener(adminRegisteredCarEvent);
        jbtnAddCar.addActionListener(adminRegisteredCarEvent);
        jbtnModify.addActionListener(adminRegisteredCarEvent);
        jbtnSearch.addActionListener(adminRegisteredCarEvent);
        // jbtnRemove.addMouseListener(adminRegisteredCarEvent);
        jbtnRemove.addActionListener(adminRegisteredCarEvent);

        setLayout(null);

        jlbRegisteredTitle.setBounds(50, 0, 100, 100);
        jlbCarIdTitle.setBounds(50, 50, 100, 100);
        jlbIdTitle.setBounds(230, 90, 100, 25);

        jtfCarId.setBounds(110, 90, 100, 25);
        jtfId.setBounds(250, 90, 100, 25);

        jbtnSearch.setBounds(380, 90, 60, 25);
        jbtnAddCar.setBounds(540, 90, 60, 25);
        jbtnModify.setBounds(620, 90, 60, 25);
        jbtnRemove.setBounds(700, 90, 60, 25);

        jsp.setBounds(50, 125, 730, 280);

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

