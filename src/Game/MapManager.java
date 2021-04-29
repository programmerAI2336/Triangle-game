package Game;

import Camera.Camera;
import Map.Map;
import Map.Map1;

import java.awt.*;

public class MapManager {
    public int mapIndex;
    private final Map[] mapContainer;

    public MapManager(Camera camera) {
        Map1 map1 = new Map1(camera);
        mapContainer = new Map[]{map1};
    }

    public void update() {
        mapContainer[mapIndex].updatePosition();
    }

    public Map getMap(int index) {
        mapIndex = index;
        return mapContainer[index];
    }

    public void paint(Graphics g) {
        mapContainer[mapIndex].paint(g);
    }
}
