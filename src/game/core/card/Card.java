package game.core.card;

import javax.swing.JPanel;

// class that can handle multiple panel
public class Card extends java.awt.CardLayout{
  
  private final JPanel cardPanel;
  
  public Card() {
    this.cardPanel = new JPanel(this);
  }
  
  // associate a panel with a identifier
  public void add(JPanel panel, String identifier) {
    this.cardPanel.add(panel, identifier);
  }
  
  // to switch over panels
  public void showComponent(String identifier) {
    this.show(this.cardPanel, identifier);
  }
  
  // to get the current panel
  public JPanel getCardPanel() {
    return cardPanel;
  }
  
}
