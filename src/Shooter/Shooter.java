package Shooter;

import Map.Map;
import Weapon.GunInventory;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Shooter {
    public Map map;

    public final Color color;
    public double x, y;
    public final double size;
    public double velX, velY;
    public final double speed;
    public double angle;
    public final double maxHealth;
    public double health;

    public final GunInventory gunInventory;
    public int gunIndex;

    public Shooter(Map map, Color color, double x, double y, double size, double speed, double maxHealth) {
        this.map = map;
        this.color = color;
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
        this.maxHealth = maxHealth;
        health = maxHealth;

        gunInventory = new GunInventory(this);
    }

    public void update() {
        x += velX;
        y += velY;
    }

    public void updateGun() {
        gunInventory.update();
    }

    public void damage(double damage) {
        health -= damage;
    }

    protected void paintBody(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        AffineTransform body = new AffineTransform();

        double rotatePosX = map.x + x + size / 3;
        double rotatePosY = map.y + y + size / 2;
        int x1 = (int) (map.x + x);
        int x2 = (int) (map.x + x + size);
        int x3 = (int) (map.x + x);
        int y1 = (int) (map.y + y);
        int y2 = (int) (map.y + y + size / 2);
        int y3 = (int) (map.y + y + size);

        g2d.rotate(angle, rotatePosX, rotatePosY);
        g2d.setColor(color);
        if (health > 0) {
            g2d.fillPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
        }
        g2d.setTransform(body);
    }

    public Rectangle getBound() {
        return (new Rectangle((int) x, (int) y, (int) size, (int) size));
    }

    protected void paintGun(Graphics g) {
        gunInventory.paint(g);
    }

    public void paint(Graphics g) {
        paintGun(g);
        paintBody(g);
    }
}
