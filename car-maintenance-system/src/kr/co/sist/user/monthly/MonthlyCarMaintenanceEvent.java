package kr.co.sist.user.monthly;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MonthlyCarMaintenanceEvent {


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

      JTextArea jta = new JTextArea(output.toString(), 10, 80);
      JScrollPane jsp = new JScrollPane(jta);
      JOptionPane.showMessageDialog(null, jsp);
    } catch (SQLException e) {
      e.printStackTrace();
    } // end catch

  }// searchAllEmp
}
