package fivefishes.design.patterns.group.assignment.components.memento;

import fivefishes.design.patterns.group.assignment.components.DesignPatternControlPanel;
import fivefishes.design.patterns.group.assignment.controllers.memento.MementoController;

public class MementoControlPanel extends DesignPatternControlPanel {
    private MementoController mementoController;
    private UndoButton undoButton;
    private RedoButton redoButton;
    private ChangErFashionComboBox changErFashionComboBox;

    public MementoControlPanel(String title, MementoController mementoController) {
        this(title, "", mementoController);
    }

    public MementoControlPanel(String title, String description, MementoController mementoController) {
        super(title, description);
        this.mementoController = mementoController;
        this.undoButton = new UndoButton(mementoController);
        this.redoButton = new RedoButton(mementoController);
        this.changErFashionComboBox = new ChangErFashionComboBox(mementoController);
        this.add(undoButton);
        this.add(redoButton);
        this.add(changErFashionComboBox);
    }
}
