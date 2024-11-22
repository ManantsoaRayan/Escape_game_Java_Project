package game.core;

import game.room.*;

public abstract class Router {
  
  
  public static void initializeRoutes() {
    Game.card.add(new GamePanel(), "GamePanel");
    Game.card.add(new Room1(), "room1");
    Game.card.add(new Room2(), "room2");
    Game.card.add(new Room3(),"room3" );
    Game.card.add(new GameOver(), "game over");
  }
  
  public static void route(String panelId) {
    Game.card.showComponent(panelId);
  }
  
}
