package Shooter.Enemy;

import Map.Map;
import Shooter.Player.Player;

import java.awt.*;

public class EnemyInventory {
    private static Enemy getNewPistolEnemy(Player player, Map map) {
        return new Enemy(player, map, Color.RED, 0, 0, 40, 0.75, 60, 0, 100);
    }

    private static Enemy getNewShotgunEnemy(Player player, Map map) {
        return new Enemy(player, map, Color.YELLOW, 0, 0, 40, 0.5, 70, 1, 200);
    }

    private static Enemy getNewRifleM4Enemy(Player player, Map map) {
        return new Enemy(player, map, Color.BLUE, 0, 0, 40, 0.5, 80, 2, 300);
    }

    private static Enemy getNewSniperEnemy(Player player, Map map) {
        return new Enemy(player, map, Color.PINK, 0, 0, 40, 0.75, 100, 4, 500);
    }

    private static Enemy getNewRifleAKMEnemy(Player player, Map map) {
        return new Enemy(player, map, Color.WHITE, 0, 0, 40, 0.5, 100, 3, 300);
    }

    public static Enemy getNewEnemy(Player player, Map map, String enemyType) {
        Enemy enemy;
        switch (enemyType) {
            case "Pistol enemy" -> enemy = getNewPistolEnemy(player, map);
            case "Shotgun enemy" -> enemy = getNewShotgunEnemy(player, map);
            case "Rifle M4 enemy" -> enemy = getNewRifleM4Enemy(player, map);
            case "Rifle AKM enemy" -> enemy = getNewRifleAKMEnemy(player, map);
            case "Sniper AWM enemy" -> enemy = getNewSniperEnemy(player, map);
            default -> throw new IllegalStateException("Unexpected value: " + enemyType);
        }
        return enemy;
    }
}
