package game.items.components;

import game.items.InteractiveItem;
import game.room.Room;
import game.ui.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Hint extends InteractiveItem {
  
  // Doors popup Window
  private JFrame popupWindow;
  
  public Hint(String imagePath, String content) {
    super(imagePath, "A little enigma");
    // custom adapter with this item
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        
        // note: don't forget to make popupWindow null once it is close
        
        if (popupWindow == null) {
          showPopupWindow();
        }
      }
      
      private void showPopupWindow() {

        // set the popup window
        popupWindow = new JFrame("ENIGMA");
        
        popupWindow.setAlwaysOnTop(true);
        popupWindow.setLayout(null); // avoid using default layout system
        
        // get the parent window
        JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(getSelf());
        popupWindow.setLocationRelativeTo(ancestor);
        
        // get the current room
        Room currentRoom = (Room) getSelf().getParent();
        
        // setup width and height
        int width = ancestor.getWidth() / 2, height = ancestor.getHeight() / 2;
        
        // place the popup in the middle of our game window
        popupWindow.setBounds(width - 100, height - 100, width, height);
        
        // panel that take the elements
        JPanel contentPanel = new JPanel(null);
        contentPanel.setBackground(Color.DARK_GRAY);
        
        JLabel enigma = new JLabel(content);
        enigma.setFont(new Font("Monospaced", Font.BOLD, 22)); // uniform spacement
        enigma.setForeground(Color.WHITE);
        
        // put the text on the center
        enigma.setHorizontalAlignment(JLabel.CENTER);
        enigma.setBounds((width) / 2 - 350, height / 2 - 250, 800, 400);
        contentPanel.add(enigma);
        
        
        // cancel button
        Button close = new Button("Close");
        
        close.listen($ -> closePopup());
        
        // styling close button
        close.setSize(100, 40);
        close.setBackground(Color.LIGHT_GRAY);
        close.setLocation(width - 110, height - 100);
        contentPanel.add(close);
        
        popupWindow.setContentPane(contentPanel);
        popupWindow.setVisible(true);
      }
    });
    
    
  }
    private void closePopup() {
      this.popupWindow.dispose();
      this.popupWindow = null;
    }
  // just a method to use inside a closure to always get  the object
  protected Hint getSelf() {
    return this;
  }
}