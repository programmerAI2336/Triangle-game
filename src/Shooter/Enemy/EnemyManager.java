package Shooter.Enemy;

import Map.Map;
import Shooter.Enemy.Spawner.EnemySpawner;
import Shooter.Player.Player;

import java.awt.*;
import java.util.ArrayList;

public class EnemyManager {
    private final EnemySpawner pistolEnemySpawner;
    private final EnemySpawner shotgunEnemySpawner;
    private final EnemySpawner rifleM4EnemySpawner;
    private final EnemySpawner rifleAKMEnemySpawner;
    private final EnemySpawner sniperAWMEnemySpawner;
    public final ArrayList<Enemy> allEnemy = new ArrayList<>();
    public final ArrayList<EnemySpawner> enemySpawner = new ArrayList<>();

    public EnemyManager(Player player, Map map) {
        pistolEnemySpawner = new EnemySpawner(player, map, "Pistol enemy", 1000);
        shotgunEnemySpawner = new EnemySpawner(player, map, "Shotgun enemy", 2000);
        rifleM4EnemySpawner = new EnemySpawner(player, map, "Rifle M4 enemy", 1500);
        rifleAKMEnemySpawner = new EnemySpawner(player, map, "Rifle AKM enemy", 1500);
        sniperAWMEnemySpawner = new EnemySpawner(player, map, "Sniper AWM enemy", 2500);

        enemySpawner.add(pistolEnemySpawner);
        enemySpawner.add(shotgunEnemySpawner);
        enemySpawner.add(rifleM4EnemySpawner);
        enemySpawner.add(rifleAKMEnemySpawner);
        enemySpawner.add(sniperAWMEnemySpawner);
    }

    public void paint(Graphics g) {
        for (EnemySpawner es : enemySpawner) {
            es.paint(g);
        }
    }

    private void updateAllEnemy() {
        for (EnemySpawner es : enemySpawner) {
            if (es.spawnNewEnemy) {
                allEnemy.addAll(es.enemy);
            }
        }
    }

    public void handle() {
        pistolEnemySpawner.handle(0, 5, 200);
        shotgunEnemySpawner.handle(5000, 2, 300);
        rifleM4EnemySpawner.handle(10000, 10, 400);
        rifleAKMEnemySpawner.handle(20000, 15, 500);
        sniperAWMEnemySpawner.handle(30000, 10, 600);
    }

    public void update() {
        updateAllEnemy();
        for (EnemySpawner es : enemySpawner) {
            es.update();
        }
    }
}
