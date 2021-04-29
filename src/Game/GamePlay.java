package Game;

import Camera.Camera;
import Controller.PlayerController;
import Map.Map;
import Physic.Physic;
import Shooter.Enemy.EnemyManager;
import Shooter.Enemy.Spawner.EnemySpawner;
import Shooter.Player.Player;

import java.awt.*;
import java.awt.event.*;

public class GamePlay implements KeyListener, MouseListener, MouseMotionListener {
    private final Camera camera;
    public final PlayerController playerController = new PlayerController(null, new int[]{0, 1, 2, 4});
    private final EnemyManager enemyManager = new EnemyManager(playerController.player, null);
    private final Physic physic = new Physic(null, playerController.player, enemyManager.allEnemy);

    public GamePlay(Camera camera) {
        this.camera = camera;
    }

    private void resetPlayer(Map map) {
        playerController.player.map = map;
        //reset positions.
        playerController.player.x = map.x + map.width / 2 - playerController.player.size / 2;
        playerController.player.y = map.y + map.length / 2 - playerController.player.size / 2;
        playerController.player.health = playerController.player.maxHealth;
        playerController.player.dash = false;
        playerController.player.gunIndex = 0;
        playerController.player.score = 0;
        //reload all gun in inventory.
        for (int i = 0; i < playerController.player.gunInventory.inventory.length; i++) {
            playerController.player.gunInventory.inventory[i].ammoCounter = playerController.player.gunInventory.inventory[i].mag;
        }
    }

    private void resetEnemy(Map map) {
        for (EnemySpawner spawner : enemyManager.enemySpawner) {
            spawner.map = map;
            spawner.enemy.clear();
        }
        enemyManager.allEnemy.clear();
    }

    private void resetPhysic(Map map) {
        physic.shooterPhysic.map = map;
        physic.ammoPhysic.map = map;
    }

    public void reset(Map map) {
        resetPhysic(map);
        resetPlayer(map);
        resetEnemy(map);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        playerController.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        playerController.keyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        playerController.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        playerController.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        playerController.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        playerController.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        playerController.mouseMoved(e);
    }

    private void handleCamera() {
        Player player = playerController.player;
        camera.x = player.x + player.size / 2 - 683;
        camera.y = player.y + player.size / 2 - 384;
    }

    public void handle() {
        playerController.handle(enemyManager.allEnemy);
        enemyManager.handle();
        physic.handle();
        handleCamera();
    }

    public void update() {
        playerController.update();
        enemyManager.update();
    }

    public void paint(Graphics g) {
        enemyManager.paint(g);
        playerController.paint(g);
    }
}
