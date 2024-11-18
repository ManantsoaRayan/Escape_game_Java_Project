package item;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InteractiveItem extends Item implements MouseListener{

    public InteractiveItem(String name, int value, int x, int y, int width, int height) {
        super(name, value, x, y, width, height);
        this.addMouseListener(this);
    }

    // quand on clique sur l'item les détails s'affichent
    @Override
    public void mouseClicked(MouseEvent e) {
        showDetails();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    //les details disparaissent quand on sort de la zone de l'item
    @Override
    public void mouseExited(MouseEvent e) {
        hideDetails();
    }
}
