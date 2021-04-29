package Shooter.Enemy;

import Item.Item;
import Item.ItemManager;
import Map.Map;
import Shooter.Player.Player;
import Shooter.Shooter;

import java.awt.*;
import java.util.Random;

public class Enemy extends Shooter {
    protected final Player player;
    protected final Random random = new Random();
    public final Item item;
    private final int scoreValue;

    public Enemy(Player player, Map map, Color color, double x, double y, double size, double speed, double maxHealth, int gunIndex, int scoreValue) {
        super(map, color, x, y, size, speed, maxHealth);
        item = new Item(map, ItemManager.getRandomItem());
        this.player = player;
        this.gunIndex = gunIndex;
        this.scoreValue = scoreValue;
    }


    public void followPlayer(int minDistance) {
        if (health > 0) {
            double distanceToPlayer = Math.sqrt(Math.pow(player.x - x, 2) + Math.pow(player.y - y, 2));
            if (distanceToPlayer >= minDistance) {
                velX = speed * Math.cos(angle);
                velY = speed * Math.sin(angle);
            } else {
                velX = 0;
                velY = 0;
            }
        }
    }

    public void rotate() {
        if (health > 0) {
            double angle = Math.atan((player.y + player.size / 2 - y - size / 2) / (player.x + player.size / 3 - x - size / 3));
            if (player.x + player.size / 3 > x + size / 3) {
                if (player.y + player.size / 2 > y + size / 2) {
                    this.angle = angle;
                } else {
                    this.angle = angle + Math.toRadians(360);
                }
            } else if (player.x + player.size / 3 < x + size / 2) {
                this.angle = angle + Math.toRadians(180);
            }
        }
    }

    public void shootPlayer(int shootProbability) {
        if (health > 0 && player.health > 0) {
            int number = random.nextInt(1000);
            if (number <= shootProbability) {
                gunInventory.inventory[gunIndex].shoot();
            }
        }
    }

    public void appearAtRandomPosition() {
        int x = random.nextInt((int) (map.width - size));
        int y = random.nextInt((int) (map.length - size));
        for (Rectangle wall : map.wall) {
            if (!new Rectangle(x, y, (int) size, (int) size).intersects(wall)) {
                this.x = x;
                this.y = y;
            }
        }
    }

    private void killedByDash() {
        if (health > 0) {
            if (player.dash) {
                if (player.getBound().intersects(getBound())) {
                    health = 0;
                }
            }
        }
    }

    private void dropItemWhenDie() {
        if (health <= 0) {
            item.countTimer();
        } else {
            item.setLocation((int) x, (int) y);
        }
    }

    private void giveScore() {
        if (health <= 0) {
            if (item.timer == 2500) {
                player.score += scoreValue;
            }
        }
    }

    public void die() {
        killedByDash();
        giveScore();
        dropItemWhenDie();
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (health <= 0) {
            item.paint(g);
        }
    }
}
