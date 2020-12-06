package fivefishes.design.patterns.group.assignment.components.memento;

import fivefishes.design.patterns.group.assignment.controllers.memento.MementoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedoButton extends JButton {

    private MementoController mementoController;

    public RedoButton(MementoController mementoController) {
        this.mementoController = mementoController;
        this.setText("Redo");
        this.setBackground(Color.green);
        this.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        this.setForeground(Color.white);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mementoController.redo();
            }
        });
    }
}
