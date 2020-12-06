package fivefishes.design.patterns.group.assignment.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TableLabel extends JLabel {
    public TableLabel() {
        Image tableImage = null;
        try {
            tableImage = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/abstractFactory/table.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image resizedTableImage = tableImage.getScaledInstance(260, 178, Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(resizedTableImage));
    }
}
