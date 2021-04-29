package Shooter.Player;

import Map.Map;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class DashTrail {
    private final Map map;
    private final double x, y;
    private final int time = 75;
    private int timer = 75;
    private final double angle;
    private final double size;
    public double curSize;
    private int transparency = 255;

    public DashTrail(Map map, double x, double y, double size, double angle) {
        this.map = map;
        this.x = x;
        this.y = y;
        this.size = size;
        curSize = size;
        this.angle = angle;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        AffineTransform shadow = new AffineTransform();
        paintShadow(g2d);
        g2d.setTransform(shadow);
    }

    public void paintShadow(Graphics2D g2d) {
        double rotatePosX = map.x + x + size / 3;
        double rotatePosY = map.y + y + size / 2;
        int x1 = (int) (map.x + x + (size - curSize) / 2);
        int x2 = (int) (map.x + x + (size - curSize) / 2 + curSize);
        int x3 = (int) (map.x + x + (size - curSize) / 2);
        int y1 = (int) (map.y + y + (size - curSize) / 2);
        int y2 = (int) (map.y + y + (size - curSize) / 2 + curSize / 2);
        int y3 = (int) (map.y + y + (size - curSize) / 2 + curSize);

        g2d.rotate(angle, rotatePosX, rotatePosY);
        g2d.setColor(new Color(100, 255, 255, transparency));
        g2d.fillPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
    }

    public void handleAppearance() {
        timer--;
        handleCurrentSize();
        handleTransparency();
    }

    private void handleCurrentSize() {
        curSize = size * timer / time;
    }

    private void handleTransparency() {
        if (timer % 3 == 0) {
            transparency = transparency * timer / time;
        }
    }
}
