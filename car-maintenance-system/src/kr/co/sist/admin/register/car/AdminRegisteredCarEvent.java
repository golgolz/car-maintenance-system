package kr.co.sist.admin.register.car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminRegisteredCarEvent extends WindowAdapter implements ActionListener {

    private AdminRegisteredCarView arcv;

    public AdminRegisteredCarEvent(AdminRegisteredCarView arcv) {
        this.arcv = arcv;
    }// AdminRegisteredCarEvent


    @Override
    public void windowClosing(WindowEvent e) {
        arcv.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent ae) {

    }



}
