package kr.co.sist.user.register.car;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserRegisteredCarView extends JFrame {
    private JLabel jlbRegisteredTitle;
    private JButton jbtnAddCar, jbtnModify, jbtnRemove;

    public UserRegisteredCarView() {
        super("차량 정비 관리 시스템 - 회원정보수정 - 등록 차량 관리");

        jlbRegisteredTitle = new JLabel("사용자 차량 등록 현황");

        jbtnAddCar = new JButton("추가");
        jbtnModify = new JButton("수정");
        jbtnRemove = new JButton("삭제");

        String[] CarTableHeader = {"차량번호", "모델", "주행거리", "연식", "제조일자", "차량등록일"};
        String[][] dumpData = null;
        DefaultTableModel carModel = new DefaultTableModel(dumpData, CarTableHeader);
        JTable carTable = new JTable(carModel);
        JScrollPane jsp = new JScrollPane(carTable);

        carTable = new JTable(carModel);

        setLayout(null);

        jlbRegisteredTitle.setBounds(50, 0, 100, 100);

        jbtnAddCar.setBounds(540, 90, 60, 25);
        jbtnModify.setBounds(620, 90, 60, 25);
        jbtnRemove.setBounds(700, 90, 60, 25);

        jsp.setBounds(50, 125, 730, 280);

        add(jlbRegisteredTitle);
        add(jbtnAddCar);
        add(jbtnModify);
        add(jbtnRemove);

        add(carTable);
        add(jsp);

        setSize(840, 480);
        setVisible(true);

    }// RegisteredCarView
}
