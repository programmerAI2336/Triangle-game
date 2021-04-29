package Physic;

import Map.Map;
import Shooter.Enemy.Enemy;
import Shooter.Player.Player;
import Shooter.Shooter;
import Weapon.Ammo;
import Weapon.Gun;

import java.awt.*;
import java.util.ArrayList;

public class AmmoPhysic {
    public Map map;
    private final Player player;
    private final ArrayList<Enemy> enemy;

    public AmmoPhysic(Map map, Player player, ArrayList<Enemy> enemy) {
        this.map = map;
        this.player = player;
        this.enemy = enemy;
    }

    private void handleCollideWall() {
        ArrayList<Shooter> allShooter = new ArrayList<>(enemy);
        allShooter.add(player);
        for (Shooter shooter : allShooter) {
            for (Gun gun : shooter.gunInventory.inventory) {
                for (Ammo ammo : gun.ammo) {
                    for (Rectangle wall : map.wall) {
                        if (ammo.getBound().intersects(wall)) {
                            ammo.velX = 0;
                            ammo.velY = 0;
                            ammo.appear = false;
                        }
                    }
                }
            }
        }
    }

    private void handleCollideShooter() {
        //player 's ammo hits enemy.
        for (Gun gun : player.gunInventory.inventory) {
            for (Ammo ammo : gun.ammo) {
                for (Enemy enemy : enemy) {
                    if (enemy.health > 0) {
                        if (ammo.getBound().intersects(enemy.getBound())) {
                            if (ammo.appear) {
                                enemy.damage(gun.damage);
                                ammo.velX = 0;
                                ammo.velY = 0;
                                ammo.appear = false;
                            }
                        }
                    }
                }
            }
        }

        //enemy's ammo hits player.
        for (Enemy enemy : enemy) {
            for (Ammo ammo : enemy.gunInventory.inventory[enemy.gunIndex].ammo) {
                if (player.health > 0) {
                    if (ammo.getBound().intersects(player.getBound())) {
                        if (ammo.appear) {

                            if (!player.dash) {
                                player.damage(enemy.gunInventory.inventory[enemy.gunIndex].damage);
                            }
                            ammo.velX = 0;
                            ammo.velY = 0;
                            ammo.appear = false;

                        }
                    }
                }
            }
        }
    }

    public void handle() {
        handleCollideWall();
        handleCollideShooter();
    }
}
