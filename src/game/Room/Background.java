package game.Room;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Background extends JPanel {
    private Image image;
    public Background(String image_path){
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource(image_path))).getImage();
        if (image == null){
            System.out.println("chemin incorrect");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null){
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
        }
    }
}