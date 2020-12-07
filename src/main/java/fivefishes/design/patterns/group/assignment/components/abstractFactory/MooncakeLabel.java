package fivefishes.design.patterns.group.assignment.components.abstractFactory;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MooncakeLabel extends JLabel {
    private MooncakeDescriptionPanel mooncakeDescriptionPanel;

    public MooncakeLabel(MooncakeDescriptionPanel mooncakeDescriptionPanel) {
        this.mooncakeDescriptionPanel = mooncakeDescriptionPanel;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (mooncakeDescriptionPanel.isShowing()) {
                    mooncakeDescriptionPanel.setVisible(false);
                } else {
                    mooncakeDescriptionPanel.setVisible(true);
                }
            }
        });
    }
}
