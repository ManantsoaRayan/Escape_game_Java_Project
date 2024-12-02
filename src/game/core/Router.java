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
    // Arrêter le timer de la salle actuelle
    Room currentRoom = getCurrentRoom();

    // Afficher la nouvelle salle
    System.out.println("Changement vers : " + panelId);
    Game.card.showComponent(panelId);

    // Vérifie le composant actif après changement
    Component newComponent = Game.card.getCardPanel().getComponent(0);
    System.out.println("Nouveau composant actif : " + newComponent.getClass().getSimpleName());

    // Démarrer le timer si la nouvelle salle est un GameRoom
    if (newComponent instanceof GameRoom gameRoom) {
      if (gameRoom.isGameRoom()) {
        gameRoom.startTimer();
      }
    }
  }


  public static Room getCurrentRoom() {
    for (Component comp : Game.card.getCardPanel().getComponents()) {
      if (comp.isVisible() && comp instanceof Room room) {
        return room;
      }
    }
    return null;
  }


}
