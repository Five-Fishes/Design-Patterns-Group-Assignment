package fivefishes.design.patterns.group.assignment.components.decorator;

import fivefishes.design.patterns.group.assignment.controllers.HouseController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecoratorComboBox extends JComboBox<String> {

    private static final String[] decoratorOptions = {
            "lantern decorator",
            "firework decorator",
            "candles decorator",
            "flags decorator"
    };
    private HouseController houseController;

    public DecoratorComboBox(HouseController houseController) {
        super(decoratorOptions);
        this.houseController = houseController;
        this.setSelectedIndex(0);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> cb = (JComboBox<String>) e.getSource();
                String decoratorName = (String) cb.getSelectedItem();
                String selected = decoratorName.replace(" ", "");
                houseController.onDecorationSelected(selected);
            }
        });

    }

}
