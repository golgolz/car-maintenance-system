package test.user.recall;

import org.junit.jupiter.api.Test;
import kr.co.sist.user.recall.UserRecallView;

class UserRecallViewTest {
    @Test
    void test() {
        UserRecallView userRecallView = new UserRecallView();
        userRecallView.setVisible(true);

        while (userRecallView.isVisible()) {

        }
    }
}
