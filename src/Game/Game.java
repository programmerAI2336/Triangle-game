package Game;

import Camera.Camera;
import Game.GameplayUI.GamePlayUI;
import Game.Screen.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener, ActionListener, MouseMotionListener, MouseListener {
    private final Camera camera = new Camera();
    private final MapManager mapManager = new MapManager(camera);
    private final Menu menu = new Menu();
    private final GamePlay gamePlay = new GamePlay(camera);
    private final GamePlayUI gamePlayUI = new GamePlayUI(gamePlay.playerController);

    public Game() {
        gamePlay.reset(mapManager.getMap(0));

        addKeyListener(this);
        setFocusable(true);
        addMouseMotionListener(this);
        addMouseListener(this);
        Timer timer = new Timer(4, this);
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (menu.start.clicked) {
            gamePlay.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (menu.start.clicked) {
            gamePlay.keyReleased(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!menu.start.clicked) {
           menu.mouseDragged(e);
        } else {
            gamePlay.mouseDragged(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (!menu.start.clicked) {
            menu.mouseMoved(e);
        } else {
            gamePlay.mouseMoved(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!menu.start.clicked) {
           menu.mousePressed(e);
        } else {
            gamePlay.mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!menu.start.clicked) {
            menu.mouseReleased(e);
        } else {
            gamePlay.mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (!menu.start.clicked) {
            menu.mouseEntered(e);
        } else {
            gamePlay.mouseEntered(e);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!menu.start.clicked) {
            menu.actionPerformed(e);
        } else {
            gamePlay.handle();
            gamePlayUI.handle();
            mapManager.update();
            gamePlay.update();
        }
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.BLACK);
        if (!menu.start.clicked) {
            menu.paint(g);
        } else {
            mapManager.paint(g);
            gamePlay.paint(g);
            gamePlayUI.paint(g);
        }
    }
}

