package Item;

import java.util.Random;

public class ItemManager {
    private static final String[] itemName = new String[]{"Pistol M9", "Shotgun M2", "Rifle M4", "Rifle AKM", "Sniper AWM", "Sniper Barrett", "Med kit", "Ammo"};
    private static final Random random = new Random();

    public static String getRandomItem() {
        int index;
        int value = random.nextInt(100);
        if (value <= 30) {
            index = 0;
        } else if (value <= 50) {
            index = 1;
        } else if (value <= 55) {
            index = 2;
        } else if (value <= 60) {
            index = 3;
        } else if (value <= 70) {
            index = 4;
        } else if (value <= 75) {
            index = 5;
        } else if (value <= 78) {
            index = 7;
        } else {
            index = 6;
        }
        return itemName[index];
    }
}
