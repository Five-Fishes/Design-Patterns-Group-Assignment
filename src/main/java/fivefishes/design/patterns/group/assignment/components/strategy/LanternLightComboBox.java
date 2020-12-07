package fivefishes.design.patterns.group.assignment.components.strategy;

import fivefishes.design.patterns.group.assignment.controllers.strategy.LightBehaviourController;
import fivefishes.design.patterns.group.assignment.enumerations.strategy.LightBrightness;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LanternLightComboBox extends JComboBox<LightBrightness> {

    private LightBehaviourController lightBehaviourController;

    public LanternLightComboBox(LightBehaviourController lightBehaviourController) {
        super(LightBrightness.values());
        this.lightBehaviourController = lightBehaviourController;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LightBrightness selectedLightBrightness = (LightBrightness) getSelectedItem();
                lightBehaviourController.setLightBehaviour(selectedLightBrightness);
            }
        });
    }
}
