package game.ui;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Button extends JButton{
  public Button(String innerText, ActionListener listener) {
    super(innerText);
    this.addActionListener(listener);
  }
  
  public Button(String innerText) {
    super(innerText);
  }
  
  public void listen(ActionListener listener) {
    this.addActionListener(listener);
  }
  
}
