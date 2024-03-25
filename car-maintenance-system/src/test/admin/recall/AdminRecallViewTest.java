package test.admin.recall;

import org.junit.jupiter.api.Test;
import kr.co.sist.admin.recall.AdminRecallView;

class AdminRecallViewTest {
    @Test
    void test() {
        AdminRecallView adminRecallView = new AdminRecallView();
        adminRecallView.setVisible(true);

        while (adminRecallView.isVisible()) {

        }
    }
}
