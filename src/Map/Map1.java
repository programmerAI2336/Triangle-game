package Map;

import Camera.Camera;

import java.awt.*;

public class Map1 extends Map {

    public Map1(Camera camera) {
        super(camera);
        width = 1500;
        length = 1500;
        initWall();
    }

    private void initWall() {
        int thickness = 20;
        //top wall.
        wall.add(new Rectangle(0, 0, (int) width, thickness));
        //bottom wall.
        wall.add(new Rectangle(0, (int) length - thickness, (int) width, thickness));
        //left wall.
        wall.add(new Rectangle(0, 0, thickness, (int) length));
        //right wall.
        wall.add(new Rectangle((int) width - thickness, 0, thickness, (int) length));
    }
}
