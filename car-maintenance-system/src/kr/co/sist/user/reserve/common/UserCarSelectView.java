package kr.co.sist.user.reserve.common;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import kr.co.sist.FontSingleton;
import kr.co.sist.admin.recall.RecallDAO;
import kr.co.sist.login.LoginDAO;

@SuppressWarnings("serial")
public class UserCarSelectView extends JFrame {
    private JComboBox<String> carIdComboBox;

    public UserCarSelectView() {
        super("일반 정비 신청");
        UserCarSelectEvent userCarSelectEvent = new UserCarSelectEvent(this);

        setLayout(null);

        this.getContentPane().setBackground(Color.decode("#002347"));

        JLabel jlblTitle = new JLabel("소유 차량 확인");
        JLabel jlblCarId = new JLabel("차량 번호");
        JButton jbtnSearch = new JButton("검색");
        try {
            carIdComboBox = new JComboBox<>(
                    RecallDAO.getInstance().selectUserCarInfo(LoginDAO.getInstance().getCurrentUserId()));
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

        jbtnSearch.addActionListener(userCarSelectEvent);

        add(jlblTitle);
        add(jlblCarId);
        add(carIdComboBox);
        add(jbtnSearch);

        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public JComboBox<String> getCarIdComboBox() {
        return carIdComboBox;
    }
}
