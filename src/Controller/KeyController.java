package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Shooter.Player.Player;

public class KeyController implements KeyListener {
    private boolean goLeft, goRight, goUp, goDown;
    private boolean dash;

    private boolean nextGun, previousGun;
    private int ePressedTimer, qPressedTimer;

    public final int[] gunIndexContainer;
    private int index;

    private final Player player;

    public KeyController(Player player, int[] allGunIndex) {
        this.player = player;
        this.gunIndexContainer = allGunIndex;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            goRight = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            goLeft = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            goUp = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            goDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            dash = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_E) {
            nextGun = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            previousGun = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            goRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            goLeft = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            goUp = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            goDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            dash = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_E) {
            nextGun = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            previousGun = false;
        }
    }

    private void handleMoveKey() {
        if (!player.dash) {
            if (goUp) {
                player.velY = -player.speed;
            } else if (goDown) {
                player.velY = player.speed;
            } else {
                player.velY = 0;
            }
            if (goLeft) {
                player.velX = -player.speed;
            } else if (goRight) {
                player.velX = player.speed;
            } else {
                player.velX = 0;
            }
        }
    }

    private void handleDashKey() {
        if (dash) {
            if (player.dashTimer == 1075) {
                player.dash = true;
            }
        }
    }

    private void handleNextGun() {
        if (nextGun) {
            ePressedTimer++;
        } else {
            ePressedTimer = 0;
        }
        if (ePressedTimer == 10) {
            if (index < gunIndexContainer.length - 1) {
                index++;
            } else {
                index = 0;
            }
        }

    }

    private void handlePreviousGun() {
        if (previousGun) {
            qPressedTimer++;
        } else {
            qPressedTimer = 0;
        }

        if (qPressedTimer == 10) {
            if(index > 0) {
                index--;
            } else {
                index = gunIndexContainer.length - 1;
            }
        }
    }

    public void handleEvent() {
        handleDashKey();
        handleMoveKey();
        handleNextGun();
        handlePreviousGun();
        player.gunIndex = gunIndexContainer[index];
    }
}
