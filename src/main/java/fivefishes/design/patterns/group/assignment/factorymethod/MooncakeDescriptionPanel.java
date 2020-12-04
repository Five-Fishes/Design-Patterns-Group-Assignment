package fivefishes.design.patterns.group.assignment.factorymethod;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.*;

public class MooncakeDescriptionPanel extends JPanel {
    private JLabel titleLabel = new JLabel();
    private JLabel nameLabel = new JLabel();
    private JLabel shapeLabel = new JLabel();
    private JLabel doughLabel = new JLabel();
    private JLabel pasteLabel = new JLabel();
    private JLabel yolkLabel = new JLabel();

    public MooncakeDescriptionPanel(){
        titleLabel.setText("Mooncake Details");
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(nameLabel);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(shapeLabel);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(doughLabel);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(pasteLabel);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(yolkLabel );
        setFonts();
    }

    public void setLabel(Mooncake mooncake){
        nameLabel.setText("Name: " + mooncake.getName());
        shapeLabel.setText("Shape: " + mooncake.getShape().toString());
        doughLabel.setText("Dough: " + mooncake.getDough().toString());
        if (mooncake.getRedBeanPaste() == null){
            pasteLabel.setText("Paste Flavour: " + mooncake.getLotusSeedPaste().toString());
        } else {
            pasteLabel.setText("Paste Flavour: " + mooncake.getRedBeanPaste().toString());
        }

        yolkLabel.setText("Fillings: " + mooncake.getYolk().toString());
    }

    public void setFonts(){
        titleLabel.setFont(new Font(SANS_SERIF, BOLD, 28));
        nameLabel.setFont(new Font(SANS_SERIF, PLAIN, 24));
        shapeLabel.setFont(new Font(SANS_SERIF, PLAIN, 24));
        pasteLabel.setFont(new Font(SANS_SERIF, PLAIN, 24));
        doughLabel.setFont(new Font(SANS_SERIF, PLAIN, 24));
        yolkLabel.setFont(new Font(SANS_SERIF, PLAIN, 24));
    }
}
