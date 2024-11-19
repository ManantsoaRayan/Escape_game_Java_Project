package game.room;

import game.core.Router;
import game.items.Item;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Room extends JPanel {
  protected int number;
  protected int attempts;
  protected ArrayList<Item> items;
  protected Image background;
  
  public Room(int number, String path){
    super();
    this.number = number;
    this.attempts = 3;
    this.items = new ArrayList<>();
    setSize(1556, 800);
    setLayout(null);
    
    try {
      this.background = ImageIO.read(
        Objects.requireNonNull(getClass().getResource(path))
      );
    } catch (IOException e) {
      this.background = null;
    }
    
    setup();
  }
  
  protected abstract void setup();
  
  protected void next(String id) {
    Router.route(id);
  }
  
  protected void addItems(Item item) {
    this.items.add(item);
  }
  
  protected void addItems(Item[] itemList) {
    for (int i = 0; i < itemList.length; i++) {
      this.items.add(itemList[i]);
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
