package kr.co.sist.admin.manage.inventory;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import kr.co.sist.FontSingleton;

@SuppressWarnings("serial")
public class InventoryView extends JFrame {
    private InventoryEvent inventoryEvent;

    private JLabel jlInventory;
    private JButton jbtnSelect;
    private JButton jbtnAdd;
    private JButton jbtnUpdate;

    private JTextField jtaSelect;

    private DefaultTableModel dtmDefaultInventoryData;
    private JTable jtInventoryDataTable;
    private JScrollPane jspInventoryData;

    private JDialog jdInventoryAddDialogView;
    private JDialog jdInventoryModifyDialogView;



    public InventoryView() {
        super("차량정비관리시스템");

        // 통일 코드
        this.getContentPane().setBackground(Color.decode("#002347"));



        setLocationRelativeTo(null);
        jlInventory = new JLabel("부품 재고 관리");
        jbtnSelect = new JButton("검색");
        jbtnAdd = new JButton("추가");
        jbtnUpdate = new JButton("변경");
        jtaSelect = new JTextField(10);

        String[] header = {"코드", "이름", "입고 일자", "판매가격", "재고량"};
        String[][] contents = {{"ENGO0321", "엔진오일", "2024-03-10", "20000", "15"},
                {"AUTO0302", "오토미션오일", "2024-02-10", "30000", "14"}};

        dtmDefaultInventoryData = new DefaultTableModel(contents, header);
        jtInventoryDataTable = new JTable(dtmDefaultInventoryData);

        // 테이블 헤더 폰트 설정 방법
        jtInventoryDataTable.getTableHeader().setFont(FontSingleton.getInstance().bonGodic.deriveFont(12f));
        // 테이블 정렬
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jtInventoryDataTable.setDefaultRenderer(Object.class, centerRenderer);


        jspInventoryData = new JScrollPane(jtInventoryDataTable);

        setLayout(null);

        // 폰트 , 크기, 스타일
        jlInventory.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.BOLD, 23f));
        jbtnSelect.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.PLAIN, 14f));
        jbtnAdd.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.PLAIN, 14f));
        jbtnUpdate.setFont(FontSingleton.getInstance().bonGodic.deriveFont(Font.PLAIN, 14f));


        jlInventory.setBounds(20, 10, 200, 30);
        jtaSelect.setBounds(580, 15, 150, 30);
        jbtnSelect.setBounds(740, 15, 80, 30);
        jspInventoryData.setBounds(20, 80, 780, 300);
        jbtnAdd.setBounds(600, 390, 80, 30);
        jbtnUpdate.setBounds(700, 390, 80, 30);

        add(jlInventory);
        add(jtaSelect);
        add(jbtnSelect);
        add(jbtnAdd);
        add(jbtnUpdate);
        add(jspInventoryData);

        // 폰트 색상
        jlInventory.setForeground(Color.WHITE);
        jbtnSelect.setForeground(Color.WHITE);
        jbtnAdd.setForeground(Color.WHITE);
        jbtnUpdate.setForeground(Color.WHITE);

        // jbtnSelect.setBackground(Color.decode("#47C832")); // 초록색
        jbtnSelect.setBackground(Color.decode("#5586EB")); // 파란색
        jbtnAdd.setBackground(Color.decode("#5586EB")); // 파란색
        jbtnUpdate.setBackground(Color.decode("#5586EB")); // 파란색

        inventoryEvent = new InventoryEvent(this);

        jbtnAdd.addActionListener(inventoryEvent);
        jbtnUpdate.addActionListener(inventoryEvent);
        addWindowListener(inventoryEvent);

        jbtnSelect.addActionListener(inventoryEvent);

        setBounds(200, 320, 840, 480);
        setVisible(true);
        setResizable(false);
        // setvisible후 프레임 위치 지정
        setLocationRelativeTo(null);
    }// InventoryView



    public InventoryEvent getInventoryEvent() {
        return inventoryEvent;
    }


    public JLabel getJlInventory() {
        return jlInventory;
    }


    public JButton getJbtnSelect() {
        return jbtnSelect;
    }


    public JButton getJbtnAdd() {
        return jbtnAdd;
    }


    public JButton getJbtnUpdate() {
        return jbtnUpdate;
    }


    public JTextField getJtaSelect() {
        return jtaSelect;
    }


    public DefaultTableModel getDtmDefaultInventoryData() {
        return dtmDefaultInventoryData;
    }


    public JTable getJtInventoryDataTable() {
        return jtInventoryDataTable;
    }


    public JScrollPane getJspInventoryData() {
        return jspInventoryData;
    }


    public JDialog getJdInventoryAddDialogView() {
        return jdInventoryAddDialogView;
    }


    public JDialog getJdInventoryModifyDialogView() {
        return jdInventoryModifyDialogView;
    }


    public static void main(String[] args) {
        new InventoryView();
    }

}
