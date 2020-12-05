package fivefishes.design.patterns.group.assignment.entities;

import fivefishes.design.patterns.group.assignment.entities.enums.StaticResources;
import fivefishes.design.patterns.group.assignment.interfaces.IDecoratable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class lanternDecorator extends abstractDecorator {

  public lanternDecorator(IDecoratable wrappee) {
    super.wrappee = wrappee;
  }

  @Override
  public ArrayList<JLabel> getImages() {
    try {
      Image resizedImage;
      image = ImageIO.read(new File(StaticResources.LanternsDecorator.label));
      int imageHeight = 300;
      resizedImage = image.getScaledInstance(-1, imageHeight, Image.SCALE_SMOOTH);
      ArrayList<JLabel> result_arr = new ArrayList<JLabel>(Arrays.asList(new JLabel(new ImageIcon(resizedImage))));
      result_arr.addAll(wrappee.getImages());
      return result_arr;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
