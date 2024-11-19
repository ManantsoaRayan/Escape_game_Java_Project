package game.core;

import game.room.Room;
import game.ui.Button;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends Room {
  public GamePanel(){
    super(0, "/backgrounds/main.jpeg");
    setSize(1556, 800);
    setLayout(null);
    setup();
  }
  
  @Override
  public void setup(){
    // init
    Button start = new Button("Start");
    Button quit = new Button("QUIT", e -> System.exit(1));
    JLabel label = new JLabel("Jeu d'evasion");
    
    // setup
    quit.setFont(new Font("Arial", Font.BOLD, 40));
    start.setFont(new Font("Arial", Font.BOLD, 40));
    quit.setBackground(Color.WHITE);
    start.setBackground(Color.WHITE);
    
    label.setFont(new Font("Arial", Font.BOLD, 40));
    
    // action
    start.listen(e -> {
      Router.route("room1");
    });
    
    // placement
    start.setBounds(660, 298, 278 ,61);
    quit.setBounds(660, 401, 278 ,61);
    label.setBounds(660, 175, 285, 63);
    
    add(start);
    add(quit);
    add(label);
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
  }
}
