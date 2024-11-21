package game.core;

import game.core.card.Card;

import javax.swing.JFrame;

public class Game extends JFrame{
  
  public static Card card;
  
  public Game() {
    super();
    setTitle("Escape Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1556, 800);
    setLocationRelativeTo(null);
    setResizable(false);
    
    card = new Card();
    Router.initializeRoutes();
    setVisible(true);
  }
  
  public static void main(String[] args) {
    new Game().add(Game.card.getCardPanel());
    Router.route("GamePanel");
  }
  
}
