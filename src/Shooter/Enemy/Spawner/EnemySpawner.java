package Shooter.Enemy.Spawner;

import Map.Map;
import Shooter.Enemy.Enemy;
import Shooter.Enemy.EnemyInventory;
import Shooter.Player.Player;

import java.awt.*;
import java.util.ArrayList;

public class EnemySpawner {
    public Map map;
    private final Player player;

    private final String enemyType;
    public final ArrayList<Enemy> enemy = new ArrayList<>();
    private int timer;
    private final int spawnSpeed;
    public boolean spawnNewEnemy;

    public EnemySpawner(Player player, Map map, String enemyType, int spawnSpeed) {
        this.player = player;
        this.map = map;
        this.enemyType = enemyType;
        this.spawnSpeed = spawnSpeed;
    }

    public void paint(Graphics g) {
        for (Enemy enemy : enemy) {
            enemy.paint(g);
        }
    }

    private void spawnEnemy(int sleepTimeOfTimer) {
        timer++;
        if (timer >= sleepTimeOfTimer) {
            if (enemy.size() < 5) {
                if (timer % spawnSpeed == 0) {
                    enemy.add(EnemyInventory.getNewEnemy(player, map, enemyType));
                    enemy.get(enemy.size() - 1).appearAtRandomPosition();
                    spawnNewEnemy = true;
                } else {
                    spawnNewEnemy = false;
                }
            }
        }
    }

    private void removeEnemy() {
        enemy.removeIf(enemy -> enemy.gunInventory.inventory[enemy.gunIndex].ammo.isEmpty() && enemy.item.timer <= 0);
    }

    public void handle(int sleepTimeOfTimer, int shootProbability, int minDistance) {
        spawnEnemy(sleepTimeOfTimer);
        removeEnemy();
        for (Enemy enemy : enemy) {
            if (enemy.gunInventory.inventory[enemy.gunIndex].ammoCounter <= 0) {
                //reload when ammo down to 0.
                enemy.gunInventory.inventory[enemy.gunIndex].ammoCounter = enemy.gunInventory.inventory[enemy.gunIndex].mag;
            }
            enemy.rotate();
            enemy.followPlayer(minDistance);
            enemy.shootPlayer(shootProbability);
            enemy.die();
        }
    }

    public void update() {
        for (Enemy enemy : enemy) {
            enemy.update();
            enemy.updateGun();
        }
    }
}
