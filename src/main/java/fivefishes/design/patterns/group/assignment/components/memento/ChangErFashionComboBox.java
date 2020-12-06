package fivefishes.design.patterns.group.assignment.components.memento;

import fivefishes.design.patterns.group.assignment.controllers.memento.MementoController;
import fivefishes.design.patterns.group.assignment.enumerations.abstractFactory.MooncakeFlavor;
import fivefishes.design.patterns.group.assignment.enumerations.memento.Fashion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChangErFashionComboBox extends JComboBox<Fashion> {

    private MementoController mementoController;

    public ChangErFashionComboBox(MementoController mementoController) {
        super(Fashion.values());
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fashion selectedFashion = (Fashion) getSelectedItem();
                mementoController.changeFashion(selectedFashion);
            }
        });
    }
}
