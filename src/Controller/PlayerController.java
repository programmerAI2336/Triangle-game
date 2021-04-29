package Controller;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Shooter.Enemy.Enemy;
import Shooter.Player.Player;
import Map.Map;

public class PlayerController implements KeyListener, MouseMotionListener, MouseListener {
    public final Player player;
    public final KeyController keyController;
    public final MouseController mouseController;
    public final ItemPicker itemPicker;

    public PlayerController(Map map, int[] gunIndexContainer) {
        player = new Player(map, Color.CYAN, 100, 100, 40, 2, 100);
        keyController = new KeyController(player, gunIndexContainer);
        mouseController = new MouseController(player);
        itemPicker = new ItemPicker(player, keyController);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyController.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyController.keyReleased(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseController.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseController.mouseMoved(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseController.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseController.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseController.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseController.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void handle(ArrayList<Enemy> allEnemy) {
        keyController.handleEvent();
        mouseController.handleEvent();
        itemPicker.handle(allEnemy);
        player.dash();
    }

    public void update() {
        player.update();
        player.updateGun();
    }

    public void paint(Graphics g) {
        player.paint(g);
    }
}
