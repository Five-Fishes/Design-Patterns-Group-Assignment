package fivefishes.design.patterns.group.assignment.components.strategy;

import fivefishes.design.patterns.group.assignment.components.DesignPatternControlPanel;
import fivefishes.design.patterns.group.assignment.controllers.strategy.LightBehaviourController;

public class StrategyControlPanel extends DesignPatternControlPanel {
    private LightBehaviourController lightBehaviourController;
    private LanternLightComboBox lanternLightComboBox;

    public StrategyControlPanel(String title, LightBehaviourController lightBehaviourController) {
        this(title, "", lightBehaviourController);
    }

    public StrategyControlPanel(String title, String description, LightBehaviourController lightBehaviourController) {
        super(title, description);
        this.lightBehaviourController = lightBehaviourController;
        this.lanternLightComboBox = new LanternLightComboBox(lightBehaviourController);
        this.add(lanternLightComboBox);
    }
}
