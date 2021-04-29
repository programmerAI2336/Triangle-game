package Controller;

import Shooter.Player.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseController implements MouseMotionListener, MouseListener {
    private final Player player;
    public int x, y;
    private boolean shoot;

    public MouseController(Player player) {
        this.player = player;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        if (e.getButton() == MouseEvent.BUTTON1) {
            shoot = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        if (e.getButton() == MouseEvent.BUTTON1) {
            shoot = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void handleRotateMouse() {
        double angle = Math.atan((y - player.map.y - player.y - player.size / 2) / (x - player.map.x - player.x - player.size / 3));
        if (x > player.map.x + player.x + player.size / 3) {
            if (y > player.map.y + player.y + player.size / 2) {
                player.angle = angle;
            } else {
                player.angle = Math.toRadians(360) + angle;
            }
        } else if (x < player.map.x + player.x + player.size / 3) {
            player.angle = Math.toRadians(180) + angle;
        }
    }

    private void handleShooting() {
        if (shoot) {
            player.gunInventory.inventory[player.gunIndex].shoot();
        }
    }

    public void handleEvent() {
        handleRotateMouse();
        handleShooting();
    }
}
