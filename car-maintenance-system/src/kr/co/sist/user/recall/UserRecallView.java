package kr.co.sist.user.recall;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserRecallView extends JFrame {
    private JComboBox<String> carIdComboBox;

    public UserRecallView() {
        super("리콜 대상 확인");
        UserRecallEvent userRecallEvent = new UserRecallEvent(this);

        setLayout(null);

        this.getContentPane().setBackground(Color.decode("#002347"));

        JLabel jlblTitle = new JLabel("리콜 대상 확인");
        JLabel jlblCarId = new JLabel("차량 번호");
        JButton jbtnSearch = new JButton("검색");
        carIdComboBox = new JComboBox<>(userRecallEvent.createUserCarInfo());

        jlblTitle.setFont(new Font("나눔고딕", Font.BOLD, 27));
        jlblCarId.setFont(new Font("나눔고딕", Font.PLAIN, 17));
        jbtnSearch.setFont(new Font("나눔고딕", Font.PLAIN, 14));

        jlblTitle.setBounds(317, 50, 250, 80);
        jlblCarId.setBounds(275, 125, 100, 30);
        carIdComboBox.setBounds(345, 125, 120, 30);
        jbtnSearch.setBounds(465, 125, 60, 30);

        jlblTitle.setForeground(Color.WHITE);
        jlblCarId.setForeground(Color.WHITE);
        jbtnSearch.setForeground(Color.BLACK);
        jbtnSearch.setBackground(Color.WHITE);

        jbtnSearch.addActionListener(userRecallEvent);

        add(jlblTitle);
        add(jlblCarId);
        add(carIdComboBox);
        add(jbtnSearch);

        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JComboBox<String> getCarIdComboBox() {
        return carIdComboBox;
    }

    public static void main(String[] args) {
        new UserRecallView();
    }
}
