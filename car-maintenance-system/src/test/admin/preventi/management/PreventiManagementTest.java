package test.admin.preventi.management;

import org.junit.jupiter.api.Test;
import kr.co.sist.admin.preventi.management.PreventiManagementView;

class PreventiManagementTest {
    @Test
    void test() {
        PreventiManagementView preventiManagementView = new PreventiManagementView();
        preventiManagementView.setVisible(true);

        while (preventiManagementView.isVisible()) {

        }
    }
}
