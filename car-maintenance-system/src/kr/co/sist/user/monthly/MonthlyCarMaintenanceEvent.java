package kr.co.sist.user.monthly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class MonthlyCarMaintenanceEvent implements ActionListener {

  private MonthlyCarMaintenanceView monthlyCarMaintenanceView;

  public MonthlyCarMaintenanceEvent(MonthlyCarMaintenanceView monthlyCarMaintenanceView) {
    this.monthlyCarMaintenanceView = monthlyCarMaintenanceView; // MonthlyCarMaintenanceView 객체 초기화
  }


  public void searchMaintenanceData() {

    // DBMS에서 조회된 결과를 받아서 사용자에게 보여준다.
    MonthlyCarMaintenanceDAO mcmDAO = MonthlyCarMaintenanceDAO.getInstance();
    try {
      List<MonthlyCarMaintenanceVO> listAllInfo = mcmDAO.selectAllData();
      StringBuilder output = new StringBuilder();
      output.append("이름\t정비일자\n");
      if (listAllInfo.isEmpty()) {
        output.append("데이터가 없습니다");
      } else {
        for (MonthlyCarMaintenanceVO mcmVO : listAllInfo) {
          output.append(mcmVO.getOwnerName()).append("\t").append(mcmVO.getMaintenanceDate()).append("\t");
        } // end for
      } // end else


    } catch (SQLException e) {
      e.printStackTrace();
    } // end catch

  }// searchAllEmp



  @Override
  public void actionPerformed(ActionEvent e) {
    // DBMS에서 조회된 결과를 받아서 JComboBox에 데이터를 설정한다.
    MonthlyCarMaintenanceDAO mcmDAO = MonthlyCarMaintenanceDAO.getInstance();
    try {
      // 모든 날짜를 조회하여 리스트에 저장한다.
      List<String> maintenanceDates = mcmDAO.getAllMaintenanceDates();

      // JComboBox에 조회된 날짜를 설정한다.
      for (String date : maintenanceDates) {
        monthlyCarMaintenanceView.getJcbMonthlyMaintenanceList().addItem(date);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }


}
