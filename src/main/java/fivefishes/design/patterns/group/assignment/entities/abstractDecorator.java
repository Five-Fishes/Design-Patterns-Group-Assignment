package fivefishes.design.patterns.group.assignment.entities;

import javax.swing.JLabel;
import java.awt.image.BufferedImage;

import fivefishes.design.patterns.group.assignment.interfaces.IDecoratable;

public abstract class abstractDecorator extends JLabel implements IDecoratable {
  protected IDecoratable wrappee;
  protected BufferedImage image;
}
