package game.core;

import game.room.*;

public abstract class Router {
  
  public static Room currentRoom;
  
  public static void initializeRoutes() {
    Game.card.add(new GamePanel(), "GamePanel");
    Game.card.add(new Room1(), "room1");
    Game.card.add(new Room2(), "room2");
  }
  
  public static void route(String panelId) {
    Game.card.showComponent(panelId);
  }
  
}
