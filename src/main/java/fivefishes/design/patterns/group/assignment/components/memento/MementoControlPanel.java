package fivefishes.design.patterns.group.assignment.components.memento;

import fivefishes.design.patterns.group.assignment.components.DesignPatternControlPanel;
import fivefishes.design.patterns.group.assignment.controllers.memento.MementoController;

import javax.swing.*;
import java.awt.*;

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
        JComponent sideBySideBtnPanel = new JPanel();
        sideBySideBtnPanel.setLayout(new BoxLayout(sideBySideBtnPanel, BoxLayout.LINE_AXIS));
        sideBySideBtnPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        this.undoButton = new UndoButton(mementoController);
        this.redoButton = new RedoButton(mementoController);
        this.changErFashionComboBox = new ChangErFashionComboBox(mementoController);
        this.add(changErFashionComboBox);
        sideBySideBtnPanel.add(undoButton);
        sideBySideBtnPanel.add(redoButton);
        this.add(sideBySideBtnPanel);
    }
}
