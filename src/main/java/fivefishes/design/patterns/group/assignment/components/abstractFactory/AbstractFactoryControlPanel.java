package fivefishes.design.patterns.group.assignment.components.abstractFactory;

import fivefishes.design.patterns.group.assignment.components.DesignPatternControlPanel;
import fivefishes.design.patterns.group.assignment.controllers.abstractFactory.AbstractFactoryController;

public class AbstractFactoryControlPanel extends DesignPatternControlPanel {

    private AbstractFactoryController abstractFactoryController;
    private MooncakeStyleComboBox mooncakeStyleComboBox;
    private MooncakeFlavorComboBox mooncakeFlavorComboBox;
    private AddMooncakeButton addMooncakeButton;

    public AbstractFactoryControlPanel(String title, AbstractFactoryController abstractFactoryController) {
        this(title, "", abstractFactoryController);
    }
    public AbstractFactoryControlPanel(String title, String description, AbstractFactoryController abstractFactoryController) {
        super(title, description);
        this.abstractFactoryController = abstractFactoryController;
        this.mooncakeStyleComboBox = new MooncakeStyleComboBox(abstractFactoryController);
        this.mooncakeFlavorComboBox = new MooncakeFlavorComboBox(abstractFactoryController);
        this.addMooncakeButton = new AddMooncakeButton(abstractFactoryController);
        this.add(mooncakeStyleComboBox);
        this.add(mooncakeFlavorComboBox);
        this.add(addMooncakeButton);
    }
}
