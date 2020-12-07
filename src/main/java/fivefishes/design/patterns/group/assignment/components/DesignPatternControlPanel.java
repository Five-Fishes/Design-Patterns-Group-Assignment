package fivefishes.design.patterns.group.assignment.components;

import fivefishes.design.patterns.group.assignment.components.memento.UndoButton;
import fivefishes.design.patterns.group.assignment.controllers.memento.MementoController;

import javax.swing.*;
import java.awt.*;

public abstract class DesignPatternControlPanel extends JPanel {

    public DesignPatternControlPanel(String title, String description) {
        this.setBackground(Color.orange);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE,8));
        this.add(new JLabel(title));
        this.add(new JLabel(description));
    }
}
