package game.room;

import game.ui.Button;

public class Room2 extends Room{
  
  
  public Room2(){
    super(2, "/backgrounds/room1.jpg");
  }
  
  @Override
  protected void setup() {
    Button greetings = new Button("YOU LOVE ME TOO");
    greetings.listen(e -> this.next("room1"));
    
    greetings.setBounds(getWidth() / 2, getHeight() / 2, 300, 50);
    add(greetings);
  }
}
