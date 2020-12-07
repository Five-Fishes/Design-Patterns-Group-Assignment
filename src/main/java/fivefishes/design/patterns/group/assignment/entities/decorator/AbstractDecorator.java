package fivefishes.design.patterns.group.assignment.entities.decorator;

import javax.swing.JLabel;
import java.awt.image.BufferedImage;

import fivefishes.design.patterns.group.assignment.interfaces.decorator.IDecoratable;

public abstract class AbstractDecorator extends JLabel implements IDecoratable {
  protected IDecoratable wrappee;
  protected BufferedImage image;
}
