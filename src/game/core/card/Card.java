package game.core.card;

import javax.swing.JPanel;

public class Card extends java.awt.CardLayout{
  
  private final JPanel cardPanel;
  
  public Card() {
    this.cardPanel = new JPanel(this);
  }
  
  public void add(JPanel panel, String identifier) {
    this.cardPanel.add(panel, identifier);
  }
  
  public void showComponent(String identifier) {
    this.show(this.cardPanel, identifier);
  }
  
  public JPanel getCardPanel() {
    return cardPanel;
  }
  
}
