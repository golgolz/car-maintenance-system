package kr.co.sist.admin.preventi.policy;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class PreventiPolicyDialog extends JDialog {
    private DefaultTableModel dtmPolicies;
    private JTable jtblPolicies;
    private JScrollPane jsp;

    public PreventiPolicyDialog() {
        super();
        setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        JLabel jlblTitle = new JLabel("예방 정비 지침");
        JLabel jlblContent = new JLabel("예방 정비 지침에 대한 안내입니다.");
        JButton jbtnCancle = new JButton("취소");
        JButton jbtnOk = new JButton("확인");

        String[] policyHeader = {"부품코드", "부품명", "주행거리 기준", "제조일 기준", "상세보기", "상세내용"};
        Object[][] policyData = null;

        try {
            policyData = createPolicyData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dtmPolicies = new DefaultTableModel(policyData, policyHeader);
        jtblPolicies = new JTable(dtmPolicies);
        jsp = new JScrollPane(jtblPolicies);

        jbtnCancle.setBounds(20, 250, 200, 40);
        jbtnOk.setBounds(330, 250, 200, 40);
        jbtnCancle.setBackground(Color.WHITE);
        jbtnOk.setBackground(Color.WHITE);

        jtblPolicies.getColumnModel().getColumn(5).setMaxWidth(0);
        jtblPolicies.getColumnModel().getColumn(5).setMinWidth(0);
        jtblPolicies.getColumnModel().getColumn(5).setWidth(0);
        jtblPolicies.getColumnModel().getColumn(5).setPreferredWidth(0);
        jtblPolicies.getColumnModel().getColumn(3).setWidth(110);
        jtblPolicies.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        jtblPolicies.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox()));

        int jtbWidth = 0;
        for (int i = 0; i < 6; i++) {
            jtbWidth += jtblPolicies.getColumnModel().getColumn(i).getWidth();
        }
        jsp.setBounds(20, 110, jtbWidth + 100, 120);

        jlblTitle.setFont(new Font("나눔고딕", Font.BOLD, 27));
        jlblTitle.setBounds(20, 20, 260, 40);
        jlblContent.setFont(new Font("굴림체", Font.PLAIN, 16));
        jlblContent.setBounds(25, 60, 300, 40);

        jbtnCancle.addActionListener(new PreventiPolicyEvent(this));
        jbtnOk.addActionListener(new PreventiPolicyEvent(this));

        add(jlblTitle);
        add(jlblContent);
        add(jsp);
        add(jbtnCancle);
        add(jbtnOk);

        setSize(570, 350);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public DefaultTableModel getDtmPolicies() {
        return dtmPolicies;
    }

    public JTable getJtblPolicies() {
        return jtblPolicies;
    }

    public JScrollPane getJsp() {
        return jsp;
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            setText("보기");
            return this;
        }
    }

    static class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String rowData;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    // JOptionPane.showMessageDialog(button, rowData);
                    new PreventiPolicyDetailDialog(rowData);
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }

            rowData = getRowData(table, row);
            button.setText("보기");
            return button;
        }

        private String getRowData(JTable table, int row) {
            StringBuilder rowData = new StringBuilder();
            rowData.append(table.getModel().getValueAt(row, 1)).append("/");
            rowData.append(table.getModel().getValueAt(row, 5));
            return rowData.toString();
        }

        public Object getCellEditorValue() {
            return "";
        }
    }

    public Object[][] createPolicyData() throws SQLException {
        List<PreventiPolicyVO> tempPolicies = PreventiPolicyDAO.getInstance().selectAllPolicies();
        Object[][] policies = new String[tempPolicies.size()][6];

        PreventiPolicyVO tempVO = null;
        int tempInt = 0;

        for (int i = 0; i < policies.length; i++) {
            tempVO = tempPolicies.get(i);
            policies[i][0] = tempVO.getPart();
            policies[i][1] = "엔진오일";
            policies[i][2] = "매 " + Integer.toString(tempVO.getDistancePeriod()) + "km";
            policies[i][4] = "보기";
            policies[i][5] = tempVO.getContent();

            tempInt = tempVO.getProductionPeriod();
            if (tempInt == 0) {
                policies[i][3] = "없음";
            } else {
                policies[i][3] = Integer.toString(tempInt) + "개월";
            }
        }
        return policies;
    }
}
