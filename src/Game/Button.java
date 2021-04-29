package Game;

import java.awt.*;
import java.awt.event.*;

public class Button extends Rectangle implements MouseMotionListener, MouseListener, ActionListener {
    private boolean touched;
    public boolean clicked;
    private final Image beforeTouched, afterTouched;
    private final Rectangle mouse;

    public Button(Image beforeTouched, Image afterTouched, int x, int y, int width, int height) {
        mouse = new Rectangle(0, 0, 1, 1);
        this.beforeTouched = beforeTouched;
        this.afterTouched = afterTouched;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g) {
        if (!touched) {
            g.drawImage(beforeTouched, x, y, width, height, null);
        } else {
            g.drawImage(afterTouched, x, y, width, height, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouse.x = e.getX();
        mouse.y = e.getY();
        if(mouse.intersects(getBounds())){
            clicked = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
        mouse.x = e.getX();
        mouse.y = e.getY();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouse.x = e.getX();
        mouse.y = e.getY();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouse.x = e.getX();
        mouse.y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse.x = e.getX();
        mouse.y = e.getY();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        touched = mouse.intersects(this);
    }
}
