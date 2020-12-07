package fivefishes.design.patterns.group.assignment.components.abstractFactory;

import fivefishes.design.patterns.group.assignment.controllers.abstractFactory.AbstractFactoryController;
import fivefishes.design.patterns.group.assignment.enumerations.abstractFactory.MooncakeStyle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MooncakeStyleComboBox extends JComboBox<MooncakeStyle> {

    private AbstractFactoryController abstractFactoryController;

    public MooncakeStyleComboBox(AbstractFactoryController abstractFactoryController) {
        super(MooncakeStyle.values());
        this.abstractFactoryController = abstractFactoryController;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MooncakeStyle selectedStyle = (MooncakeStyle) getSelectedItem();
                abstractFactoryController.setStyle(selectedStyle);
            }
        });
    }
}
