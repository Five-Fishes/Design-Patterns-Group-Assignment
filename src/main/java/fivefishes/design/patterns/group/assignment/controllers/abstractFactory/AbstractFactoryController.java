package fivefishes.design.patterns.group.assignment.controllers.abstractFactory;

import fivefishes.design.patterns.group.assignment.entities.abstractFactory.mooncake.LotusSeedMooncake;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.mooncake.Mooncake;
import fivefishes.design.patterns.group.assignment.components.abstractFactory.MooncakeDescriptionPanel;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.factory.TraditionalMooncakeFactory;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.mooncake.RedBeanMooncake;
import fivefishes.design.patterns.group.assignment.enumerations.abstractFactory.MooncakeFlavor;
import fivefishes.design.patterns.group.assignment.enumerations.abstractFactory.MooncakeStyle;
import fivefishes.design.patterns.group.assignment.interfaces.abstractFactory.MooncakeFactory;

import javax.swing.*;
import java.awt.*;

public class AbstractFactoryController {

    private Mooncake mooncake = new RedBeanMooncake();
    private MooncakeFactory mooncakeFactory = new TraditionalMooncakeFactory();
    private MooncakeStyle mooncakeStyle = MooncakeStyle.Traditional;
    private MooncakeFlavor mooncakeFlavor = MooncakeFlavor.RedBean;
    private MooncakeDescriptionPanel mooncakeDescriptionPanel;
    private JLabel mooncakeLabel;
    private JFrame jFrame;

    public AbstractFactoryController(MooncakeDescriptionPanel mooncakeDescriptionPanel, JLabel mooncakeLabel, JFrame jFrame) {
        this.mooncakeDescriptionPanel = mooncakeDescriptionPanel;
        this.mooncakeLabel = mooncakeLabel;
        this.jFrame = jFrame;
    }

    public void createMooncake() {
        mooncake.setName(mooncakeStyle.name() + " " + mooncakeFlavor.getValue() + " mooncake");
        mooncake.setFactory(mooncakeFactory);
        mooncake.prepare();
        Image resizedMooncakeImage = mooncake.getImage().getScaledInstance(207, 53, Image.SCALE_SMOOTH);
        mooncakeLabel.setIcon(new ImageIcon(resizedMooncakeImage));
        mooncakeDescriptionPanel.setLabel(mooncake);
        jFrame.repaint();
    }

    public void setStyle(MooncakeStyle selectedStyle) {
        mooncakeStyle = selectedStyle;
        mooncakeFactory = selectedStyle.getMooncakeFactory();
    }

    public void setFlavor(MooncakeFlavor selectedFlavor) {
        mooncakeFlavor = selectedFlavor;
        if (selectedFlavor.equals(MooncakeFlavor.LotusSeed)) {
            mooncake = new LotusSeedMooncake();
        } else if (selectedFlavor.equals(MooncakeFlavor.RedBean)) {
            mooncake = new RedBeanMooncake();
        }
    }

}
