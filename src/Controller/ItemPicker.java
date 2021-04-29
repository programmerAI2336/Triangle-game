package Controller;

import Item.Item;
import Shooter.Enemy.Enemy;
import Shooter.Player.Player;
import Weapon.Gun;

import java.util.ArrayList;

public class ItemPicker {
    private final KeyController keyController;
    private final Player player;

    public ItemPicker(Player player, KeyController keyController) {
        this.keyController = keyController;
        this.player = player;
    }

    private void handlePickGun(Item item) {
        switch (item.stuffName) {
            case "Pistol M9":
                keyController.gunIndexContainer[0] = 0;
                //reload.
                player.gunInventory.pistolM9.ammoCounter = player.gunInventory.inventory[0].mag;
                item.timer = 0;
                break;
            case "Shotgun M2":
                keyController.gunIndexContainer[1] = 1;
                //reload.
                player.gunInventory.shotgunM2.ammoCounter = player.gunInventory.shotgunM2.mag;
                item.timer = 0;
                break;
            case "Rifle M4":
                keyController.gunIndexContainer[2] = 2;
                //reload.
                player.gunInventory.rifleM4.ammoCounter = player.gunInventory.rifleM4.mag;
                item.timer = 0;
                break;
            case "Rifle AKM":
                keyController.gunIndexContainer[2] = 3;
                //reload.
                player.gunInventory.rifleAKM.ammoCounter = player.gunInventory.rifleAKM.mag;
                item.timer = 0;
                break;
            case "Sniper AWM":
                keyController.gunIndexContainer[3] = 4;
                //reload.
                player.gunInventory.sniperAWM.ammoCounter = player.gunInventory.sniperAWM.mag;
                item.timer = 0;
                break;
            case "Sniper Barrett":
                keyController.gunIndexContainer[3] = 5;
                //reload.
                player.gunInventory.sniperBARRETT.ammoCounter = player.gunInventory.sniperBARRETT.mag;
                item.timer = 0;
                break;

            case "Ammo":
                for (Gun gun : player.gunInventory.inventory) {
                    gun.ammoCounter = gun.mag;
                }
                item.timer = 0;
                break;
            case "Med kit":
                player.health = player.maxHealth;
                item.timer = 0;
                break;
            default:
        }
    }

    public void handle(ArrayList<Enemy> allEnemy) {
        if (!player.dash) {
            for (Enemy enemy : allEnemy) {
                //check if enemy was alive and item was appear.
                if (enemy.health <= 0 && enemy.item.timer > 0) {
                    if (player.getBound().intersects(enemy.item.getBounds())) {
                        handlePickGun(enemy.item);
                    }
                }
            }
        }
    }
}
