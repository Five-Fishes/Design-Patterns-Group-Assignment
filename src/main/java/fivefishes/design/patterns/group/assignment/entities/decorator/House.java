package fivefishes.design.patterns.group.assignment.entities.decorator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fivefishes.design.patterns.group.assignment.interfaces.decorator.IDecoratable;

public class House implements IDecoratable {
    private BufferedImage image;
    private JLabel imagelbl;

    @Override
    public ArrayList<JLabel> getImages() {
        try {
            image = ImageIO.read(new File(fivefishes.design.patterns.group.assignment.enumerations.decorator.House.DefaultHouse.getImageUrl()));
            int imageHeight = 300;
            Image resizedImage = image.getScaledInstance(-1, imageHeight, Image.SCALE_SMOOTH);
            imagelbl = new JLabel(new ImageIcon(resizedImage));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        imagelbl.setBounds(0, 0, 300, 300);
        return new ArrayList<JLabel>(Arrays.asList(imagelbl));
    }
}
