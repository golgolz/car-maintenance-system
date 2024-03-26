package kr.co.sist.user.recall;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import kr.co.sist.FontSingleton;
import kr.co.sist.admin.recall.RecallDAO;

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
        try {
            carIdComboBox = new JComboBox<>(RecallDAO.getInstance().selectUserCarInfo("lee"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jlblTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        jlblCarId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(17f));
        jbtnSearch.setFont(FontSingleton.getInstance().bonGodic.deriveFont(14f));
        carIdComboBox.setFont(FontSingleton.getInstance().bonGodic.deriveFont(14f));

        jlblTitle.setBounds(317, 50, 250, 80);
        jlblCarId.setBounds(265, 125, 100, 30);
        carIdComboBox.setBounds(345, 125, 120, 30);
        jbtnSearch.setBounds(475, 125, 60, 30);

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
