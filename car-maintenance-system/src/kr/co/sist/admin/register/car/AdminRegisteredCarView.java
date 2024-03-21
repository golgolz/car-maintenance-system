package kr.co.sist.admin.register.car;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

// 참고 코드 : admin.preventi.policy.PreventiPolicyDialog.java(JTable)
@SuppressWarnings("serial")
public class AdminRegisteredCarView extends JFrame {

    private JLabel jlbRegisteredTitle, jlbCarIdTitle, jlbIdTitle;
    private JTextField jtfCarId, jtfldId;
    private JButton jbtnSearch, jbtnAddCar, jbtnModify, jbtnRemove;
    // private DefaultTableModel carModel;
    // private JTable carTable;
    // private JScrollPane jsp;

    public AdminRegisteredCarView() {
        super("차량 정비 관리 시스템");

        jlbRegisteredTitle = new JLabel("등록 차량관리");
        jlbCarIdTitle = new JLabel("차량번호");
        jlbIdTitle = new JLabel("ID");

        jtfCarId = new JTextField();
        jtfldId = new JTextField();

        jbtnSearch = new JButton("조회");
        jbtnAddCar = new JButton("추가");
        jbtnModify = new JButton("수정");
        jbtnRemove = new JButton("삭제");

        String[] CarTableHeader = {"차량번호", "연식", "모델", "주행거리", "등록일", "사용자ID"};
        String[][] dumpData = null;
        DefaultTableModel carModel = new DefaultTableModel(dumpData, CarTableHeader);
        JTable carTable = new JTable(carModel);
        JScrollPane jsp = new JScrollPane(carTable);

        carTable = new JTable(carModel);

        setLayout(null);

        jlbRegisteredTitle.setBounds(50, 0, 100, 100);
        jlbCarIdTitle.setBounds(50, 50, 100, 100);
        jlbIdTitle.setBounds(230, 90, 100, 25);

        jtfCarId.setBounds(110, 90, 100, 25);
        jtfldId.setBounds(250, 90, 100, 25);

        jbtnSearch.setBounds(380, 90, 60, 25);
        jbtnAddCar.setBounds(540, 90, 60, 25);
        jbtnModify.setBounds(620, 90, 60, 25);
        jbtnRemove.setBounds(700, 90, 60, 25);
        // carTable.setBounds(50, 125, 730, 280);
        jsp.setBounds(50, 125, 730, 280);

        add(jlbRegisteredTitle);
        add(jlbCarIdTitle);
        add(jlbIdTitle);

        add(jtfCarId);
        add(jtfldId);

        add(jbtnSearch);
        add(jbtnAddCar);
        add(jbtnModify);
        add(jbtnRemove);

        add(carTable);
        add(jsp);

        setSize(840, 480);
        setVisible(true);

    }// RegisteredCarView

    public String[][] createCarModelData() throws SQLException {
        List<RegisteredCarVO> tempRegisetedCar = RegisteredCarDAO.getInstance().selectAllCar();
        String[][] carList = new String[tempRegisetedCar.size()][6];

        RegisteredCarVO tempRVO = null;

        for (int i = 0; i < carList.length; i++) {
            tempRVO = tempRegisetedCar.get(i);
            carList[i][0] = tempRVO.getCarId();
            carList[i][1] = tempRVO.getOwnerId();
            carList[i][2] = tempRVO.getCarModel();
            carList[i][3] = String.valueOf(tempRVO.getRegistrationDay());
            carList[i][4] = String.valueOf(tempRVO.getCarYear());
            carList[i][5] = String.valueOf(tempRVO.getDriveDistance());

        }
        return carList;
    }

}// class

