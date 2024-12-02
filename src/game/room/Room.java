package game.room;

import game.core.Router;
import game.items.Item;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public abstract class Room extends JPanel implements GameRoom{
  private static final int DEFAULT_START_TIME = 18;

  protected int number;
  protected int attempts;
  protected boolean isLast;
  protected String password;
  protected ArrayList<Item> items;
  protected Image background;

  protected JLabel timerLabel;
  protected Timer gameTimer;
  protected int remainingTime;
  protected boolean isGameRoom; // pour différencier les chambres

  private static boolean gameOverShown = false;

  public Room(int number, String password, String fileName, boolean isGameRoom){
    super();
    this.number = number;
    this.attempts = 3;
    this.isLast = false;
    this.password = password;
    this.items = new ArrayList<>();
    setSize(1556, 800);
    setLayout(null);
    
    try {
      this.background = ImageIO.read(
        Objects.requireNonNull(getClass().getResource("/backgrounds/" + fileName))
      );
    } catch (IOException e) {
      this.background = null;
    }
    
    setup();
    applyItems();

    this.isGameRoom = isGameRoom;

    if (isGameRoom) {
      initializeTimer();
    }

  }

  public static void resetGameOverFlag() {
    gameOverShown = false;
  }

  public void resetTimer() {
    System.out.println("Réinitialisation du Timer à " + DEFAULT_START_TIME);
    remainingTime = DEFAULT_START_TIME;
    updateTimerLabel();

    // Stopper et recréer le Timer
    if (gameTimer != null) {
      gameTimer.stop();
    }
    gameTimer = new Timer(1000, e -> updateTimer());
  }


  protected void initializeTimer() {
    remainingTime = 300;

    timerLabel = new JLabel("5:00", SwingConstants.CENTER);
    timerLabel.setFont(new Font("Arial", Font.BOLD, 24));
    timerLabel.setForeground(Color.BLUE);
    timerLabel.setBounds(20, 20, 100, 50);
    add(timerLabel);

    gameTimer = new Timer(1000, e -> updateTimer());
    gameTimer.start();
  }

  @Override
  public void startTimer() {
    if (isGameRoom) {
      System.out.println("Démarrage du Timer avec " + remainingTime + " secondes restantes");
      if (gameTimer != null) {
        System.out.println("Timer existant, démarrage...");
        gameTimer.start();
      } else {
        System.out.println("Timer inexistant, création nécessaire !");
      }
    } else {
      System.out.println("La salle actuelle n'est pas un GameRoom.");
    }
  }

  private void updateTimer() {
    remainingTime--;
    updateTimerLabel();
    System.out.println("it work");

    if (remainingTime <= 0) {
      gameTimer.stop();
      showGameOverPopup();
    }
  }

  private void updateTimerLabel() {
    int minutes = remainingTime / 60;
    int seconds = remainingTime % 60;
    timerLabel.setText(String.format("%d:%02d", minutes, seconds));
  }

  protected void showGameOverPopup() {
    if (!gameOverShown) {
      gameOverShown = true;
      JOptionPane.showMessageDialog(
              this,
              "Game Over! Time has run out.",
              "Time's Up",
              JOptionPane.INFORMATION_MESSAGE
      );
      Router.route("game over");
    }
  }

  @Override
  public void stopTimer() {
    if (gameTimer != null) {
      gameTimer.stop();
    }
  }

  @Override
  public boolean isGameRoom() {
    return isGameRoom;
  }
  
  protected abstract void setup();
  
  public int getAttempts() {
    return attempts;
  }
  
  public int getNumber() {
    return number;
  }
  
  public void decrementAttempts() {
    this.attempts--;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public Boolean isLast() {
    return this.isLast;
  }
  
  public void next(String identifier) {
    Router.route(identifier);
  }
  
  protected void addItems(Item item) {
    this.items.add(item);
  }
  
  protected void addItems(Item[] itemList) {
      Collections.addAll(this.items, itemList);
  }
  
  
  protected void applyItems() {
    for (Item item: this.items) {
      this.add(item);
    }
  }

  protected Room getSelf() {
    return this;
  }
  
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
  }
}
