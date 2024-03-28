package kr.co.sist.admin.register.car;

import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import kr.co.sist.FontSingleton;

@SuppressWarnings("serial")
public class CarModifyDialog extends JDialog {

    private JButton jbtnOk, jbtnCancel;
    private JTextField jtfCarId, jtfCarModel, jtfDriveDistance, jtfCarProductionDate, jtfOwnerId;

    public CarModifyDialog(AdminRegisteredCarView adminRegisteredCarView, String ownerId, String carId, String carModel,
            int driveDistance, Date productionDate) {
        super(adminRegisteredCarView, "차량 수정", true);
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#FFFFFF"));
        JLabel jlblTitle = new JLabel("차량 정보 수정");
        jlblTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        JLabel jlblCarId = new JLabel("차량번호");
        JLabel jlblCarModel = new JLabel("모델");
        JLabel jlblDriveDistance = new JLabel("주행거리");
        JLabel jlblProductionDate = new JLabel("제조일자");
        JLabel jlblOwnerId = new JLabel("사용자 아이디");

        jtfCarId = new JTextField();
        jtfCarId.setEditable(false);
        jtfCarId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jtfCarId.setText(carId);

        jtfCarModel = new JTextField();
        jtfCarModel.setEditable(false);
        jtfCarModel.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jtfCarModel.setText(carModel);

        jtfDriveDistance = new JTextField();
        jtfDriveDistance.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jtfDriveDistance.setText(String.valueOf(driveDistance));


        jtfCarProductionDate = new JTextField();
        jtfCarProductionDate.setEditable(false);
        jtfCarProductionDate.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jtfCarProductionDate.setText(String.valueOf(productionDate));


        jtfOwnerId = new JTextField();
        jtfOwnerId.setEditable(false);
        jtfOwnerId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jtfOwnerId.setText(ownerId);


        jbtnOk = new JButton("확인");
        jbtnOk.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));
        jbtnCancel = new JButton("취소");
        jbtnCancel.setFont(FontSingleton.getInstance().bonGodic.deriveFont(16f));

        jbtnOk.setBackground(Color.decode("#002347"));
        jbtnCancel.setBackground(Color.decode("#47C83E"));

        CarModifyDialogEvent carModifyDialogEvent = new CarModifyDialogEvent(this);
        jbtnOk.addActionListener(carModifyDialogEvent);
        jbtnCancel.addActionListener(carModifyDialogEvent);

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
    }


    public JButton getJbtnOk() {
        return jbtnOk;
    }


    public JButton getJbtnCancel() {
        return jbtnCancel;
    }


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
}
