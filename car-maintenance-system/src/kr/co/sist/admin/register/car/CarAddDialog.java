package kr.co.sist.admin.register.car;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import kr.co.sist.FontSingleton;


@SuppressWarnings("serial")
public class CarAddDialog extends JDialog {

    private JButton jbtnOk, jbtnCancel;
    private JTextField jtfCarId, jtfCarModel, jtfDriveDistance, jtfCarProductionDate, jtfOwnerId;

    public CarAddDialog(AdminRegisteredCarView adminRegisteredCarView) {
        super(adminRegisteredCarView, "차량 추가", true);
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#FFFFFF"));
        JLabel jlblTitle = new JLabel("차량 추가");
        jlblTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        JLabel jlblCarId = new JLabel("차량번호");
        JLabel jlblCarModel = new JLabel("모델");
        JLabel jlblDriveDistance = new JLabel("주행거리");
        JLabel jlblProductionDate = new JLabel("제조일자");
        JLabel jlblOwnerId = new JLabel("사용자 아이디");

        jtfCarId = new JTextField();
        jtfCarId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jtfCarModel = new JTextField();
        jtfCarModel.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jtfDriveDistance = new JTextField();
        jtfDriveDistance.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jtfCarProductionDate = new JTextField();
        jtfCarProductionDate.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jtfOwnerId = new JTextField();
        jtfOwnerId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));

        jbtnOk = new JButton("확인");
        jbtnOk.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jbtnCancel = new JButton("취소");
        jbtnCancel.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));

        jbtnOk.setBackground(Color.decode("#065535"));
        jbtnCancel.setBackground(Color.decode("#5D5D5D"));

        CarAddDialogEvent carAddDialogEvent = new CarAddDialogEvent(this);
        jbtnOk.addActionListener(carAddDialogEvent);
        jbtnCancel.addActionListener(carAddDialogEvent);



        setLayout(null);
        jlblTitle.setBounds(30, 0, 1000, 100);
        jlblOwnerId.setBounds(30, 50, 100, 100);
        jlblCarId.setBounds(30, 100, 100, 100);
        jlblCarModel.setBounds(30, 150, 100, 100);
        jlblDriveDistance.setBounds(30, 200, 100, 100);
        jlblProductionDate.setBounds(30, 250, 100, 100);

        jtfOwnerId.setBounds(30, 115, 220, 25);
        jtfCarId.setBounds(30, 160, 220, 25);
        jtfCarModel.setBounds(30, 210, 220, 25);
        jtfDriveDistance.setBounds(30, 260, 220, 25);
        jtfCarProductionDate.setBounds(30, 310, 220, 25);

        jbtnOk.setBounds(50, 400, 80, 25);
        jbtnCancel.setBounds(150, 400, 80, 25);

        jbtnOk.setForeground(Color.WHITE);
        jbtnCancel.setForeground(Color.WHITE);
        add(jlblTitle);
        add(jlblCarId);
        add(jlblCarModel);
        add(jlblDriveDistance);
        add(jlblProductionDate);
        add(jlblOwnerId);

        add(jtfCarId);
        add(jtfCarModel);
        add(jtfDriveDistance);
        add(jtfCarProductionDate);
        add(jtfOwnerId);

        add(jbtnOk);
        add(jbtnCancel);

        setSize(300, 500);
        setVisible(true);
        setLocationRelativeTo(null);

    }// CarAddDialog



    public JTextField getJtfCarId() {
        return jtfCarId;
    }



    public JTextField getJtfCarModel() {
        return jtfCarModel;
    }



    public JTextField getJtfDriveDistance() {
        return jtfDriveDistance;
    }



    public JTextField getJtfCarProductionDate() {
        return jtfCarProductionDate;
    }



    public JTextField getJtfOwnerId() {
        return jtfOwnerId;
    }



    public JButton getJbtnOk() {
        return jbtnOk;
    }



    public JButton getJbtnCancel() {
        return jbtnCancel;
    }



}


