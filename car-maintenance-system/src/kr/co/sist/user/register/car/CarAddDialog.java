package kr.co.sist.user.register.car;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CarAddDialog extends JDialog {

    private JTextField jtfCarId, jtfCarModel, jtfDriveDistance, jtfCarProductionDate;
    private JButton jbtnOk, jbtnCancel;

    public CarAddDialog() {
        super();
        JLabel jlblTitle = new JLabel("차량 추가");
        JLabel jlblCarId = new JLabel("차량번호");
        JLabel jlblCarModel = new JLabel("모델");
        JLabel jlblDriveDistance = new JLabel("주행거리");
        JLabel jlblProductionDate = new JLabel("제조일자");

        jtfCarId = new JTextField();
        jtfCarModel = new JTextField();
        jtfDriveDistance = new JTextField();
        jtfCarProductionDate = new JTextField();

        jbtnOk = new JButton("확인");
        jbtnCancel = new JButton("취소");



        setLayout(null);

        jlblTitle.setBounds(30, 0, 100, 100);
        jlblCarId.setBounds(30, 50, 100, 100);
        jlblCarModel.setBounds(30, 100, 100, 100);
        jlblDriveDistance.setBounds(30, 150, 100, 100);
        jlblProductionDate.setBounds(30, 200, 100, 100);

        jtfCarId.setBounds(30, 115, 200, 25);
        jtfCarModel.setBounds(30, 160, 200, 25);
        jtfDriveDistance.setBounds(30, 210, 200, 25);
        jtfCarProductionDate.setBounds(30, 260, 200, 25);

        jbtnOk.setBounds(50, 330, 80, 25);
        jbtnCancel.setBounds(150, 330, 80, 25);

        add(jlblTitle);
        add(jlblCarId);
        add(jlblCarModel);
        add(jlblDriveDistance);
        add(jlblProductionDate);

        add(jtfCarId);
        add(jtfCarModel);
        add(jtfDriveDistance);
        add(jtfCarProductionDate);

        add(jbtnOk);
        add(jbtnCancel);

        setSize(300, 450);
        setVisible(true);


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

    public JButton getJbtnOk() {
        return jbtnOk;
    }

    public JButton getJbtnCancel() {
        return jbtnCancel;
    }

}

