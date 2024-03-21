package kr.co.sist.admin.preventi.policy;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class PreventiPolicyDialog extends JDialog {
    public PreventiPolicyDialog() {
        super();
        setLayout(null);
        JLabel jlblTitle = new JLabel("예방 정비 지침");
        JLabel jlblContent = new JLabel("예방 정비 지침에 대한 안내입니다.");

        String[] policyHeader = {"부품코드", "부품명", "주행거리 기준", "제조일 기준", "상세보기"};
        String[][] dumpData = null;

        // try {
        // dumpData = createPolicyData();
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }

        DefaultTableModel dtmPolicies = new DefaultTableModel(dumpData, policyHeader);
        JTable jtblPolicies = new JTable(dtmPolicies);
        JScrollPane jsp = new JScrollPane(jtblPolicies);

        jlblTitle.setFont(new Font("굴림체", Font.BOLD, 25));
        jlblTitle.setBounds(20, 20, 260, 40);
        jlblContent.setFont(new Font("굴림체", Font.PLAIN, 15));
        jlblContent.setBounds(25, 60, 260, 40);
        jsp.setBounds(20, 110, 300, 120);

        add(jlblTitle);
        add(jlblContent);
        add(jsp);

        setSize(840, 480);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public String[][] createPolicyData() throws SQLException {
        List<PreventiPolicyVO> tempPolicies = PreventiPolicyDAO.getInstance().selectAllPolicies();
        String[][] policies = new String[tempPolicies.size()][5];

        PreventiPolicyVO tempVO = null;

        for (int i = 0; i < policies.length; i++) {
            tempVO = tempPolicies.get(i);
            policies[i][0] = tempVO.getPart();
            // policies[i][1] = tempVO.getDistancePeriod();
            policies[i][1] = "-";
            policies[i][2] = Integer.toString(tempVO.getDistancePeriod());
            policies[i][3] = Integer.toString(tempVO.getManufacturePeriod());
            policies[i][4] = tempVO.getContent();
        }
        return policies;
    }
}
