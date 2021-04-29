package Game.Screen;

import ImageManager.ImageManager;
import Game.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
    public final Button start;

    public Menu() {
        start = new Button(ImageManager.getImage("Start 0"), ImageManager.getImage("Start 1"), 603, 359, 160, 50);
    }

    private void paintTitle(Graphics g) {
        g.drawImage(ImageManager.getImage("Triangle game"), 333, 75, 700, 84, null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.BLACK);
        paintTitle(g);
        start.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        start.actionPerformed(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        start.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        start.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        start.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        start.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        start.mouseMoved(e);
    }
}
