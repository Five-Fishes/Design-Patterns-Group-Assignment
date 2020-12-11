package fivefishes.design.patterns.group.assignment.components.strategy;

import fivefishes.design.patterns.group.assignment.entities.strategy.Lantern;
import fivefishes.design.patterns.group.assignment.entities.strategy.NoLight;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LanternLabel extends JComponent {

    Image resizedLanternImage = null;
    private Lantern lantern;

    public LanternLabel() {
        BufferedImage lanternImage = null;
        try {
            lanternImage = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/strategy/green_lantern.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.lantern = new Lantern(new NoLight());
        resizedLanternImage = lanternImage.getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
    }

    @Override
    public void paintComponent(Graphics g) {
        if (resizedLanternImage != null) {
            float lanternIntensity = lantern.getLightIntensity();
            Graphics2D g2 = (Graphics2D) g;
            int start = (int)(lanternIntensity/0.02f)-1;
            for(int i = start; i > 0 ; i--){ //use for loop to paint from big circle to the smallest circle to imitate light
                g2.setColor(new Color(1f, 1f, 1f, 0.02f));
                g2.fillOval(47-(i*2), 65-(i*2), 50+(i*2*2), 50+(i*2*2));
            }
        }
        g.drawImage(resizedLanternImage, 50, 50, this);
        revalidate();
        super.paintComponent(g);
    } //paint

    public Lantern getLantern() {
        return lantern;
    }
}
