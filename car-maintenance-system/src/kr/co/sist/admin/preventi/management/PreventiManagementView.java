package kr.co.sist.admin.preventi.management;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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

@SuppressWarnings("serial")
public class PreventiManagementView extends JFrame {
    private JTextField jtfCarId;
    private JTextField jtfOwnerId;
    private DefaultTableModel preventiTargets;
    private JTable preventiTargetTable;

    public PreventiManagementView() {
        super("예방 정비 대상 차량");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));
        PreventiManagementEvent preventiManagementEvent = new PreventiManagementEvent(this);

        JLabel jlblTitle = new JLabel("예방 정비 대상 차량");
        JLabel jlblCarId = new JLabel("차량 번호");
        jtfCarId = new JTextField(10);
        JLabel jlblOwnerId = new JLabel("사용자 ID");
        jtfOwnerId = new JTextField(10);
        JButton jbtnSearch = new JButton("검색");
        JButton jbtnPreventiPolicy = new JButton("예방 정비 지침 확인");

        String[] headerInfo = {"차량번호", "ID", "모델", "주행거리", "예약여부", "정비이력", "정비상태", "제조일", "예약일", "점검사유"};
        try {
            preventiTargets = new DefaultTableModel(preventiManagementEvent.showAllPreventi(), headerInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // createMaintenanceHistoryDialog();
        preventiTargetTable = new JTable(preventiTargets);
        JScrollPane preventiTargetScroll = new JScrollPane(preventiTargetTable);

        jlblTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        jlblCarId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(17f));
        jlblOwnerId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(17f));
        jbtnSearch.setFont(FontSingleton.getInstance().bonGodic.deriveFont(14f));
        jbtnPreventiPolicy.setFont(FontSingleton.getInstance().bonGodic.deriveFont(14f));
        preventiTargetTable.getTableHeader().setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        preventiTargetTable.setFont(FontSingleton.getInstance().bonGodic.deriveFont(14f));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        preventiTargetTable.setDefaultRenderer(Object.class, centerRenderer);
        preventiTargetTable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        preventiTargetTable.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));

        preventiTargetTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        preventiTargetTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        preventiTargetTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        preventiTargetTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        preventiTargetTable.getColumnModel().getColumn(5).setPreferredWidth(50);
        preventiTargetTable.getColumnModel().getColumn(6).setPreferredWidth(50);
        preventiTargetTable.getColumnModel().getColumn(9).setPreferredWidth(150);

        jlblTitle.setBounds(17, 0, 250, 80);
        jlblCarId.setBounds(20, 87, 100, 30);
        jtfCarId.setBounds(100, 87, 100, 30);
        jlblOwnerId.setBounds(220, 87, 100, 30);
        jtfOwnerId.setBounds(300, 87, 100, 30);
        jbtnSearch.setBounds(450, 87, 60, 30);
        jbtnPreventiPolicy.setBounds(630, 30, 160, 30);
        preventiTargetScroll.setBounds(20, 140, 770, 280);

        jlblTitle.setForeground(Color.WHITE);
        jlblCarId.setForeground(Color.WHITE);
        jlblOwnerId.setForeground(Color.WHITE);
        jbtnSearch.setForeground(Color.WHITE);
        jbtnPreventiPolicy.setForeground(Color.WHITE);
        jbtnSearch.setBackground(Color.decode("#065535"));
        jbtnPreventiPolicy.setBackground(Color.decode("#065535"));

        jbtnSearch.addActionListener(preventiManagementEvent);
        jbtnPreventiPolicy.addActionListener(preventiManagementEvent);

        add(jlblTitle);
        add(jlblCarId);
        add(jtfCarId);
        add(jlblOwnerId);
        add(jtfOwnerId);
        add(jbtnSearch);
        add(jbtnPreventiPolicy);
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

    public DefaultTableModel getPreventiTargets() {
        return preventiTargets;
    }

    public void setPreventiTargets(DefaultTableModel newTargets) {
        this.preventiTargets = newTargets;
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

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setBackground(Color.decode("#385da6"));
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
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

            button.setText("보기");
            return button;
        }

        @SuppressWarnings("unused")
        private String getRowData(JTable table, int row) {
            StringBuilder rowData = new StringBuilder();
            rowData.append(table.getModel().getValueAt(row, 1)).append("/");
            rowData.append(table.getModel().getValueAt(row, 5));
            return rowData.toString();
        }

        // public Object getCellEditorValue() {
        // return "";
        // }
    }

    public void createMaintenanceHistoryDialog() {

    }
}
