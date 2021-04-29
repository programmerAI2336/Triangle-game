package Physic;

import Map.Map;
import Shooter.Enemy.Enemy;
import Shooter.Player.Player;
import Shooter.Shooter;

import java.awt.*;
import java.util.ArrayList;

public class ShooterPhysic {
    public Map map;
    private final Player player;
    private final ArrayList<Enemy> enemy;

    public ShooterPhysic(Map map, Player player, ArrayList<Enemy> enemy) {
        this.map = map;
        this.player = player;
        this.enemy = enemy;
    }

    private void collideWall() {
        ArrayList<Shooter> allShooter = new ArrayList<>(enemy);
        allShooter.add(player);

        for (Shooter shooter : allShooter) {
            if (shooter.velX > 0) {
                for (int x = (int) (shooter.x + shooter.size); x <= shooter.x + shooter.size + shooter.velX; x++) {
                    for (Rectangle box : map.wall) {
                        if (x == box.x) {
                            if (shooter.y > box.y - shooter.size && shooter.y < box.y + box.height) {
                                shooter.velX = 0;
                                shooter.x = x - shooter.size;
                            }
                        }
                    }
                }
            } else if (shooter.velX < 0) {
                for (int x = (int) shooter.x; x >= shooter.x + shooter.velX; x--) {
                    for (Rectangle box : map.wall) {
                        if (x == box.x + box.width) {
                            if (shooter.y > box.y - shooter.size && shooter.y < box.y + box.height) {
                                shooter.velX = 0;
                                shooter.x = x;
                            }
                        }
                    }
                }
            }

            if (shooter.velY > 0) {
                for (int y = (int) (shooter.y + shooter.size); y <= shooter.y + shooter.size + shooter.velY; y++) {
                    for (Rectangle box : map.wall) {
                        if (y == box.y) {
                            if (shooter.x > box.x - shooter.size && shooter.x < box.x + box.width) {
                                shooter.velY = 0;
                                shooter.y = y - shooter.size;
                            }
                        }
                    }
                }
            } else if (shooter.velY < 0) {
                for (int y = (int) shooter.y; y >= shooter.y + shooter.velY; y--) {
                    for (Rectangle box : map.wall) {
                        if (y == box.y + box.height) {
                            if (shooter.x > box.x - shooter.size && shooter.x < box.x + box.width) {
                                shooter.velY = 0;
                                shooter.y = y;
                            }
                        }
                    }
                }
            }
        }

    }

    public void handle() {
        collideWall();
    }
}
