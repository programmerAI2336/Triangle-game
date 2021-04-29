package Item;

import ImageManager.ImageManager;
import Map.Map;

import java.awt.*;

public class Item extends Rectangle {
    private final Map map;
    public int timer = 2500;
    public final String stuffName;
    private final Image image;

    public Item(Map map, String stuffName) {
        this.map = map;
        this.stuffName = stuffName;
        image = ImageManager.getImage(stuffName);
        setItemSize();
    }

    private void setItemSize() {
        switch (stuffName) {
            case "Pistol M9" -> setSize(50, 37);
            case "Shotgun M2" -> setSize(60, 16);
            case "Rifle M4" -> setSize(65, 26);
            case "Rifle AKM" -> setSize(65, 25);
            case "Sniper AWM" -> setSize(70, 18);
            case "Sniper Barrett" -> setSize(75, 26);
            case "Med kit" -> setSize(60, 45);
            case "Ammo" -> setSize(50,31);
            default -> setSize(0, 0);
        }
    }

    public void paint(Graphics g) {
        if (timer > 0) {
            g.drawImage(image, (int) (map.x + x), (int) (map.y + y), width, height, null);
        }
    }

    public void countTimer() {
        timer--;
    }
}
