package Items;

import javax.swing.*;

public abstract class abstract_object extends JLabel {
    public abstract_object(String path,int x,int y,int width,int height){
        try{
            ImageIcon icon_objet = new ImageIcon(getClass().getResource(path));
            if (icon_objet == null){
                throw new RuntimeException("erreur dans le chemin");
            }
            setIcon(icon_objet);
            setBounds(x,y,width,height);
        } catch (Exception e) {
            throw new RuntimeException("erreur lors de la creation de l'image");
        }
    }
}
