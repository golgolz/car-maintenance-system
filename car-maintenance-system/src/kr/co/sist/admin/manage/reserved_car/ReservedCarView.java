package kr.co.sist.admin.manage.reserved_car;

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
import kr.co.sist.admin.manage.reservation.common.MaintenanceProgressView;

public class ReservedCarView extends JFrame {
    private ReservedCarEvent reservedCarEvent;

    private JLabel jlReservedCarView;
    private JLabel jlCarId;
    private JLabel jlOwnerId;

    private JTextField jtfCarId;
    private JTextField jtfOwnerId;
    private JButton jbtnSearch;
    private JButton jbtnMaintenanceProgress;

    private DefaultTableModel dtmReservedCar;
    private JTable jtReservedCar;
    private JScrollPane jspReservedCarData;

    private String maintenanceStatusText;

    public ReservedCarView() {
        super("입고차량관리");
        this.getContentPane().setBackground(Color.decode("#002347"));

        jlReservedCarView = new JLabel("입고 차량 관리");
        jlCarId = new JLabel("차량 번호");
        jlOwnerId = new JLabel("ID");

        jtfCarId = new JTextField();
        jtfOwnerId = new JTextField();
        jbtnSearch = new JButton("검색");
        jbtnMaintenanceProgress = new JButton("정비 대기");

        maintenanceStatusText = jbtnMaintenanceProgress.getText();

        dtmReservedCar = new DefaultTableModel();

        dtmReservedCar.addColumn("차량번호");
        dtmReservedCar.addColumn("연식");
        dtmReservedCar.addColumn("주행거리");
        dtmReservedCar.addColumn("정비입고일");
        dtmReservedCar.addColumn("정비출고일");
        dtmReservedCar.addColumn("사용자ID");
        dtmReservedCar.addColumn("정비분류");
        dtmReservedCar.addColumn("정비상태");

        String[] headerInfo = {"ID", "차량번호", "연식", "주행거리", "정비 입고일", "정비 출고일", "정비 분류", "정비 상태"};
        try {
            dtmReservedCar = new DefaultTableModel(showAllReservedcarData(), headerInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jtReservedCar = new JTable(dtmReservedCar);
        jspReservedCarData = new JScrollPane(jtReservedCar);

        jtReservedCar.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        jtReservedCar.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));

        jtReservedCar.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtReservedCar.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtReservedCar.getColumnModel().getColumn(2).setPreferredWidth(100);
        jtReservedCar.getColumnModel().getColumn(3).setPreferredWidth(100);
        jtReservedCar.getColumnModel().getColumn(4).setPreferredWidth(100);
        jtReservedCar.getColumnModel().getColumn(5).setPreferredWidth(100);
        jtReservedCar.getColumnModel().getColumn(6).setPreferredWidth(100);
        jtReservedCar.getColumnModel().getColumn(7).setPreferredWidth(100);

        // Set layout
        setLayout(null);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jtReservedCar.setDefaultRenderer(Object.class, centerRenderer);

        jlReservedCarView.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jlCarId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.PLAIN, 14f));
        jlOwnerId.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.PLAIN, 14f));


        jlReservedCarView.setBounds(20, 10, 200, 30);
        jlCarId.setBounds(20, 50, 100, 30);
        jlOwnerId.setBounds(150, 50, 100, 30);
        jtfCarId.setBounds(20, 90, 100, 30);
        jtfOwnerId.setBounds(150, 90, 100, 30);
        jbtnSearch.setBounds(280, 90, 80, 30);
        jspReservedCarData.setBounds(20, 140, 780, 280);

        jlReservedCarView.setForeground(Color.WHITE);
        jlCarId.setForeground(Color.WHITE);
        jlOwnerId.setForeground(Color.WHITE);

        jbtnSearch.setForeground(Color.WHITE);
        jbtnSearch.setBackground(Color.decode("#065535")); // 초록색
        jbtnMaintenanceProgress.setBackground(Color.decode("#FF0000")); // 빨간색
        jbtnSearch.addActionListener(new ReservedCarEvent(this));

        add(jlReservedCarView);
        add(jlCarId);
        add(jtfCarId);
        add(jlOwnerId);
        add(jtfOwnerId);
        add(jbtnSearch);
        add(jbtnMaintenanceProgress);
        add(jspReservedCarData);

        setBounds(200, 320, 840, 480);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public JTextField getJtfCarId() {
        return jtfCarId;
    }

    public JTextField getJtfOwnerId() {
        return jtfOwnerId;
    }

    public ReservedCarEvent getReservedCarEvent() {
        return reservedCarEvent;
    }

    public JLabel getJlReservedCarView() {
        return jlReservedCarView;
    }

    public JLabel getJlCarId() {
        return jlCarId;
    }

    public JLabel getJlOwnerId() {
        return jlOwnerId;
    }

    public JButton getJbtnSearch() {
        return jbtnSearch;
    }

    public JButton getJbtnMaintenanceProgress() {
        return jbtnMaintenanceProgress;
    }

    public DefaultTableModel getDtmReservedCar() {
        return dtmReservedCar;
    }

    public JTable getJtReservedCar() {
        return jtReservedCar;
    }

    public JScrollPane getJspReservedCarData() {
        return jspReservedCarData;
    }

    public String getMaintenanceStatusText() {
        return maintenanceStatusText;
    }

    public Object[][] showAllReservedcarData() throws SQLException {
        List<ReservedCarVO> reservedCars = ReservedCarDAO.getInstance().selectReservedAllCar();
        Object[][] reservdCarModel = new Object[reservedCars.size()][7];
        int cnt = 0;

        for (ReservedCarVO target : reservedCars) {
            reservdCarModel[cnt][0] = target.getOwnerId();
            reservdCarModel[cnt][1] = target.getCarId();
            reservdCarModel[cnt][2] = target.getCarYear();
            reservdCarModel[cnt][3] = target.getDriveDistance();
            reservdCarModel[cnt][4] = target.getReservedDate();
            reservdCarModel[cnt][5] = target.getReleasedDate();
            reservdCarModel[cnt][6] = target.getMaintenanceStatus();
            reservdCarModel[cnt][6] = "";

            cnt += 1;
        }

        return reservdCarModel;
    }

    // Button renderer class
    class ButtonRenderer extends JButton implements TableCellRenderer {
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
                    new MaintenanceProgressView(rowData, "정기");
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
            rowData.append(table.getModel().getValueAt(row, 0));
            return rowData.toString();
        }
    }
}
