package Window;

import Game.Game;

import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        Game game = new Game();
        add(game);
        setTitle("Triangle game");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}
