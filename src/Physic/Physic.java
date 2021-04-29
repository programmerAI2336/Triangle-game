package Physic;

import Map.Map;
import Shooter.Enemy.Enemy;
import Shooter.Player.Player;

import java.util.ArrayList;

public class Physic {
    public final ShooterPhysic shooterPhysic;
    public final AmmoPhysic ammoPhysic;

    public Physic(Map map, Player player, ArrayList<Enemy> enemy) {
        shooterPhysic = new ShooterPhysic(map, player, enemy);
        ammoPhysic = new AmmoPhysic(map, player, enemy);
    }

    public void handle() {
        shooterPhysic.handle();
        ammoPhysic.handle();
    }
}
