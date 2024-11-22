package game.core;

import game.room.Room;
import game.ui.Button;

import javax.swing.*;
import java.awt.*;


public class GameOver extends Room {
  
  public GameOver() {
    super(-1,"", "game over2.jpg");
  }
  
  @Override
  protected void setup() {
    // init
    Button restart = new Button("Restart");
    Button quit = new Button("QUIT", e -> System.exit(1));
    JLabel label = new JLabel("THANKS FOR PLAYING");
    
    // setup
    quit.setFont(new Font("Monospace", Font.BOLD, 40));
    restart.setFont(new Font("Monospace", Font.BOLD, 40));
    quit.setBackground(Color.WHITE);
    restart.setBackground(Color.WHITE);
    
    label.setFont(new Font("Monospace", Font.BOLD, 70));
    label.setForeground(Color.WHITE);
    
    // action
    restart.listen($ -> this.next("room1"));
    
    // placement
    restart.setBounds(500, getHeight() - 200, 278 ,61);
    quit.setBounds(500 + 300, getHeight() - 200, 278 ,61);
    label.setBounds(getWidth() / 2 - 300, 100, 800, 63);
    
    add(restart);
    add(quit);
    add(label);
  
  }
}
