package game.Room;

import javax.swing.*;

public abstract class abstract_room extends JFrame {
    private JPanel image_path;
    public abstract_room(String Title,String path_image){
        setTitle(Title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024,700);
        try {
            image_path = new Background(path_image);
            setContentPane(image_path);
            setLocationRelativeTo(null);
            setResizable(false);
        } catch (Exception e) {
            throw new RuntimeException("erreur lors de la creation de l'image");
        }
    }
    public abstract void Init_Room();
}