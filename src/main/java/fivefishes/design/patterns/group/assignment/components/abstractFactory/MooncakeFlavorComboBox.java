package fivefishes.design.patterns.group.assignment.components.abstractFactory;

import fivefishes.design.patterns.group.assignment.controllers.abstractFactory.AbstractFactoryController;
import fivefishes.design.patterns.group.assignment.enumerations.abstractFactory.MooncakeFlavor;
import fivefishes.design.patterns.group.assignment.enumerations.abstractFactory.MooncakeStyle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MooncakeFlavorComboBox extends JComboBox<MooncakeFlavor> {

    private AbstractFactoryController abstractFactoryController;

    public MooncakeFlavorComboBox(AbstractFactoryController abstractFactoryController) {
        super(MooncakeFlavor.values());
        this.abstractFactoryController = abstractFactoryController;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MooncakeFlavor selectedFlavor = (MooncakeFlavor) getSelectedItem();
                abstractFactoryController.setFlavor(selectedFlavor);
            }
        });
    }
}
