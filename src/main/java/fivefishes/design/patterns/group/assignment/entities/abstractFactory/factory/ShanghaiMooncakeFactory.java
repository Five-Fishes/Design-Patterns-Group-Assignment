package fivefishes.design.patterns.group.assignment.entities.abstractFactory.factory;

import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.dough.Dough;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.dough.FlakyDough;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.fillings.SaltedEggYolk;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.fillings.Fillings;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.mooncakeImage.MooncakeImage;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.mooncakeImage.ShanghaiMooncakeImage;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.paste.*;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.shape.Shape;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.shape.SphericalShape;
import fivefishes.design.patterns.group.assignment.interfaces.abstractFactory.MooncakeFactory;

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