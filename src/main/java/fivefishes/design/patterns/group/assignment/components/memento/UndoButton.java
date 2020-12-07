package fivefishes.design.patterns.group.assignment.components.memento;

import fivefishes.design.patterns.group.assignment.controllers.memento.MementoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndoButton extends JButton {

    private MementoController mementoController;

    public UndoButton(MementoController mementoController) {
        this.mementoController = mementoController;
        this.setText("Undo");
        this.setBackground(Color.red);
        this.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        this.setForeground(Color.white);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mementoController.undo();
            }
        });
    }
}
