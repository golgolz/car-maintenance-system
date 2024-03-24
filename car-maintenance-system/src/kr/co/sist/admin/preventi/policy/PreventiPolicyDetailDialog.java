package kr.co.sist.admin.preventi.policy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PreventiPolicyDetailDialog extends JDialog implements ActionListener {
    public PreventiPolicyDetailDialog(String printData) {
        super();
        setLayout(null);
        String[] printStr = printData.split("/");
        JLabel jlblTitle = new JLabel(printStr[0]);
        JLabel jlblContent = new JLabel(printStr[1]);
        JButton jbtnCancle = new JButton("취소");
        JButton jbtnOk = new JButton("확인");

        jlblTitle.setFont(new Font("굴림체", Font.BOLD, 25));
        jlblTitle.setBounds(20, 20, 350, 30);
        jlblContent.setFont(new Font("굴림체", Font.BOLD, 17));
        jlblContent.setBounds(20, 60, 400, 30);
        jbtnCancle.setBounds(20, 110, 200, 40);
        jbtnOk.setBounds(260, 110, 200, 40);
        jbtnCancle.setBackground(Color.WHITE);
        jbtnOk.setBackground(Color.WHITE);

        jbtnCancle.addActionListener(this);
        jbtnOk.addActionListener(this);

        add(jlblTitle);
        add(jlblContent);
        add(jbtnCancle);
        add(jbtnOk);

        setSize(500, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}
