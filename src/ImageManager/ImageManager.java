package ImageManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageManager {
    public static Image getImage(String itemName) {
        Image image = null;
        try {
            switch (itemName) {
                case "Pistol M9":
                    image = ImageIO.read(new File("Image\\Gun\\Pistol-M9.png"));
                    break;
                case "Shotgun M2":
                    image = ImageIO.read(new File("Image\\Gun\\Shotgun-M2.png"));
                    break;
                case "Rifle M4":
                    image = ImageIO.read(new File("Image\\Gun\\Rifle-M4.png"));
                    break;
                case "Rifle AKM":
                    image = ImageIO.read(new File("Image\\Gun\\Rifle-AKM.png"));
                    break;
                case "Sniper AWM":
                    image = ImageIO.read(new File("Image\\Gun\\Sniper-AWM.png"));
                    break;
                case "Sniper Barrett":
                    image = ImageIO.read(new File("Image\\Gun\\Sniper-Barrett.png"));
                    break;

                case "Heart":
                    image = ImageIO.read(new File("Image\\Icon\\Heart.png"));
                    break;
                case "Ammo":
                    image = ImageIO.read(new File("Image\\Icon\\Ammo.png"));
                    break;
                case "Gun frame 0":
                    image = ImageIO.read(new File("Image\\Icon\\Gun-frame-0.png"));
                    break;
                case "Gun frame 1":
                    image = ImageIO.read(new File("Image\\Icon\\Gun-frame-1.png"));
                    break;

                case "Med kit":
                    image = ImageIO.read(new File("Image\\Health\\Med-kit.png"));
                    break;

                case "Number 0":
                    image = ImageIO.read(new File("Image\\Number\\Number-0.png"));
                    break;
                case "Number 1":
                    image = ImageIO.read(new File("Image\\Number\\Number-1.png"));
                    break;
                case "Number 2":
                    image = ImageIO.read(new File("Image\\Number\\Number-2.png"));
                    break;
                case "Number 3":
                    image = ImageIO.read(new File("Image\\Number\\Number-3.png"));
                    break;
                case "Number 4":
                    image = ImageIO.read(new File("Image\\Number\\Number-4.png"));
                    break;
                case "Number 5":
                    image = ImageIO.read(new File("Image\\Number\\Number-5.png"));
                    break;
                case "Number 6":
                    image = ImageIO.read(new File("Image\\Number\\Number-6.png"));
                    break;
                case "Number 7":
                    image = ImageIO.read(new File("Image\\Number\\Number-7.png"));
                    break;
                case "Number 8":
                    image = ImageIO.read(new File("Image\\Number\\Number-8.png"));
                    break;
                case "Number 9":
                    image = ImageIO.read(new File("Image\\Number\\Number-9.png"));
                    break;

                case "Start 0":
                    image = ImageIO.read(new File("Image\\Icon\\Start-0.png"));
                    break;
                case "Start 1":
                    image = ImageIO.read(new File("Image\\Icon\\Start-1.png"));
                    break;
                case "Triangle game":
                    image = ImageIO.read(new File("Image\\Icon\\Triangle-game.png"));
                    break;
                default:
                    return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
