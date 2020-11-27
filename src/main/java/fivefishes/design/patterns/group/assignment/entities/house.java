package fivefishes.design.patterns.group.assignment.entities;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLayeredPane;

import fivefishes.design.patterns.group.assignment.interfaces.IDecoratable;

public class house extends JLayeredPane implements IDecoratable{
    public house(){
        presets();
    }

    @Override
    public void decorate() {
        // TODO Auto-generated method stub

    }

    private void presets(){
        setPreferredSize(new Dimension(300,300));
        setOpaque(true);
        setLocation(0, 0);
        setBackground(Color.BLACK);
    }
}
