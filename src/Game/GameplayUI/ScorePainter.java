package Game.GameplayUI;

import ImageManager.ImageManager;
import Shooter.Player.Player;

import java.awt.*;

public class ScorePainter {
    private final Player player;
    private int digitAmount;
    private static final int numWidth = 25;
    private static final int numLength = 45;
    private static final int space = 10;

    public ScorePainter(Player player) {
        this.player = player;
    }

    public void paint(Graphics g) {
        int lengthOfNumber = digitAmount * numWidth + space * (digitAmount - 1);
        for (int digit = 0; digit < digitAmount; digit++) {
            Image numImage = null;
            int x = 683 + lengthOfNumber / 2 - (digit + 1) * numWidth - digit * space;

            if (getValueOfDigit(digit) == 0) {
                numImage = ImageManager.getImage("Number 0");
            } else if (getValueOfDigit(digit) == 1) {
                numImage = ImageManager.getImage("Number 1");
            } else if (getValueOfDigit(digit) == 2) {
                numImage = ImageManager.getImage("Number 2");
            } else if (getValueOfDigit(digit) == 3) {
                numImage = ImageManager.getImage("Number 3");
            } else if (getValueOfDigit(digit) == 4) {
                numImage = ImageManager.getImage("Number 4");
            } else if (getValueOfDigit(digit) == 5) {
                numImage = ImageManager.getImage("Number 5");
            } else if (getValueOfDigit(digit) == 6) {
                numImage = ImageManager.getImage("Number 6");
            } else if (getValueOfDigit(digit) == 7) {
                numImage = ImageManager.getImage("Number 7");
            } else if (getValueOfDigit(digit) == 8) {
                numImage = ImageManager.getImage("Number 8");
            } else if (getValueOfDigit(digit) == 9) {
                numImage = ImageManager.getImage("Number 9");
            }

            g.drawImage(numImage, x, 50, numWidth, numLength, null);
        }
    }

    private int getValueOfDigit(int digit) {
        //digit's order goes from left to right.
        int score = player.score;
        for (int i = 0; i <= digit; i++) {
            score -= score % Math.pow(10, i);
        }
        return (int) ((score / Math.pow(10, digit)) % 10);
    }

    public void handle() {
        digitAmount = String.valueOf(player.score).length();
    }
}
