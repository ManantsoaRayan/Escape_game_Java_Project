package game.core;

import game.room.*;

import java.awt.Component;

public abstract class Router {
  
  
  public static void initializeRoutes() {
    Game.card.add(new GamePanel(), "GamePanel");
    Game.card.add(new Room1(), "room1");
    Game.card.add(new Room2(), "room2");
    Game.card.add(new Room3(), "room3");
    Game.card.add(new Room4(), "room4");
    Game.card.add(new GameOver(), "game over");
  }
  
  public static void route(String panelId) {

    // Récupérer la chambre courante
    Component currentComponent = Game.card.getCardPanel().getComponent(0);

    // Arrêter le timer si la chambre courante est une GameRoom
    if (currentComponent instanceof GameRoom gameRoom) {
      if (gameRoom.isGameRoom()) {
        gameRoom.stopTimer();
      }
    }

    // Afficher la nouvelle chambre
    Game.card.showComponent(panelId);

    // Récupérer la nouvelle chambre
    Component newComponent = Game.card.getCardPanel().getComponent(0);

    // Démarrer le timer si la nouvelle chambre est une GameRoom
    if (newComponent instanceof GameRoom gameRoom) {
      if (gameRoom.isGameRoom()) {
        gameRoom.startTimer();
      }
    }
  }
  
}
