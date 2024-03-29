package kr.co.sist.admin;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import kr.co.sist.FontSingleton;

@SuppressWarnings("serial")
public class AdminView extends JFrame {// oven 9
    private AdminViewEvent adminViewEvent;
    private JLabel jlSelectFunctionMsg;// 원하시는 메뉴를 선택해주세요.
    private JButton jbtnReceivingManage;// 입고 차량 관리버튼
    private JButton jbtnCommonReservation;// 일반정비신청차량버튼
    private JButton jbtnPreventiReservation;// 예방정비신청차량버튼
    private JButton jbtnPreventiManagement;// 예방정비대상차량버튼
    private JButton jbtnReleasedCar;// 출고차량관리버튼
    private JButton jbtnPartsManage;// 부품 재고 관리버튼
    private JButton jbtnRecallManage;// 리콜 정보 관리버튼
    private JButton jbtnRegisteredCarManage;// 등록 차량 관리버튼
    private JButton jbtnUserManage;// 고객 정보 관리버튼
    private JButton jbtnLogout;// 로그아웃버튼

    public AdminView() {
        super("관리자 기능 선택");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));

        adminViewEvent = new AdminViewEvent(this);

        jlSelectFunctionMsg = new JLabel("원하시는 메뉴를 선택해주세요.");
        jbtnReceivingManage = new JButton("입고 차량 관리");
        jbtnCommonReservation = new JButton("일반정비 신청차량");
        jbtnPreventiReservation = new JButton("예방정비 신청차량");
        jbtnPreventiManagement = new JButton("예방정비 대상차량");
        jbtnReleasedCar = new JButton("출고 차량 관리");
        jbtnPartsManage = new JButton("부품 재고 관리");
        jbtnRecallManage = new JButton("리콜 정보 관리");
        jbtnRegisteredCarManage = new JButton("등록 차량 관리");
        jbtnUserManage = new JButton("고객 정보 관리");
        jbtnLogout = new JButton("로그아웃");

        jlSelectFunctionMsg.setBounds(270, 10, 300, 50);
        jbtnReceivingManage.setBounds(50, 100, 220, 40);
        jbtnCommonReservation.setBounds(300, 100, 220, 40);
        jbtnPreventiReservation.setBounds(550, 100, 220, 40);
        jbtnPreventiManagement.setBounds(50, 200, 220, 40);
        jbtnReleasedCar.setBounds(300, 200, 220, 40);
        jbtnPartsManage.setBounds(550, 200, 220, 40);
        jbtnRecallManage.setBounds(50, 300, 220, 40);
        jbtnRegisteredCarManage.setBounds(300, 300, 220, 40);
        jbtnUserManage.setBounds(550, 300, 220, 40);
        jbtnLogout.setBounds(700, 20, 90, 30);

        jlSelectFunctionMsg.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 20f));
        jbtnReceivingManage.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnCommonReservation.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnPreventiReservation.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnPreventiManagement.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnReleasedCar.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnPartsManage.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnRecallManage.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnRegisteredCarManage.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnUserManage.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnLogout.setFont(FontSingleton.getInstance().bonGodic.deriveFont(14f));

        jlSelectFunctionMsg.setForeground(Color.WHITE);
        jbtnReceivingManage.setForeground(Color.WHITE);
        jbtnReceivingManage.setBackground(Color.decode("#5586EB"));
        jbtnCommonReservation.setForeground(Color.WHITE);
        jbtnCommonReservation.setBackground(Color.decode("#5586EB"));
        jbtnPreventiReservation.setForeground(Color.WHITE);
        jbtnPreventiReservation.setBackground(Color.decode("#5586EB"));
        jbtnPreventiManagement.setForeground(Color.WHITE);
        jbtnPreventiManagement.setBackground(Color.decode("#065535"));
        jbtnReleasedCar.setForeground(Color.WHITE);
        jbtnReleasedCar.setBackground(Color.decode("#065535"));
        jbtnPartsManage.setForeground(Color.WHITE);
        jbtnPartsManage.setBackground(Color.decode("#065535"));
        jbtnRecallManage.setForeground(Color.WHITE);
        jbtnRecallManage.setBackground(Color.decode("#3DB7A0"));
        jbtnRegisteredCarManage.setForeground(Color.WHITE);
        jbtnRegisteredCarManage.setBackground(Color.decode("#3DB7A0"));
        jbtnUserManage.setForeground(Color.WHITE);
        jbtnUserManage.setBackground(Color.decode("#3DB7A0"));
        jbtnLogout.setForeground(Color.WHITE);
        jbtnLogout.setBackground(Color.decode("#002347"));

        add(jlSelectFunctionMsg);
        add(jbtnReceivingManage);
        add(jbtnCommonReservation);
        add(jbtnPreventiReservation);
        add(jbtnPreventiManagement);
        add(jbtnReleasedCar);
        add(jbtnPartsManage);
        add(jbtnRecallManage);
        add(jbtnRegisteredCarManage);
        add(jbtnUserManage);
        add(jbtnLogout);

        jbtnReceivingManage.addActionListener(adminViewEvent);
        jbtnCommonReservation.addActionListener(adminViewEvent);
        jbtnPreventiReservation.addActionListener(adminViewEvent);
        jbtnPreventiManagement.addActionListener(adminViewEvent);
        jbtnReleasedCar.addActionListener(adminViewEvent);
        jbtnPartsManage.addActionListener(adminViewEvent);
        jbtnRecallManage.addActionListener(adminViewEvent);
        jbtnRegisteredCarManage.addActionListener(adminViewEvent);
        jbtnUserManage.addActionListener(adminViewEvent);
        jbtnLogout.addActionListener(adminViewEvent);
        // addWindowListener(adminViewEvent);

        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JLabel getJlSelectFunctionMsg() {
        return jlSelectFunctionMsg;
    }

    public JButton getJbtnReceivingManage() {
        return jbtnReceivingManage;
    }

    public JButton getJbtnPartsManage() {
        return jbtnPartsManage;
    }

    public JButton getJbtnRecallManage() {
        return jbtnRecallManage;
    }

    public JButton getJbtnRegisteredCarManage() {
        return jbtnRegisteredCarManage;
    }

    public JButton getJbtnUserManage() {
        return jbtnUserManage;
    }

    public JButton getJbtnLogout() {
        return jbtnLogout;
    }

    public JButton getJbtnCommonReservation() {
        return jbtnCommonReservation;
    }

    public JButton getJbtnPreventiReservation() {
        return jbtnPreventiReservation;
    }

    public JButton getJbtnPreventiManagement() {
        return jbtnPreventiManagement;
    }

    public JButton getJbtnReleasedCar() {
        return jbtnReleasedCar;
    }


}
