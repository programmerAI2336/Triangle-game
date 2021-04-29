package Weapon;

import ImageManager.ImageManager;
import Shooter.Shooter;

import java.awt.*;

public class GunInventory {
    public final Gun pistolM9;
    public final Gun shotgunM2;
    public final Gun rifleM4;
    public final Gun rifleAKM;
    public final Gun sniperAWM;
    public final Gun sniperBARRETT;
    public Gun[] inventory;

    public GunInventory(Shooter shooter) {
        pistolM9 = new Gun(shooter, 50, 1, 0.06, 15, 100, ImageManager.getImage("Pistol M9"));
        pistolM9.setAmmo(shooter.color, 2.75, 12, 50);

        shotgunM2 = new Gun(shooter, 80, 7, 0.3, 15, 20, ImageManager.getImage("Shotgun M2"));
        shotgunM2.setAmmo(shooter.color, 3, 12, 50);

        rifleM4 = new Gun(shooter, 20, 1, 0.1, 20, 100, ImageManager.getImage("Rifle M4"));
        rifleM4.setAmmo(shooter.color, 4, 12, 100);

        rifleAKM = new Gun(shooter, 25, 1, 0.13, 25, 100, ImageManager.getImage("Rifle AKM"));
        rifleAKM.setAmmo(shooter.color, 3.5, 16, 100);

        sniperAWM = new Gun(shooter, 250, 1, 0, 100, 20, ImageManager.getImage("Sniper AWM"));
        sniperAWM.setAmmo(shooter.color, 5, 16, 150);

        sniperBARRETT = new Gun(shooter, 375, 1, 0, 200, 20, ImageManager.getImage("Sniper Barrett"));
        sniperBARRETT.setAmmo(shooter.color, 6.5, 18, 250);

        inventory = new Gun[]{pistolM9, shotgunM2, rifleM4, rifleAKM, sniperAWM, sniperBARRETT};

    }

    public void paint(Graphics g) {
        for (Gun gun : inventory) {
            gun.paintAmmo(g);
        }
    }

    public void update() {
        for (Gun gun : inventory) {
            gun.update();
        }
    }
}
