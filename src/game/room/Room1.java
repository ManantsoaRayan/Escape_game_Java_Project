package game.room;

import game.items.Item;
import game.items.components.*;


public class Room1 extends Room{
  
  public Room1(){
    super(1, "merde", "room1.jpg", true);
  }
  
  @Override
  protected void setup() {
    // initialize the items
    Table table = new Table("table.png", "");
    CircleFrame circleFrame = new CircleFrame("13.png", "Circle with 13 inside");
    Door door = new Door("Door.png");
    Lamp lamp = new Lamp("lamp.png", "Une lampe");
    InteractiveJoker hint = new InteractiveJoker("indice5.png", "Photo avec un 5 dessus");
    InteractiveJoker clock = new InteractiveJoker("Rectangle 1.png", "Une montre qui est a 18h");
    Joker picture1 = new Joker("Polygon 1.png", "");
    Joker picture2 = new Joker("Rectangle 2.png", "");
    Joker picture3 = new Joker("ellipse.png", "");
    Joker picture4 = new Joker("4.png", "");
    Joker picture5 = new Joker("Polygon 2.png", "");
    InteractiveJoker books = new InteractiveJoker("Books.png", "4 books");
    
    
    // place items here
    door.place(getWidth() - door.getImageWidth(), getHeight() - door.getImageHeight() - 200);
    picture3.place(100, 450);
    picture1.place((100 + 100 ), 450);
    picture2.place((100 + 100 + 100 ), 450);
    picture4.place((100 + 100 + 100+  100), 450);
    picture5.place((100 + 100 + 100 + 100 + 40), 450);
    table.place(0, 400);
    circleFrame.place(300, 300);
    lamp.place(getWidth() / 2, 0);
    hint.place(20, 100);
    clock.place((getWidth() / 2) + 100, 100);
    books.place(0, 300);
    
    // puts items here in order they appear in the window
    Item[] itemList = {
      picture1, picture2, picture3, picture4, picture5, table, books, circleFrame, door, lamp, hint, clock,
    };
    
    // don't forget to add the items
    addItems(itemList);
  }
}
