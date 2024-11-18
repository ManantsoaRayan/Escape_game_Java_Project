package Room;

import Items.*;
import Items.Montre;

public class Room1 extends abstract_room {
    public Room1() {
        super("Room 1", "/res/images/back_menu.jpg");
    }

    @Override
    public void Init_Room() {
        //ajouter le triangle
        Triangle triangle = new Triangle();
        getContentPane().setLayout(null);
        getContentPane().add(triangle);

        // Ajouter une porte
        Door door = new Door();
        getContentPane().setLayout(null);
        getContentPane().add(door);


        //ajouter la table
        Table table = new Table();
        getContentPane().setLayout(null);
        getContentPane().add(table);

        //ajouter le rond
        Rond rond = new Rond();
        getContentPane().setLayout(null);
        getContentPane().add(rond);

        //ajouter la lampe
        Lampe lampe = new Lampe();
        getContentPane().setLayout(null);
        getContentPane().add(lampe);

        //ajouter livre
        Livre livre = new Livre();
        getContentPane().setLayout(null);
        getContentPane().add(livre);

        //ajouter horloge
        Montre montre = new Montre();
        getContentPane().setLayout(null);
        getContentPane().add(montre);

    }
}
