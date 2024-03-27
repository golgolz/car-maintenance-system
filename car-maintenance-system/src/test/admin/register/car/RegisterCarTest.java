package test.admin.register.car;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import kr.co.sist.admin.register.car.AdminRegisteredCarView;

class RegisterCarTest {
    @Test
    void testAdminRegisteredCarView() throws SQLException {
        // RegisteredCarDAO.getInstance().selectAllCar();
        AdminRegisteredCarView ARCV = new AdminRegisteredCarView();
        ARCV.setVisible(true);

        while (ARCV.isVisible()) {


        }


        // UI 구현한거 객체화
        // while(뷰.isVisible()) {} 추가해서 창 꺼지지 않게 해주기
        // 참고 코드 : test.admin.preventi.policy/PreventiPolicyTest.java
    }

}
