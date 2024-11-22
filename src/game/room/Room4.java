package game.room;

import game.items.Item;
import game.items.components.Door;
import game.items.components.Hint;
import game.items.components.Joker;

public class Room4 extends Room{
  public Room4() {
    super(4, "liar", "room4.png");
    this.isLast = true;
  }
  
  @Override
  protected void setup() {
    String newsPaperContent = "<html>I have 2 feet, 6 legs, 8 arms,<br> 2 heads and an eye,<br> who am I?</html>";
    
    Door door = new Door("door4.png");
    Joker dinnyTable = new Joker("dining table.png", "");
    Hint newsPaper = new Hint("newspaper.png", newsPaperContent);
    Joker plant = new Joker("plant.png", "");
    
    door.place(getWidth() / 2 - door.getImageWidth() + 30, getHeight() - door.getImageHeight() - 230);
    dinnyTable.place(getWidth() / 2 - dinnyTable.getImageWidth() + 600, getHeight() - dinnyTable.getImageHeight() - 100);
    newsPaper.place(getWidth() / 2 - dinnyTable.getImageWidth() + 700, getHeight() - dinnyTable.getImageHeight() - 200);
    plant.place(getWidth() / 2 - door.getImageWidth() - 500, getHeight() - door.getImageHeight() - 100);
    
    Item[] items = {door, newsPaper,dinnyTable, plant};
    
    addItems(items);
  
  }
}
