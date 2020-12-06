package fivefishes.design.patterns.group.assignment.controllers.decorator;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

import fivefishes.design.patterns.group.assignment.entities.decorator.FireworkDecorator;
import fivefishes.design.patterns.group.assignment.entities.decorator.FlagsDecorator;
import fivefishes.design.patterns.group.assignment.entities.decorator.House;
import fivefishes.design.patterns.group.assignment.entities.decorator.LanternDecorator;
import fivefishes.design.patterns.group.assignment.entities.decorator.CandlesDecorator;
import fivefishes.design.patterns.group.assignment.interfaces.decorator.IDecoratable;

public class HouseController {
    private static int order = 201;
    private IDecoratable house;
    private JLayeredPane jLayeredPane;
    private JFrame jFrame;

    public HouseController(JLayeredPane jLayeredPane, IDecoratable house, JFrame jFrame) {
        this.jLayeredPane = jLayeredPane;
        this.house = house;
        this.jFrame = jFrame;
    }

    public void onDecorationSelected(String decoratorName) {
        /**
         * create new decorator instance and wrap house within
         * example:
         *   house = new lanternDecorator(house);
         */
        switch (decoratorName.toLowerCase()) {
            case "lanterndecorator":

                house = new LanternDecorator(house);
                break;
            case "fireworkdecorator":

                house = new FireworkDecorator(house);
                break;
            case "candlesdecorator":

                house = new CandlesDecorator(house);
                break;
            case "flagsdecorator":

                house = new FlagsDecorator(house);
                break;
            default:
                break;
        }
    }

    public void onApplyDecoratorClicked() {
        if (house.getImages().size() == 1) {
            showMessageDialog(jFrame, "No decoration selected");
        } else {
            applyDecorations();
        }
    }

    public void onClearDecorationsClicked() {
        if (house.getImages().size() == 1) {
            showMessageDialog(jFrame, "No decoration to clear!");
        } else {
            jLayeredPane.removeAll();
            this.house = new House();
            applyDecorations();
        }

    }

    private void applyDecorations() {
        jLayeredPane.removeAll();
        /* Do layers composing */
        ArrayList<JLabel> labels = house.getImages();
        for (int i = labels.size(); i > 0; i--) {
            JLabel templbl = labels.get(i - 1);
            Random r = new Random();

            int x_position = i == labels.size() ? 0 : r.nextInt(60) - 30;

            templbl.setBounds(x_position, 0, 300, 300);
            jLayeredPane.setLayer(templbl, order += 1);
            jLayeredPane.add(templbl);
        }

        /* Repaint the specified region */
        jLayeredPane.repaint();
    }
}
