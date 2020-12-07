package fivefishes.design.patterns.group.assignment.controllers.memento;

import fivefishes.design.patterns.group.assignment.entities.memento.ChangErFashion;
import fivefishes.design.patterns.group.assignment.entities.memento.History;
import fivefishes.design.patterns.group.assignment.enumerations.memento.Fashion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MementoController {

    private ChangErFashion changErFashion = new ChangErFashion();
    private History changeErFashionHistory = new History();
    private BufferedImage changErImage;
    private JLabel changErLabel;

    public MementoController(JLabel changErLabel) {
        this.changErLabel = changErLabel;
        changErFashion.setFashionType(Fashion.White.name());
        changeErFashionHistory.add(changErFashion.createMemento());
        setChangErImage();
        changErLabel.repaint();
    }

    public void undo() {
        changErFashion.getFromChangErMemento(changeErFashionHistory.undo());
        setChangErImage();
        changErLabel.repaint();
    }

    public void redo() {
        changErFashion.getFromChangErMemento(changeErFashionHistory.redo());
        setChangErImage();
        changErLabel.repaint();
    }

    public void changeFashion(Fashion fashion) {
        changErFashion.setFashionType(fashion.name());
        changeErFashionHistory.add(changErFashion.createMemento());
        setChangErImage();
        changErLabel.repaint();
    }

    private void setChangErImage() {
        try {
            changErImage = ImageIO.read(new File(changErFashion.getChangErImageUrl()));
            Image resizedChangErImage = changErImage.getScaledInstance(-1, 180, Image.SCALE_SMOOTH);
            changErLabel.setIcon(new ImageIcon(resizedChangErImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
