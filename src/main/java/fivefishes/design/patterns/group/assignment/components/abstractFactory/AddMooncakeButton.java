package fivefishes.design.patterns.group.assignment.components.abstractFactory;

import fivefishes.design.patterns.group.assignment.controllers.abstractFactory.AbstractFactoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class AddMooncakeButton extends JButton {

    private AbstractFactoryController abstractFactoryController;

    public AddMooncakeButton(AbstractFactoryController abstractFactoryController) {
        this.abstractFactoryController = abstractFactoryController;
        this.setText("Create Mooncake");
        this.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        this.setBackground(Color.red);
        this.setForeground(Color.white);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abstractFactoryController.createMooncake();
            }
        });
    }
}
