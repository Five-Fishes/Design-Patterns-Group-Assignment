package fivefishes.design.patterns.group.assignment.entities.abstractFactory.factory;

import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.dough.Dough;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.dough.TenderDough;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.fillings.MelonSeeds;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.fillings.Fillings;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.mooncakeImage.TraditionalMooncakeImage;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.mooncakeImage.MooncakeImage;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.paste.*;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.shape.RoundShape;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.shape.Shape;
import fivefishes.design.patterns.group.assignment.interfaces.abstractFactory.MooncakeFactory;

public class TraditionalMooncakeFactory implements MooncakeFactory {
    @Override
    public Dough createDough() {
        return new TenderDough();
    }

    @Override
    public Shape createShape() {
        return new RoundShape();
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
        return new MelonSeeds();
    }

    @Override
    public MooncakeImage createImage() {
        return new TraditionalMooncakeImage();
    }
}