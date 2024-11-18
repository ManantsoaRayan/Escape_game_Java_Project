package item;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Item extends JPanel {
    private String name;
    private int value;
    private JLabel label = new JLabel();
    private ImageIcon image;

    public Item(String name, int value, int x, int y, int height, int width) {
        this.name = name;
        this.value = value;

        // image temporaire pour tester l'item 
        ImageIcon originalImage = new ImageIcon("Escape_game_Java_Project\\src\\item\\pile-de-livres.png");

        // on réduit la taille de l'image
        Image scaledImage = originalImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(scaledImage);

        // initialisation d'un panel pour mettre l'image
        this.setBackground(Color.GREEN);
        this.setBounds(x, y, height, width);

        // on met l'image dans le label
        label.setIcon(this.image);

        // on met le label dans le panel
        this.add(label);
    }

    public void showDetails() {
        label.setText("Nom item : " + this.name + ", Valeur : " + this.value);
    }

    public void hideDetails() {
        label.setText("");
    }
}
