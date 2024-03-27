package kr.co.sist.admin.recall;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import kr.co.sist.FontSingleton;
import kr.co.sist.user.recall.UserRecallDetailDialogView;

@SuppressWarnings("serial")
public class AdminRecallView extends JFrame {
    private JTextField jtfCarId;
    private JTextField jtfOwnerId;
    private DefaultTableModel recallInfoModel;
    private JTable recallInfoTable;

    public AdminRecallView() {
        super("리콜 정보 조회");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));

        JLabel jlblTitle = new JLabel("리콜 정보 조회");
        JLabel jlblCarId = new JLabel("차량 번호");
        jtfCarId = new JTextField(10);
        JLabel jlblOwnerId = new JLabel("사용자 ID");
        jtfOwnerId = new JTextField(10);
        JButton jbtnSearch = new JButton("검색");

        String[] headerInfo = {"고객명", "ID", "연락처", "차량 번호", "모델", "리콜 상세 내역", "리콜 현황"};
        try {
            recallInfoModel = new DefaultTableModel(showAllRecallTargets(), headerInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        recallInfoTable = new JTable(recallInfoModel);
        JScrollPane preventiTargetScroll = new JScrollPane(recallInfoTable);

        jlblTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        jlblTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        jlblCarId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(17f));
        jlblOwnerId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(17f));
        jbtnSearch.setFont(FontSingleton.getInstance().bonGodic.deriveFont(14f));
        recallInfoTable.setFont(FontSingleton.getInstance().bonGodic.deriveFont(14f));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        recallInfoTable.setDefaultRenderer(Object.class, centerRenderer);
        recallInfoTable.getTableHeader().setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        recallInfoTable.getColumnModel().getColumn(0).setMaxWidth(70);
        recallInfoTable.getColumnModel().getColumn(1).setMaxWidth(70);
        recallInfoTable.getColumnModel().getColumn(2).setPreferredWidth(120);

        recallInfoTable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        recallInfoTable.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));

        jlblTitle.setBounds(17, 0, 250, 80);
        jlblCarId.setBounds(20, 87, 100, 30);
        jtfCarId.setBounds(100, 87, 100, 30);
        jlblOwnerId.setBounds(220, 87, 100, 30);
        jtfOwnerId.setBounds(300, 87, 100, 30);
        jbtnSearch.setBounds(450, 87, 60, 30);
        preventiTargetScroll.setBounds(20, 140, 770, 280);

        jbtnSearch.addActionListener(new AdminRecallEvent(this));

        jlblTitle.setForeground(Color.WHITE);
        jlblCarId.setForeground(Color.WHITE);
        jlblOwnerId.setForeground(Color.WHITE);
        jbtnSearch.setForeground(Color.WHITE);
        jbtnSearch.setBackground(Color.decode("#065535"));

        add(jlblTitle);
        add(jlblCarId);
        add(jtfCarId);
        add(jlblOwnerId);
        add(jtfOwnerId);
        add(jbtnSearch);
        add(preventiTargetScroll);

        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JTextField getJtfCarId() {
        return jtfCarId;
    }

    public JTextField getJtfOwnerId() {
        return jtfOwnerId;
    }

    public DefaultTableModel getRecallInfoModel() {
        return recallInfoModel;
    }

    public Object[][] showAllRecallTargets() throws SQLException {
        List<RecallTargetVO> recallTargets = RecallDAO.getInstance().selectAllRecallTargets();
        Object[][] recallTargetModel = new Object[recallTargets.size()][7];
        int cnt = 0;
        for (RecallTargetVO target : recallTargets) {
            recallTargetModel[cnt][0] = target.getOwnerName();
            recallTargetModel[cnt][1] = target.getOwnerId();
            recallTargetModel[cnt][2] = target.getOwnerTel();
            recallTargetModel[cnt][3] = target.getCarId();
            recallTargetModel[cnt][4] = target.getCarModel();
            recallTargetModel[cnt][5] = "";
            recallTargetModel[cnt][6] = target.getRecallStatus();
            cnt += 1;
        }

        return recallTargetModel;
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            setText("조회");
            return this;
        }
    }

    static class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String carModel;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    RecallInfoVO currentInfo = null;
                    try {
                        currentInfo = RecallDAO.getInstance().selectOneRecallInfoByModel(carModel);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    if (currentInfo == null) {
                        return;
                    }

                    new UserRecallDetailDialogView(currentInfo);
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

            carModel = getRowData(table, row);
            button.setText("조회");
            return button;
        }

        private String getRowData(JTable table, int row) {
            StringBuilder rowData = new StringBuilder();
            rowData.append(table.getModel().getValueAt(row, 4));
            return rowData.toString();
        }

        // public Object getCellEditorValue() {
        // return "";
        // }
    }
}
