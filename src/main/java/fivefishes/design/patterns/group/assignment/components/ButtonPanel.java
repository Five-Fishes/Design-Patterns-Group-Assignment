package fivefishes.design.patterns.group.assignment.components;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ButtonPanel extends JPanel {

    public ButtonPanel(List<DesignPatternControlPanel> decoratorControlPanels, Dimension dimension) {
        this.setBackground(Color.white);
        this.setPreferredSize(dimension);
        this.setLayout(new GridLayout(0,5));
        this.setBorder(BorderFactory.createEmptyBorder(8,32,8,32));
        decoratorControlPanels.forEach(this::add);
    }
}
