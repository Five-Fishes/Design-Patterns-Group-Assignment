package fivefishes.design.patterns.group.assignment.factorymethod;

import java.awt.image.BufferedImage;

public abstract class Mooncake {
    String name;

    MooncakeImage image;
    Dough dough;
    Shape shape;
    RedBeanPaste redBeanPaste;
    LotusSeedPaste lotusSeedPaste;
    GreenTeaPaste greenTeaPaste;
    Yolk yolk;

    public abstract void prepare();

    public void setName(String name){
        this.name = name;
    };

    public String getName(String name){
        return name;
    };

    public BufferedImage getImage() {
        return image.mooncakeImage;
    }

    public String getName() {
        return name;
    }

    public Dough getDough() {
        return dough;
    }

    public Shape getShape() {
        return shape;
    }

    public RedBeanPaste getRedBeanPaste() {
        return redBeanPaste;
    }

    public LotusSeedPaste getLotusSeedPaste() {
        return lotusSeedPaste;
    }

    public GreenTeaPaste getGreenTeaPaste() {
        return greenTeaPaste;
    }

    public Yolk getYolk() {
        return yolk;
    }
}
