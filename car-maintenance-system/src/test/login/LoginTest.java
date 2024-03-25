package test.login;

import org.junit.jupiter.api.Test;
import kr.co.sist.admin.manage.user.ManageUserInfoView;

class LoginTest {

  @Test
  void testLogin() {
    ManageUserInfoView login = new ManageUserInfoView();
    login.setVisible(true);

    while (login.isVisible()) {
    }
  }

}
