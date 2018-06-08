package render;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class BackgroundComponent extends JComponent {

    public BufferedImage backgroundImage;

    public BackgroundComponent() {
        super();
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(1000, 1000));

        try {
            backgroundImage = ImageIO.read(new File("forest.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(backgroundImage, 0, 0, 1000, 1000, null);
    }

}