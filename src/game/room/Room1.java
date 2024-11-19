package game.room;

import game.items.Item;
import game.items.components.*;
import game.ui.Button;

import java.awt.*;
import java.awt.event.ItemListener;

public class Room1 extends Room{
  
  public Room1(){
    super(1, "/backgrounds/room1.jpg");
  }
  
  @Override
  protected void setup() {
    Table table = new Table("table.png", "");
    CircleFrame circleFrame = new CircleFrame("13.png", "Circle with 13 inside");
    Door door = new Door("Door.png", "Door");
    Lamp lamp = new Lamp("lamp.png", "Une lampe");
    InteractiveJoker hint = new InteractiveJoker("indice5.png", "Photo avec un 5 dessus");
    InteractiveJoker clock = new InteractiveJoker("Rectangle 1.png", "Une montre qui est a 18h");
    
    
    
    Item[] itemList = {
      table, circleFrame, door, lamp, hint, clock
    };
    
    
    table.place(0, 400);
    circleFrame.place(300, 300);
    door.place(getWidth() - door.getImageWidth(), getHeight() - door.getImageHeight() - 200);
    lamp.place(getWidth() / 2, 0);
    hint.place(20, 200);
    clock.place((getWidth() / 2) + 100, 100);
    
    addItems(itemList);
    applyItems();
  }
}
