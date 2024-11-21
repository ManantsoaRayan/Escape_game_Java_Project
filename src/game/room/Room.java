package game.room;

import game.core.Router;
import game.items.Item;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Room extends JPanel {
  protected int number;
  protected int attempts;
  protected boolean isLast;
  protected String password;
  protected ArrayList<Item> items;
  protected Image background;
  
  public Room(int number, String password, String fileName){
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
  }
  
  protected abstract void setup();
  
  public int getAttempts() {
    return attempts;
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
  
  protected void next(String identifier) {
    Router.route(identifier);
  }
  
  protected void addItems(Item item) {
    this.items.add(item);
  }
  
  protected void addItems(Item[] itemList) {
    for (Item item : itemList) {
      this.items.add(item);
    }
  }
  
  
  protected void applyItems() {
    for (Item item: this.items) {
      this.add(item);
    }
  }
  
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
  }
}
