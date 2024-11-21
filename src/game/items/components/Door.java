package game.items.components;

import game.core.Router;
import game.items.InteractiveItem;
import game.room.Room;
import game.ui.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Door extends InteractiveItem {
  
  private JFrame popupWindow;
  
  public Door(String imagePath, String description) {
    super(imagePath, description);
    
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (popupWindow == null) {
          showPopupWindow();
        }
      }
      
      private void showPopupWindow() {

        popupWindow = new JFrame("DOOR PASSPHRASE");
        
        popupWindow.setAlwaysOnTop(true);
        popupWindow.setLayout(null);
        
        // get the parent window
        JFrame ancestor = (JFrame) SwingUtilities.getWindowAncestor(getSelf());
        popupWindow.setLocationRelativeTo(ancestor);
        
        // get the current room
        Room currentRoom = (Room) getSelf().getParent();
        
        int width = ancestor.getWidth() / 2, height = ancestor.getHeight() / 2;
        
        popupWindow.setBounds(width - 100, height - 100, width, height);
        
        // panel that take the elements
        JPanel contentPanel = new JPanel(null);
        contentPanel.setBackground(Color.DARK_GRAY);
        
        JLabel attemptsCount = new JLabel("rest of attempts: " + currentRoom.getAttempts());
        attemptsCount.setFont(new Font("Monospaced", Font.BOLD, 24)); // uniform spacement
        attemptsCount.setForeground(Color.WHITE);
        attemptsCount.setHorizontalAlignment(JTextField.CENTER);
        attemptsCount.setBounds((width - 800) / 2, height / 2 - 100, 800, 40);
        contentPanel.add(attemptsCount);
        
        //  passphrase key
        JTextField styledInput = new JTextField(5); // limited at 5 chars
        styledInput.setFont(new Font("Monospaced", Font.BOLD, 24)); // uniform
        styledInput.setHorizontalAlignment(JTextField.CENTER);
        styledInput.setBounds((width - 200) / 2, height / 2 - 20, 200, 40);
        styledInput.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        styledInput.setForeground(Color.WHITE);
        styledInput.setBackground(Color.DARK_GRAY);
        styledInput.requestFocusInWindow();
        styledInput.setFocusable(true);
        
        // Limits the input text to 5 chars
        styledInput.addKeyListener(new KeyAdapter() {
          @Override
          public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isLetter(c) || styledInput.getText().length() >= 5) {
              e.consume(); // avoid invalid inputs
            }
          }
        });
        contentPanel.add(styledInput);
        
        // cancel button
        Button close = new Button("Cancel");
        
        close.listen($ -> {
          popupWindow.dispose();
          popupWindow = null;
        });
        
        // styling close button
        close.setSize(100, 40);
        close.setBackground(Color.LIGHT_GRAY);
        close.setLocation(width - 110, height - 100);
        contentPanel.add(close);
        
        // open button
        Button open = new Button("Open");
        
        open.listen($ -> {
          // get the input value
          String inputText = styledInput.getText().toUpperCase();
          
          // check if input is empty or only space
          if (inputText.trim().isEmpty()) {
            JOptionPane.showMessageDialog(popupWindow, "must enter something");
            return;
          }
          
          // check if input text is not equals to input text
          if (!currentRoom.getPassword().toUpperCase().equals(inputText)) {
            JOptionPane.showMessageDialog(popupWindow, "Wrong Password");
            currentRoom.decrementAttempts();
            
            // check the attempts left.
            if (currentRoom.getAttempts() <= 0) {
              JOptionPane.showMessageDialog(popupWindow, "out of attempts: GAME OVER");
              Router.route("game over");
            }
            
            // kill the popup window
            popupWindow.dispose();
            popupWindow = null;
            return;
          }
          
          // route to the next room otherwise game over
          Router.route(
            (currentRoom.isLast()) ? "game over" : "room2"
          );
          
        });
        
        open.setSize(100, 40);
        open.setBackground(Color.LIGHT_GRAY);
        open.setLocation(width - (120 + 100), height - 100);
        contentPanel.add(open);
        
        popupWindow.setContentPane(contentPanel);
        popupWindow.setVisible(true);
      }
    });
  }
  
  protected Door getSelf() {
    return this;
  }
}