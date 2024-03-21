package kr.co.sist.admin.manage.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InventoryEvent extends WindowAdapter implements ActionListener {

  private InventoryView inventoryView;
  private InventoryAddPanelView inventoryAddPanelView;

  public InventoryEvent(InventoryView inventoryView) {
    this.inventoryView = inventoryView;
    // this.inventoryAddPanelView = inventoryAddPanelView;
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == inventoryView.getJbtnAdd()) {
      new InventoryAddPanelView();
    }
  }

  @Override
  public void windowClosing(WindowEvent e) {
    inventoryView.dispose();
  }



}
