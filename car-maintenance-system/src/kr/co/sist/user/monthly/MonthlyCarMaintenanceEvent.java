package kr.co.sist.user.monthly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MonthlyCarMaintenanceEvent extends MouseAdapter implements ActionListener {

    private MonthlyCarMaintenanceView monthlyCarMaintenanceView;

    public MonthlyCarMaintenanceEvent(MonthlyCarMaintenanceView monthlyCarMaintenanceView) {
        this.monthlyCarMaintenanceView = monthlyCarMaintenanceView;
        // JComboBox 초기화 후 ActionListener 추가
        monthlyCarMaintenanceView.getJcbMonthlyMaintenanceList().addActionListener(this);
        // 세부조회 버튼
        monthlyCarMaintenanceView.getJbtnDetailedSelect().addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        //////////////////////
        if (e.getSource() == monthlyCarMaintenanceView.getJcbMonthlyMaintenanceList()) {
            // JComboBox에서 선택된 값에 따라 데이터를 업데이트
            updateTableData();
        } else if (e.getSource() == monthlyCarMaintenanceView.getJbtnDetailedSelect()) {
            // 버튼을 클릭하여 세부 정보를 조회하는 로직 추가
            showDetailedData();
        } else if (e.getSource() == monthlyCarMaintenanceView.getJbtnSelect()) {
            // jbtnSelect 버튼을 클릭하여 데이터를 출력하는 로직 추가
            searchMaintenanceData();
        }
    }

    private void searchMaintenanceData() {
        // DBMS에서 조회된 결과를 받아서 사용자에게 보여준다.
        MonthlyCarMaintenanceDAO mcmDAO = MonthlyCarMaintenanceDAO.getInstance();
        try {
            List<MonthlyCarMaintenanceVO> listAllInfo = mcmDAO.selectAllData();
            DefaultTableModel model =
                    (DefaultTableModel) monthlyCarMaintenanceView.getJtabMonthlyCarMaintenanceData().getModel();
            model.setRowCount(0); // 테이블 초기화
            if (listAllInfo.isEmpty()) {
                // System.out.println("데이터가 없습니다");
            } else {
                for (MonthlyCarMaintenanceVO mcmVO : listAllInfo) {
                    Object[] row = {mcmVO.getOwnerName(), mcmVO.getMaintenanceDate()};
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void updateTableData() {
        // DBMS에서 조회된 결과를 받아서 JComboBox에 데이터를 설정한다.
        MonthlyCarMaintenanceDAO mcmDAO = MonthlyCarMaintenanceDAO.getInstance();
        String selectedItem = monthlyCarMaintenanceView.getJcbMonthlyMaintenanceList().getSelectedItem().toString();

        try {
            // 선택된 항목을 기반으로 데이터 가져오기
            List<MonthlyCarMaintenanceVO> maintenanceData = mcmDAO.getMaintenanceData(selectedItem);
            // System.out.println("Maintenance data size: " + maintenanceData.size()); // 가져온 데이터 크기 출력
            // 가져온 데이터를 테이블에 표시
            DefaultTableModel model =
                    (DefaultTableModel) monthlyCarMaintenanceView.getJtabMonthlyCarMaintenanceData().getModel();
            model.setRowCount(0); // 테이블 초기화

            for (MonthlyCarMaintenanceVO mcmVO : maintenanceData) {
                // 행이 추가될 때 데이터 값을 확인하는 디버깅 코드
                // System.out.println("Adding row: OwnerName=" + mcmVO.getOwnerName() + ", MaintenanceDate="
                // + mcmVO.getMaintenanceDate2());
                // 테이블에 각 행 추가
                Object[] row = {mcmVO.getOwnerName(), mcmVO.getMaintenanceDate2()};
                model.addRow(row);
            }
        } catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == monthlyCarMaintenanceView.getJtabMonthlyCarMaintenanceData()) {
            int selectedRow = monthlyCarMaintenanceView.getJtabMonthlyCarMaintenanceData().getSelectedRow();
            if (selectedRow != -1) {
                String ownerName = (String) monthlyCarMaintenanceView.getJtabMonthlyCarMaintenanceData()
                        .getValueAt(selectedRow, 0);
                String maintenanceDate = (String) monthlyCarMaintenanceView.getJtabMonthlyCarMaintenanceData()
                        .getValueAt(selectedRow, 1);

                // 디버깅 코드
                // System.out.println(
                // "Selected Row Data - Owner Name: " + ownerName + ", Maintenance Date: " + maintenanceDate);

                // 마우스 클릭으로 선택된 행의 데이터를 버튼에 저장
                monthlyCarMaintenanceView.getJbtnDetailedSelect().putClientProperty("ownerName", ownerName);
                monthlyCarMaintenanceView.getJbtnDetailedSelect().putClientProperty("maintenanceDate", maintenanceDate);
            }
        }
    }

    private void showDetailedData() {

        // 버튼에 저장된 데이터 가져오기
        String ownerName = (String) monthlyCarMaintenanceView.getJbtnDetailedSelect().getClientProperty("ownerName");
        String maintenanceDate =
                (String) monthlyCarMaintenanceView.getJbtnDetailedSelect().getClientProperty("maintenanceDate");

        // MonthlyCarMaintenanceDAO 객체 생성
        MonthlyCarMaintenanceDAO mcmDAO = MonthlyCarMaintenanceDAO.getInstance();

        try {
            // 세부 정보 조회
            List<MonthlyCarMaintenanceVO> detailedData = mcmDAO.getDetailedData(ownerName, maintenanceDate);

            // DefaultTableModel 객체 생성
            DefaultTableModel model =
                    (DefaultTableModel) monthlyCarMaintenanceView.getJtDetailedCarMaintenanceData().getModel();
            model.setRowCount(0); // 테이블 초기화

            // 조회한 세부 정보를 테이블에 추가
            for (MonthlyCarMaintenanceVO vo : detailedData) {
                Object[] row = {vo.getPartName(), vo.getPartPrice(), vo.getPartCnt(), vo.getTotalPrice()};
                model.addRow(row);

                // 디버깅 코드 추가: 테이블 사이즈 확인
                // System.out.println("Table size after adding row: " + model.getRowCount());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
