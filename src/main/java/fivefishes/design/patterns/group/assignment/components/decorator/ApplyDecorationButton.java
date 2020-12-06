package fivefishes.design.patterns.group.assignment.components.decorator;

import fivefishes.design.patterns.group.assignment.controllers.decorator.HouseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyDecorationButton extends JButton {

    private HouseController houseController;

    public ApplyDecorationButton(HouseController houseController) {
        this.houseController = houseController;
        this.setText("Apply Decoration");
        this.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        this.setBackground(Color.BLUE);
        this.setForeground(Color.WHITE);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                houseController.onApplyDecoratorClicked();
            }
        });
    }
}
