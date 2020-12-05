package fivefishes.design.patterns.group.assignment.factorymethod.factory;

import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.dough.Dough;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.dough.FlakyDough;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.fillings.SaltedEggYolk;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.fillings.Fillings;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.mooncakeImage.MooncakeImage;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.mooncakeImage.ShanghaiMooncakeImage;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.paste.*;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.shape.Shape;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.shape.SphericalShape;

public class ShanghaiMooncakeFactory implements MooncakeFactory {
    @Override
    public Dough createDough() {
        return new FlakyDough();
    }

    @Override
    public Shape createShape() {
        return new SphericalShape();
    }

    @Override
    public RedBeanPaste createRedBeanPaste() {
        return new RedBean();
    }

    @Override
    public GreenTeaPaste createGreenTeaPaste() {
        return new GreenTea();
    }

    @Override
    public LotusSeedPaste createLotusSeedPaste() {
        return new LotusSeed();
    }

    @Override
    public Fillings createFillings() {
        return new SaltedEggYolk();
    }

    @Override
    public MooncakeImage createImage() {
        return new ShanghaiMooncakeImage();
    }

}