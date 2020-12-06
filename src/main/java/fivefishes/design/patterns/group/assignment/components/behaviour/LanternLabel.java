package fivefishes.design.patterns.group.assignment.components.behaviour;

import fivefishes.design.patterns.group.assignment.entities.behaviour.Lantern;
import fivefishes.design.patterns.group.assignment.entities.behaviour.NoLight;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LanternLabel extends JLabel {

    Image resizedLanternImage = null;
    private Lantern lantern;
    private int lanternImageStartXaxis = 400;
    private int lanternImageStartYaxis = 200;

    public LanternLabel() {
        BufferedImage lanternImage = null;
        try {
            lanternImage = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/behaviour/green_lantern.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.lantern = new Lantern(lanternImage, new NoLight());
        Image resizedLanternImage = lantern.getBaseImage().getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(resizedLanternImage));
    }

//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        if (lantern != null) {
//            int lanternHeight = resizedLanternImage.getHeight(null);
//            int lanternWidth = resizedLanternImage.getWidth(null);
//            int lanternCenterX = lanternImageStartXaxis + lanternWidth / 2;
//            int lanternCenterY = lanternImageStartYaxis + lanternHeight / 2;
//            int lanternRadiusRatio = lantern.getLightRadiusRatio();
//            float lanternIntensity = lantern.getLightIntensity();
//            float[] Fractions = {0.5f, 1.0f};
//            Color[] Colors = {new Color(1f, 1f, 1f, lanternIntensity), new Color(1f, 1f, 0f, 0.0f)};
//            if (lanternRadiusRatio != 0) { //if dim light no repainting, else it will throw exception
//                Paint paint = new RadialGradientPaint(lanternCenterX, lanternCenterY, lanternWidth * lanternRadiusRatio / 2, Fractions, Colors);
//                Graphics2D g2 = (Graphics2D) g;
//                g2.setPaint(paint);
//                g2.fillOval(lanternCenterX - (lanternHeight * lanternRadiusRatio) / 2, lanternCenterY - (lanternHeight * lanternRadiusRatio) / 2, lanternHeight * lanternRadiusRatio, lanternHeight * lanternRadiusRatio);
//            }
//        }
//    } //paint

    public Lantern getLantern() {
        return lantern;
    }
}
