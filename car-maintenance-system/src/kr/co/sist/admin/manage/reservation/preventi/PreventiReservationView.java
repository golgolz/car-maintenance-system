package kr.co.sist.admin.manage.reservation.preventi;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class PreventiReservationView extends JFrame {
    private JTextField jtfOwnerId;
    private DefaultTableModel preventiReservations;
    private JTable preventiReservationTable;

    public PreventiReservationView() {
        super("예방 정비 예약 확인");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));

        JLabel jlblTitle = new JLabel("예방 정비 예약 확인");
        JLabel jlblOwnerId = new JLabel("사용자 ID");
        jtfOwnerId = new JTextField(10);
        JButton jbtnSearch = new JButton("검색");
        preventiReservations = new DefaultTableModel();
        createMaintenanceDialog();
        preventiReservationTable = new JTable(preventiReservations);
        JScrollPane preventiTargetScroll = new JScrollPane(preventiReservationTable);

        jlblTitle.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 27f));
        jlblOwnerId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(17f));
        jlblOwnerId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(17f));
        jbtnSearch.setFont(FontSingleton.getInstance().bonGodic.deriveFont(14f));
        preventiReservationTable.setFont(FontSingleton.getInstance().bonGodic.deriveFont(14f));
        preventiReservationTable.getTableHeader().setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        preventiReservationTable.setDefaultRenderer(Object.class, centerRenderer);

        preventiReservationTable.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        preventiReservationTable.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));

        preventiReservationTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        preventiReservationTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        preventiReservationTable.getColumnModel().getColumn(2).setPreferredWidth(90);
        preventiReservationTable.getColumnModel().getColumn(3).setPreferredWidth(90);
        preventiReservationTable.getColumnModel().getColumn(4).setPreferredWidth(40);

        jlblTitle.setBounds(17, 0, 250, 80);
        jlblOwnerId.setBounds(20, 87, 100, 30);
        jtfOwnerId.setBounds(100, 87, 100, 30);
        jbtnSearch.setBounds(220, 87, 60, 30);
        preventiTargetScroll.setBounds(20, 140, 770, 280);

        jbtnSearch.addActionListener(new PreventiReservationEvent(this));

        jlblTitle.setForeground(Color.WHITE);
        jlblOwnerId.setForeground(Color.WHITE);
        jbtnSearch.setForeground(Color.WHITE);
        jbtnSearch.setBackground(Color.decode("#065535"));

        add(jlblTitle);
        add(jlblOwnerId);
        add(jtfOwnerId);
        add(jbtnSearch);
        add(preventiTargetScroll);

        setSize(840, 480);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void createMaintenanceDialog() {
        String[] headerInfo = {"고객명", "ID", "연락처", "차량 번호", "모델", "예약일", "예약 사유", "정비 상태"};
        Object[][] preventiReservationData =
                {{"이명화", "lee", "010-1111-2222", "111가2222", "K5", "20-09-09", "엔진 오일", ""},
                        {"이명화", "lee", "010-3333-4444", "333나4444", "K5", "20-09-09", "와이퍼", ""}};
        preventiReservations = new DefaultTableModel(preventiReservationData, headerInfo);
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            setText("정비대기");
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

            button.setText("정비대기");
            return button;
        }

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
}
