package fivefishes.design.patterns.group.assignment.entities.abstractFactory.mooncake;

import fivefishes.design.patterns.group.assignment.interfaces.abstractFactory.MooncakeFactory;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.dough.Dough;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.fillings.Fillings;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.mooncakeImage.MooncakeImage;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.paste.GreenTeaPaste;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.paste.LotusSeedPaste;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.paste.RedBeanPaste;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.shape.Shape;

import java.awt.image.BufferedImage;

public abstract class Mooncake {
    String name;
    MooncakeFactory mooncakeFactory;
    MooncakeImage image;
    Dough dough;
    Shape shape;
    RedBeanPaste redBeanPaste;
    LotusSeedPaste lotusSeedPaste;
    GreenTeaPaste greenTeaPaste;
    Fillings yolk;


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

    public Fillings getYolk() {
        return yolk;
    }

    public void setFactory(MooncakeFactory mooncakeFactory){
        this.mooncakeFactory = mooncakeFactory;
    }
}
