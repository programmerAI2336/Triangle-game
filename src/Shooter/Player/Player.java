package Shooter.Player;

import java.awt.*;
import java.util.ArrayList;

import Shooter.Shooter;
import Map.Map;

public class Player extends Shooter {
    public boolean dash;
    public int dashTimer = 1075;
    private int dashTimerDecrease;
    private double dashAngle;
    private final ArrayList<DashTrail> dashTrail = new ArrayList<>();

    public int score;

    public Player(Map map, Color color, double x, double y, double size, double speed, double maxHealth) {
        super(map, color, x, y, size, speed, maxHealth);
    }


    public void dash() {
        showTrail();

        dashTimer -= dashTimerDecrease;
        if (dash) {
            if (dashTimer > 1000) {
                //dashing.
                velX = speed * 1.25 * Math.cos(dashAngle);
                velY = speed * 1.25 * Math.sin(dashAngle);
                dashTimerDecrease = 1;
            }
        } else {
            dashAngle = angle;
        }

        if (dashTimer <= 1000) {
            dash = false;
            if (dashTimer == 1000) {
                //stop player.
                velX = 0;
                velY = 0;
            }
            if (dashTimer < 0) {
                //reset.
                dashTimer = 1075;
                dashTimerDecrease = 0;
            }
        }
    }

    private void showTrail() {
        if (dash) {
            if (dashTimer > 1000) {//dashing.
                if (dashTimer % 5 == 0) {
                    dashTrail.add(new DashTrail(map, x, y, size, angle));
                }
            }
        }
        if (!dashTrail.isEmpty()) {
            dashTrail.removeIf(trail -> trail.curSize <= 0);
        }
        for (DashTrail trail : dashTrail) {
            trail.handleAppearance();
        }
    }

    private void paintTrail(Graphics g) {
        for (DashTrail trail : dashTrail) {
            trail.paint(g);
        }
    }

    protected void paintBody(Graphics g) {
        paintTrail(g);
        super.paintBody(g);
    }
}
