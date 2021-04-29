package Weapon;

import Map.Map;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Ammo {
    public int timer;
    public final Map map;

    public boolean appear = true;
    public double x, y;
    public double velX, velY;
    public final double size;
    public final double speed;
    public final Color color;
    public double angle;

    private double trailAngle;
    private final double trailLength;
    public double currentTrailLength;

    public Ammo(Map map, Color color, double speed, double size, double trailLength) {
        this.map = map;
        this.color = color;
        this.speed = speed;
        this.size = size;
        this.trailLength = trailLength;
    }

    public void update() {
        x += velX;
        y += velY;
        if (timer > 0) {
            timer++;
        }
        handleTrail();
    }

    private void handleTrail() {
        if (appear) {
            if (currentTrailLength < trailLength) {
                currentTrailLength += speed;
            } else {
                currentTrailLength = trailLength;
            }
        } else {
            if (currentTrailLength > 0) {
                currentTrailLength -= speed;
            } else {
                currentTrailLength = 0;
            }
        }
    }

    public void fly(double barrelX, double barrelY, double angle) {
        if (timer == 0) {
            x = barrelX - size / 2;
            y = barrelY - size / 2;
            velX = speed * Math.cos(angle);
            velY = speed * Math.sin(angle);
            trailAngle = angle;
        }
        timer++;
    }

    public Rectangle getBound() {
        return (new Rectangle((int) x, (int) y, (int) size, (int) size));
    }

    private void paintAmmo(Graphics2D g2d) {
        AffineTransform ammo = new AffineTransform();
        double rotatePosX = map.x + x + size / 2;
        double rotatePosY = map.y + y + size / 2;
        int x = (int) (map.x + this.x);
        int y = (int) (map.y + this.y);
        if (appear) {
            g2d.rotate(angle, rotatePosX, rotatePosY);
            g2d.setColor(color);
            g2d.fillOval(x, y, (int) size, (int) size);
        }
        g2d.setTransform(ammo);
    }

    private void paintTrail(Graphics2D g2d) {
        AffineTransform trail = new AffineTransform();
        double rotatePosX = map.x + x + size / 2;
        double rotatePosY = map.y + y + size / 2;
        int x1 = (int) (map.x + x + size / 2);
        int x2 = (int) (map.x + x + size / 2 - currentTrailLength);
        int x3 = (int) (map.x + x + size / 2);
        int y1 = (int) (map.y + y + size / 4);
        int y2 = (int) (map.y + y + size / 2);
        int y3 = (int) (map.y + y + size * 3 / 4);
        if (currentTrailLength > 0) {
            g2d.rotate(trailAngle, rotatePosX, rotatePosY);
            g2d.setColor(new Color(90, 90, 90, 101));
            g2d.fillPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
        }
        g2d.setTransform(trail);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        paintTrail(g2d);
        paintAmmo(g2d);
    }
}
