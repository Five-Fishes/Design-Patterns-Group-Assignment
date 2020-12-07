package fivefishes.design.patterns.group.assignment.components.observer;

import fivefishes.design.patterns.group.assignment.enumerations.observer.RabbitImage;

import javax.swing.*;
import java.awt.*;

public class RabbitGifLabel extends JLabel {

    private  ImageIcon imageIcon;

    public RabbitGifLabel(RabbitImage rabbitImage) {
        this.imageIcon = new ImageIcon(rabbitImage.getImageUrl());
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(-1, 100, Image.SCALE_DEFAULT));
        super.setIcon(imageIcon);
        super.setVisible(false);
    }
}
