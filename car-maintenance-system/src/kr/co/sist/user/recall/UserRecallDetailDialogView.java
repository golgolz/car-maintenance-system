package kr.co.sist.user.recall;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import kr.co.sist.FontSingleton;
import kr.co.sist.admin.recall.RecallInfoVO;

@SuppressWarnings("serial")
public class UserRecallDetailDialogView extends JDialog {
    private RecallInfoVO currentRecallInfo;

    public UserRecallDetailDialogView(RecallInfoVO recallInfo, boolean isAdmin) {
        super();
        currentRecallInfo = recallInfo;
        setLayout(null);
        setBackground(Color.WHITE);
        this.getContentPane().setBackground(Color.WHITE);

        JLabel jlblTitle = new JLabel(recallInfo.getCarModel() + " 리콜 발생");
        JTextArea jtaContent = new JTextArea(
                recallInfo.getCarModel() + " 차량 모델에 대하여 리콜이 발생했습니다. \n대상 부품은 " + recallInfo.getPartName() + "입니다.");
        JLabel jlblImage = new JLabel(new ImageIcon(recallInfo.getImgFile()));
        JButton jbtnReserve = new JButton("예약하기");
        JButton jbtnOk = new JButton("확인");

        jtaContent.setEditable(false);
        jlblTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 20f));
        jtaContent.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jbtnReserve.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jbtnOk.setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        jlblImage.setBorder(new TitledBorder(recallInfo.getRecallDate().toString()));

        jbtnReserve.setForeground(Color.WHITE);
        jbtnOk.setForeground(Color.WHITE);
        jbtnReserve.setBackground(Color.decode("#4ba5e9"));
        jbtnOk.setBackground(Color.decode("#4ba5e9"));

        jlblTitle.setBounds(130, 10, 200, 30);
        jtaContent.setBounds(20, 50, 250, 50);
        jlblImage.setBounds(285, 10, 130, 100);
        if (isAdmin) {
            jbtnOk.setBounds(160, 115, 100, 30);
            add(jbtnOk);
        } else {
            jbtnReserve.setBounds(250, 115, 100, 30);
            jbtnOk.setBounds(85, 115, 100, 30);
            add(jbtnReserve);
            add(jbtnOk);
        }

        UserRecallDetailDialogEvent userRecallDetailDialogEvent = new UserRecallDetailDialogEvent(this);
        jbtnReserve.addActionListener(userRecallDetailDialogEvent);
        jbtnOk.addActionListener(userRecallDetailDialogEvent);

        add(jlblTitle);
        add(jtaContent);
        add(jlblImage);

        setSize(450, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public RecallInfoVO getCurrentRecallInfo() {
        return currentRecallInfo;
    }
}
