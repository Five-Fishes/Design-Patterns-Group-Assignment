package fivefishes.design.patterns.group.assignment.entities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fivefishes.design.patterns.group.assignment.entities.enums.StaticResources;
import fivefishes.design.patterns.group.assignment.interfaces.IDecoratable;

public class house implements IDecoratable {
    private BufferedImage image;
    private JLabel imagelbl;

    public house() {
    }

    @Override
    public ArrayList<JLabel> getImages() {
        try {
            image = ImageIO.read(new File(StaticResources.DefaultHouse.label));
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
