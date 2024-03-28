package test.login;

import org.junit.jupiter.api.Test;
import kr.co.sist.user.register.user.RegisterUserView;

class LoginTest {

  @Test
  void testLogin() {
    RegisterUserView login = new RegisterUserView();
    login.setVisible(true);

    while (login.isVisible()) {
    }
  }

}
