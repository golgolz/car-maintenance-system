package kr.co.sist.user.register.car;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import kr.co.sist.FontSingleton;

@SuppressWarnings("serial")
public class UserRegisteredCarView extends JFrame {
    private JLabel jlbRegisteredTitle;
    private JButton jbtnAddCar, jbtnModify, jbtnRemove;

    public UserRegisteredCarView() {
        super("차량 정비 관리 시스템 - 회원정보수정 - 등록 차량 관리");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));

        jlbRegisteredTitle = new JLabel("사용자 차량 등록 현황");
        jlbRegisteredTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));

        jbtnAddCar = new JButton("추가");
        jbtnAddCar.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jbtnModify = new JButton("수정");
        jbtnModify.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jbtnRemove = new JButton("삭제");
        jbtnRemove.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));

        String[] CarTableHeader = {"차량번호", "모델", "주행거리", "연식", "제조일자", "차량등록일"};
        String[][] dumpData = null;
        DefaultTableModel carModel = new DefaultTableModel(dumpData, CarTableHeader);
        JTable carTable = new JTable(carModel);
        JScrollPane jsp = new JScrollPane(carTable);

        carTable = new JTable(carModel);

        setLayout(null);

        jlbRegisteredTitle.setBounds(50, 0, 1000, 100);

        jbtnAddCar.setBounds(540, 90, 70, 25);
        jbtnModify.setBounds(620, 90, 70, 25);
        jbtnRemove.setBounds(700, 90, 70, 25);

        jsp.setBounds(50, 125, 730, 280);

        jlbRegisteredTitle.setForeground(Color.WHITE);

        jbtnAddCar.setForeground(Color.WHITE);
        jbtnModify.setForeground(Color.WHITE);
        jbtnRemove.setForeground(Color.WHITE);

        jbtnAddCar.setBackground(Color.decode("#065535"));
        jbtnModify.setBackground(Color.decode("#5586EB"));
        jbtnRemove.setBackground(Color.decode("#4C4C4C"));

        add(jlbRegisteredTitle);
        add(jbtnAddCar);
        add(jbtnModify);
        add(jbtnRemove);

        add(carTable);
        add(jsp);

        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);


    }// RegisteredCarView

    public JLabel getJlbRegisteredTitle() {
        return jlbRegisteredTitle;
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

    public static void main(String[] args) {
        new UserRegisteredCarView();
    }

}

