package Map;

import Camera.Camera;

import java.awt.*;
import java.util.ArrayList;

public class Map {
    public Camera camera;
    public double x, y;
    public double width, length;
    public ArrayList<Rectangle> wall = new ArrayList<>();

    public Map(Camera camera) {
        this.camera = camera;
    }

    public void updatePosition() {
        x = -camera.x;
        y = -camera.y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        for (Rectangle wall : wall) {
            int wallX = (int) (x + wall.x);
            int wallY = (int) (y + wall.y);
            int wallWidth = wall.width;
            int wallLength = wall.height;
            g.fillRect(wallX, wallY, wallWidth, wallLength);
        }
    }
}
