package test.admin.preventi.policy;

import org.junit.jupiter.api.Test;
import kr.co.sist.admin.preventi.policy.PreventiPolicyDialog;

class PreventiPolicyTest {
  @Test
  void testPolicy() {
    PreventiPolicyDialog policy = new PreventiPolicyDialog();
    policy.setVisible(true);

    while (policy.isVisible()) {
    }
  }
}
