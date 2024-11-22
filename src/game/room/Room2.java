package game.room;

import game.items.Item;
import game.items.components.Door;
import game.ui.Button;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Room2 extends Room{
  
  
  public Room2(){
    super(2,"linux", "room2.jpg");
    this.isLast = true;
    this.attempts = 1;
  }
  
  @Override
  protected void setup() {
    // initialization
    Door door = new Door("Door.png");
    JLabel bigHint = new JLabel("The best OS EVER IS");
    
    bigHint.setFont(new Font("Monospaced", Font.BOLD, 30)); // uniform spacement
    bigHint.setForeground(Color.WHITE);
    bigHint.setHorizontalAlignment(JLabel.CENTER);
    // placements
    door.place(getWidth() - (int) (door.getImageHeight() * 1.2) , getHeight() - door.getImageHeight() - 100);
    bigHint.setBounds(getWidth() - 800 , getHeight() / 2 - 200, 800, 40);
    
    // sorting items
    Item[] alignements = {door};
    // important
    
    addItems(alignements);
    add(bigHint);
  }
}
