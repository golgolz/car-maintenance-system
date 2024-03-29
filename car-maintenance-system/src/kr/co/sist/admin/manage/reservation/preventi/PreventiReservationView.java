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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import kr.co.sist.FontSingleton;

@SuppressWarnings("serial")
public class PreventiReservationView extends JFrame {
    private JTextField jtfOwnerId;
    private DefaultTableModel preventiReservations;
    private JTable preventiReservationTable;

    public PreventiReservationView() {
        super("예방 정비 예약");
        setLayout(null);
        this.getContentPane().setBackground(Color.decode("#002347"));

        JLabel jlblTitle = new JLabel("예방 정비 신청 차량");
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

        preventiReservationTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        preventiReservationTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        preventiReservationTable.getColumnModel().getColumn(2).setPreferredWidth(120);

        preventiReservationTable.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        preventiReservationTable.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));

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

    public JTextField getJtfOwnerId() {
        return jtfOwnerId;
    }

    public DefaultTableModel getPreventiReservations() {
        return preventiReservations;
    }

    public JTable getPreventiReservationTable() {
        return preventiReservationTable;
    }

    public Object[][] createReservationData() throws SQLException {
        List<ReservationManagementVO> reservations = null;
        reservations = ReservationManagementDAO.getInstance().selectReservation("정기");
        Object[][] reservationData = new String[reservations.size()][8];
        ReservationManagementVO tempVO = null;

        for (int i = 0; i < reservationData.length; i++) {
            tempVO = reservations.get(i);
            reservationData[i][0] = tempVO.getTel();
            reservationData[i][1] = tempVO.getOwnerId();
            reservationData[i][2] = tempVO.getName();
            reservationData[i][3] = tempVO.getCarId();
            reservationData[i][4] = tempVO.getCarModel();
            reservationData[i][5] = tempVO.getReservationDate();
            reservationData[i][6] = tempVO.getReserveReason();
            reservationData[i][7] = "정비대기";
        }

        return reservationData;
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
