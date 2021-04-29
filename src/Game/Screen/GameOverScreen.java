package Game.Screen;

import ImageManager.ImageManager;
import Game.Button;

import javax.swing.*;
import java.awt.*;

public class GameOverScreen extends JPanel {
    private final Button backToMenu;

    public GameOverScreen() {
        backToMenu = new Button(ImageManager.getImage("Back-to-menu-0"), ImageManager.getImage("Back-to-menu-1"), 383, 400, 600, 40);
    }

    private void paintTitle(Graphics g) {
        g.drawImage(ImageManager.getImage("Game over"), 333, 50, 600, 100, null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.BLACK);
        paintTitle(g);
        backToMenu.paint(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GameOverScreen screen = new GameOverScreen();
        frame.add(screen);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
