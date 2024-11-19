package game.items;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.Objects;

public abstract class Item extends JLabel {
  protected ImageIcon image;
  protected String description;
  
  public Item(String imageName, String description) {
    this.description = description;
    this.image = new ImageIcon(
      Objects.requireNonNull(getClass().getResource("/items/" + imageName))
    );
    setIcon(this.image);
  }
  
  public void place(int x, int y) {
    super.setBounds(x, y, this.image.getIconWidth(), this.image.getIconHeight());
  }
  
  public int getImageWidth() {
    return this.image.getIconWidth();
  }
  
  public int getImageHeight() {
    return this.image.getIconHeight();
  }
  
  public String getDescription() {
    return this.description;
  }
}
