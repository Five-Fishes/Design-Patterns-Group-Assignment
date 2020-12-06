package fivefishes.design.patterns.group.assignment.entities;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.JPanel;

public class image extends JPanel {
  private BufferedImage image;
  private int imageStartXaxis;
  private int imageStartYaxis;
  private final int buttonPanelHeight = 150;
  private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  public image(){
    presets();
  }

  private void presets() {
    try {
      image = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/background.jpg"));
    } catch (IOException ex) {
        ex.printStackTrace();
    }
  }

  public void paint(Graphics g) {
    super.paint(g);

    int imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
    Image resizedImage = image.getScaledInstance(-1, imageHeight, Image. SCALE_SMOOTH);

    imageStartXaxis = (int) (screenSize.getWidth() - resizedImage.getWidth(null)) / 2;
    imageStartYaxis = 10;
    g.drawImage(resizedImage, imageStartXaxis, imageStartYaxis, this);
  }
}
