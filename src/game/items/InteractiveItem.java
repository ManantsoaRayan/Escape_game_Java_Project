//package game.items;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public abstract class InteractiveItem extends Item{
//
//  private JWindow window;
//
//  public InteractiveItem(String imagePath, String description) {
//    super(imagePath, description);
//    addInteraction();
//    setCursor(new Cursor(Cursor.HAND_CURSOR));
//  }
//
//  public void addInteraction() {
//    this.addMouseListener(new MouseAdapter() {
//      @Override
//      public void mouseEntered(MouseEvent e) {
//        window = new JWindow();
//
//        JLabel label = new JLabel(getDescription());
//
//        JFrame ancestor =(JFrame) SwingUtilities.getWindowAncestor(get());
//        window.setBackground(Color.DARK_GRAY);
//        window.setLocationRelativeTo(get());
//        window.setSize(Math.max(getDescription().length(), 150), 20);
////        window.setLocation(ancestor.getWidth() / 2, ancestor.getWidth() / 2);
//        window.setLocation(getX() + ancestor.getX(), getY() + ancestor.getY());
//        window.setAlwaysOnTop(true);
//        label.setBounds(0, 10, Math.max(getDescription().length(), 150), 20);
//        window.add(label);
//        window.setVisible(true);
//      }
//
//      @Override
//      public void mouseExited(MouseEvent e) {
//        window.dispose();
//      }
//    });
//  }
//
//  public InteractiveItem get() {
//    return this;
//  }
//}

package game.items;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InteractiveItem extends Item {
  
  private JWindow popupWindow;
  
  public InteractiveItem(String imageName, String description) {
    super(imageName, description);
    addInteraction();
    setCursor(new Cursor(Cursor.HAND_CURSOR)); // Indicates that the item is interactive
  }
  
  private void addInteraction() {
    this.addMouseListener(new MouseAdapter() {
      
      @Override
      public void mouseEntered(MouseEvent e) {
        showPopup(e.getXOnScreen(), e.getYOnScreen());
      }
      
      @Override
      public void mouseExited(MouseEvent e) {
        hidePopup();
      }
    });
  }
  
  private void showPopup(int mouseX, int mouseY) {
    popupWindow = new JWindow();
    popupWindow.setLayout(new BorderLayout());
    popupWindow.setAlwaysOnTop(true);
    
    // Reduce the image proportionally for the popup
    int scaledWidth = Math.min(image.getIconWidth(), 100);
    // keep the aspect ratio
    int scaledHeight = (int) (image.getIconHeight() * ((double) scaledWidth / image.getIconWidth()));
    ImageIcon scaledImage = new ImageIcon(
      image.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH)
    );
    JLabel imageLabel = new JLabel(scaledImage);
    
    // Description with handling of long strings
    JLabel descriptionLabel = new JLabel("<html>" + this.getDescription() + "</html>");
    descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
    descriptionLabel.setForeground(Color.WHITE);
    
    // Main panel for image and description
    JPanel contentPanel = new JPanel(new BorderLayout());
    contentPanel.setBackground(Color.DARK_GRAY);
    contentPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
    contentPanel.add(imageLabel, BorderLayout.NORTH);
    contentPanel.add(descriptionLabel, BorderLayout.CENTER);
    
    popupWindow.add(contentPanel);
    
    // Calculate the size of the popup based on the description and image
    int width = Math.max(scaledWidth + 20, descriptionLabel.getPreferredSize().width + 20);
    int height = scaledHeight + descriptionLabel.getPreferredSize().height + 20;
    popupWindow.setSize(width, height);
    
    // Position the popup near the mouse
    popupWindow.setLocation(mouseX + 10, mouseY + 10);
    popupWindow.setVisible(true);
  }
  
  private void hidePopup() {
    if (popupWindow != null) {
      popupWindow.dispose();
      popupWindow = null;
    }
  }
}

