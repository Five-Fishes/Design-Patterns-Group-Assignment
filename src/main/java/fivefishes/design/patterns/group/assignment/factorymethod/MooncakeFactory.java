package fivefishes.design.patterns.group.assignment.factorymethod;

import java.awt.image.BufferedImage;

public interface MooncakeFactory {

    public Dough createDough();
    public Shape createShape();
    public RedBeanPaste createRedBeanPaste();
    public GreenTeaPaste createGreenTeaPaste();
    public LotusSeedPaste createLotusSeedPaste();
    public Yolk createYolk();
    public MooncakeImage createImage();
}
