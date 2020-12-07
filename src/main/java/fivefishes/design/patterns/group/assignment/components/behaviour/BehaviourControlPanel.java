package fivefishes.design.patterns.group.assignment.components.behaviour;

import fivefishes.design.patterns.group.assignment.components.DesignPatternControlPanel;
import fivefishes.design.patterns.group.assignment.controllers.behaviour.LightBehaviourController;

public class BehaviourControlPanel extends DesignPatternControlPanel {
    private LightBehaviourController lightBehaviourController;
    private LanternLightComboBox lanternLightComboBox;

    public BehaviourControlPanel(String title, LightBehaviourController lightBehaviourController) {
        this(title, "", lightBehaviourController);
    }

    public BehaviourControlPanel(String title, String description, LightBehaviourController lightBehaviourController) {
        super(title, description);
        this.lightBehaviourController = lightBehaviourController;
        this.lanternLightComboBox = new LanternLightComboBox(lightBehaviourController);
        this.add(lanternLightComboBox);
    }
}
