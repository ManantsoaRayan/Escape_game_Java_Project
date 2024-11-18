package game.Main;

import javax.swing.*;
import java.awt.*;
import game.Room.Background;
import game.Room.Room1;
public class Main extends JFrame {
    protected JPanel image_back;

    public Main() {
        // Configuration de base de la fenêtre
        setTitle("Escape Game");
        setSize(1024, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            // Chargement de l'image d'arrière-plan
            image_back = new Background("/images/main.jpeg");
            image_back.setLayout(new BorderLayout());
            setContentPane(image_back);

            // Création des composants
            addComponentsToPane();

            setLocationRelativeTo(null); // Centre la fenêtre
            setResizable(false);
            setVisible(true);
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement de l'image");
        }
    }

    private void addComponentsToPane() {
        JLabel title = new JLabel("Bienvenue à l'Escape Game !");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(Color.BLACK);
        title.setBounds(320,90,400,150);

        // Description
        JLabel description = new JLabel("Chaque objet a un secret,chaque détail peut être une clé.Ouvrez l'œil !");
        description.setFont(new Font("Arial", Font.PLAIN, 19));
        description.setForeground(Color.DARK_GRAY);
        description.setBounds(200,120,700,200);

        // Bouton
        JButton start_Button = new JButton("COMMENCER");
        start_Button.setFont(new Font("Arial", Font.BOLD, 16));
        start_Button.setBackground(Color.WHITE);
        start_Button.setBounds(400,270,250,70);
        start_Button.addActionListener(e -> open_Room1());

        //bouton quit
        JButton quit_Boutton = new JButton("QUITTER");
        quit_Boutton.setFont(new Font("Arial", Font.BOLD,16));
        quit_Boutton.setBackground(Color.WHITE);
        quit_Boutton.setBounds(400,360,250,70);
        quit_Boutton.addActionListener(e -> {JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(quit_Boutton);
        if (frame != null){
            frame.dispose();
        }}
        );

        this.setLayout(null);
        this.add(title);
        this.add(description);
        this.add(start_Button);
        this.add(quit_Boutton);

    }
    public void open_Room1(){
        Room1 room1 = new Room1();
        room1.Init_Room(); // Important pour ajouter la porte
        room1.setVisible(true);
        this.dispose();    // Ferme le menu principal
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
