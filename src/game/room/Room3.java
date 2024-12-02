package game.room;

import game.items.Item;
import game.items.components.Door;
import game.items.components.InteractiveJoker;
import game.items.components.Joker;

import javax.swing.*;
import java.awt.*;

public class Room3 extends Room{
    public Room3() {
        super(3, "pure", "backo_room3.jpg", true);
    }

    @Override
    protected void setup() {
        // initialization
        Door door3 = new Door("door3.jpg");


        JLabel text_enigme1 = new JLabel("Je suis l’état que l’on cherche, souvent associé à la perfection.");
        JLabel text_enigme2 = new JLabel("Je peux être immaculée, sans tache ni défaut.");
        JLabel text_enigme3 = new JLabel("Je suis ce que tu trouves dans l'eau, l’air ou la neige.");
        JLabel text_enigme4 = new JLabel("Quand je suis là, rien n’est souillé, tout est en harmonie.");
        JLabel text_enigme5 = new JLabel("Qui suis-je ?");

        // Définir la police et la couleur du texte
        Font font = new Font("Arial", Font.PLAIN, 18);
        Color textColor = Color.BLACK;

        // Appliquer la police et la couleur aux labels
        text_enigme1.setFont(font);
        text_enigme2.setFont(font);
        text_enigme3.setFont(font);
        text_enigme4.setFont(font);
        text_enigme5.setFont(font);

        text_enigme1.setForeground(textColor);
        text_enigme2.setForeground(textColor);
        text_enigme3.setForeground(textColor);
        text_enigme4.setForeground(textColor);
        text_enigme5.setForeground(textColor);


        // Positionner les labels sur la fenêtre
        text_enigme1.setBounds(getWidth()-600, 20, 600, 50);
        text_enigme2.setBounds(getWidth()-600, 50, 600, 50);
        text_enigme3.setBounds(getWidth()-600, 80, 600, 50);
        text_enigme4.setBounds(getWidth()-600, 110, 600, 50);
        text_enigme5.setBounds(getWidth()-600, 140, 600, 50);

        InteractiveJoker cadre = new InteractiveJoker("cadre1.png","4 lettres, symbolysant une lys blache en plein floraisant, lowercase(P...)");
        InteractiveJoker lampe = new InteractiveJoker("lampe.png","Lumière limpide et brillante.");
        cadre.place(40,240);
        lampe.place(700,0);
        // sorting items
        Item[] alignements = {door3,cadre,lampe};
        // important
        door3.place(250,130);
        add(text_enigme1);
        add(text_enigme2);
        add(text_enigme3);
        add(text_enigme4);
        add(text_enigme5);
        addItems(alignements);

    }
}
