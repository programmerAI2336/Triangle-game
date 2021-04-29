package Game.GameplayUI;

import Controller.PlayerController;
import ImageManager.ImageManager;
import Shooter.Player.Player;
import Weapon.Gun;

import java.awt.*;

public class GamePlayUI {
    private final PlayerController controller;
    private final Player player;
    private final ScorePainter scorePainter;

    public GamePlayUI(PlayerController controller) {
        this.controller = controller;
        player = controller.player;
        scorePainter = new ScorePainter(player);
    }

    private void paintHealthIcon(Graphics g) {
        //paint heart icon.
        g.drawImage(ImageManager.getImage("Heart"), 40, 40, 20, 20, null);
        //paint health bar.
        g.setColor(new Color(60, 60, 60));
        g.fillRect(65, 40, 120, 20);
        g.setColor(Color.RED);
        g.fillRect(65, 40, (int) (120 * player.health / player.maxHealth), 20);
    }

    private void paintAmmoIcon(Graphics g) {
        Gun playerGun = player.gunInventory.inventory[player.gunIndex];

        g.drawImage(ImageManager.getImage("Ammo"), 28, 70, 32, 20, null);
        g.setColor(new Color(60, 60, 60));
        g.fillRect(65, 70, 120, 20);
        g.setColor(Color.YELLOW);
        g.fillRect(65, 70, 120 * playerGun.ammoCounter / playerGun.mag, 20);
    }

    private void paintGunFrame(Graphics g) {
        for (int i = 0; i <= 3; i++) {
            g.drawImage(ImageManager.getImage("Gun frame 0"), 1241, 25 + i * 125, 100, 100, null);
        }

        for (int i = 0; i < controller.keyController.gunIndexContainer.length; i++) {
            if (controller.keyController.gunIndexContainer[i] == player.gunIndex) {
                g.drawImage(ImageManager.getImage("Gun frame 1"), 1241, 25 + 125 * i, 100, 100, null);
            }
        }
    }

    private void paintGunIcon(Graphics g) {
        for (int index = 0; index < controller.keyController.gunIndexContainer.length; index++) {
            Gun gun = player.gunInventory.inventory[controller.keyController.gunIndexContainer[index]];
            int width;

            if (index == 0) {
                //pistol icon's width.
                width = 60;
            } else {
                //other gun icon's width.
                width = 80;
            }

            int length = gun.image.getHeight(null) * width / gun.image.getWidth(null);
            int x = 1241 + (100 - width) / 2;
            int y = 75 + 125 * index - length / 2;
            g.drawImage(gun.image, x, y, width, length, null);
        }
    }

    public void paint(Graphics g) {
        scorePainter.paint(g);
        paintHealthIcon(g);
        paintAmmoIcon(g);
        paintGunFrame(g);
        paintGunIcon(g);
    }

    public void handle() {
        scorePainter.handle();
    }
}
