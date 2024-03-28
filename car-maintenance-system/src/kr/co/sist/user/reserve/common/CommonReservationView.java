package kr.co.sist.user.reserve.common;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import kr.co.sist.FontSingleton;
import kr.co.sist.user.reserve.dialog.ReservationDialogView;


public class CommonReservationView extends JFrame {

    private JLabel jlReservationManagement;
    private String parts;

    public CommonReservationView(String label, int viewNum) { // 일반정비 예약 신청 화면
        super(label);
        // 프레임의 배경색 설정
        this.getContentPane().setBackground(Color.decode("#002347"));
        jlReservationManagement = new JLabel(label);

        setComponent();

        ReservationDialogView rdv = new ReservationDialogView(viewNum, this); // viewNum : 정비 분류

        setLayout(null);
        jlReservationManagement.setBounds(320, 50, 400, 60);
        rdv.setBounds(100, 100, 600, 320);
        rdv.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));

        add(jlReservationManagement); // 라벨 배치
        add(rdv); // rdv를 CommonReservationView에 추가

        // 이벤트 추가
        CommonReservationEvent commonReservationEvent = new CommonReservationEvent(this);
        addWindowListener(commonReservationEvent);

        setBounds(500, 300, 840, 480);
        setResizable(false);
        setVisible(true);
    }// CommonReservationView

    public CommonReservationView(String label, int viewNum, String parts) { // 예방,리콜 예약 신청 화면
        super(label);
        this.parts = parts;
        // 프레임의 배경색 설정
        this.getContentPane().setBackground(Color.decode("#002347"));
        jlReservationManagement = new JLabel(label);

        setComponent();

        ReservationDialogView rdv = new ReservationDialogView(viewNum, this); // viewNum : 정비 분류

        setLayout(null);
        jlReservationManagement.setBounds(320, 50, 400, 60);
        rdv.setBounds(100, 100, 600, 320);
        rdv.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));

        add(jlReservationManagement); // 라벨 배치
        add(rdv); // rdv를 CommonReservationView에 추가

        // 이벤트 추가
        CommonReservationEvent commonReservationEvent = new CommonReservationEvent(this);
        addWindowListener(commonReservationEvent);

        setBounds(500, 300, 840, 480);
        setResizable(false);
        setVisible(true);
    }// CommonReservationView


    private void setComponent() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } // end catch

        SwingUtilities.updateComponentTreeUI(this);
        jlReservationManagement.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        jlReservationManagement.setForeground(Color.WHITE);

    }// setComponent


    public String getParts() {
        return parts;
    }

    // public static void main(String[] args) {
    // new CommonReservationView("일반 정비 예약", ReservationDialogView.COMMON, "부품 이름");
    // new CommonReservationView("예방 정비 예약",ReservationDialogView.PREVENTI);
    // new CommonReservationView("리콜 예약",ReservationDialogView.RECALL);

    // }


}
