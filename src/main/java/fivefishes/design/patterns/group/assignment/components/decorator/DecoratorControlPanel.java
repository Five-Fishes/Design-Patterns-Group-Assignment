package fivefishes.design.patterns.group.assignment.components.decorator;

import fivefishes.design.patterns.group.assignment.components.DesignPatternControlPanel;
import fivefishes.design.patterns.group.assignment.controllers.decorator.HouseController;

public class DecoratorControlPanel extends DesignPatternControlPanel {
    private HouseController houseController;
    private DecoratorComboBox decoratorComboBox;
    private ApplyDecorationButton applyDecorationButton;
    private ClearDecorationButton clearDecorationButton;

    public DecoratorControlPanel(String title, HouseController houseController) {
        this(title, "", houseController);
    }

    public DecoratorControlPanel(String title, String description, HouseController houseController) {
        super(title, description);
        this.houseController = houseController;
        this.clearDecorationButton = new ClearDecorationButton(houseController);
        this.applyDecorationButton = new ApplyDecorationButton(houseController);
        this.decoratorComboBox = new DecoratorComboBox(houseController);
        this.add(clearDecorationButton);
        this.add(applyDecorationButton);
        this.add(decoratorComboBox);
    }
}
