package Weapon;

import Shooter.Shooter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Gun {
    public Shooter shooter;
    public ArrayList<Ammo> ammo = new ArrayList<>();
    public final int fireRate;
    public final int amount;
    public final double deflection;
    public final double damage;
    public final Image image;

    public final int mag;
    public int ammoCounter;

    public Color ammoColor;
    public double ammoSize;
    public double ammoSpeed;
    public double ammoTrailLength;

    private final Random random = new Random();

    public Gun(Shooter shooter, int fireRate, int amount, double deflection, double damage, int mag, Image image) {
        this.shooter = shooter;
        this.fireRate = fireRate;
        this.amount = amount;
        this.deflection = deflection;
        this.damage = damage;
        this.mag = mag;
        ammoCounter = mag;
        this.image = image;
    }

    public void setAmmo(Color color, double speed, double size, double trailLength) {
        ammoColor = color;
        ammoSize = size;
        ammoSpeed = speed;
        ammoTrailLength = trailLength;
    }

    public void shoot() {
        boolean shoot = false;
        if (ammoCounter > 0) {
            if (ammo.isEmpty()) {
                shoot = true;
            } else {
                if (ammo.get(ammo.size() - 1).timer >= fireRate) {
                    shoot = true;
                }
            }
        }

        if (shoot) {
            for (int i = 0; i < amount; i++) {
                Ammo newAmmo = new Ammo(shooter.map, ammoColor, ammoSpeed, ammoSize, ammoTrailLength);
                ammo.add(newAmmo);
                //set position for ammo.
                double barrelX = shooter.x + shooter.size / 3 + (shooter.size * 2 / 3) * Math.cos(shooter.angle);
                double barrelY = shooter.y + shooter.size / 2 + (shooter.size / 2) * Math.sin(shooter.angle);
                //set angle for ammo.
                double[] shootAngle = new double[(int) (2 * deflection / 0.01 + 1)];
                for (int j = 0; j < shootAngle.length; j++) {
                    //-deflection <= random angle <= deflection.
                    shootAngle[j] = -deflection + j * 0.01;
                }
                double angle = shooter.angle + shootAngle[random.nextInt(shootAngle.length)];
                //ammo fly.
                ammo.get(ammo.indexOf(newAmmo)).fly(barrelX, barrelY, angle);
            }

            ammoCounter--;
        }
    }

    private void removeAmmo() {
        ammo.removeIf(ammo -> ammo.timer >= fireRate && !ammo.appear && ammo.currentTrailLength < 0);
    }

    public void update() {
        removeAmmo();
        for (Ammo ammo : ammo) {
            ammo.update();
        }
    }

    public void paintAmmo(Graphics g) {
        for (Ammo ammo : ammo) {
            ammo.paint(g);
        }
    }
}
