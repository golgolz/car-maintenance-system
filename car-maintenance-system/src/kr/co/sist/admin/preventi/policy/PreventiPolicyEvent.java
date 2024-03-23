package kr.co.sist.admin.preventi.policy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreventiPolicyEvent implements ActionListener {
    private PreventiPolicyDialog preventiPolicyDialog;

    public PreventiPolicyEvent(PreventiPolicyDialog preventiPolicyDialog) {
        this.preventiPolicyDialog = preventiPolicyDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        preventiPolicyDialog.dispose();
    }
}

