package game.core.card;

import javax.swing.*;

public class Card extends java.awt.CardLayout{
  
  private final JPanel cardPanel;
  
  public Card() {
    this.cardPanel = new JPanel(this);
  }
  
  public void add(JPanel panel, String id) {
    this.cardPanel.add(panel, id);
  }
  
  public void showComponent(String id) {
    this.show(this.cardPanel, id);
  }
  
  public JPanel getCardPanel() {
    return cardPanel;
  }
  
}
