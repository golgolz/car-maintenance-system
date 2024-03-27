package test.login;

import org.junit.jupiter.api.Test;
import kr.co.sist.user.UserView;

class LoginTest {

  @Test
  void testLogin() {
    UserView login = new UserView();
    login.setVisible(true);

    while (login.isVisible()) {
    }
  }

}
