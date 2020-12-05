package fivefishes.design.patterns.group.assignment.factorymethod.factory;

import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.dough.Dough;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.dough.TenderDough;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.fillings.MelonSeeds;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.fillings.SaltedEggYolk;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.fillings.Fillings;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.mooncakeImage.CantoneseMooncakeImage;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.mooncakeImage.MooncakeImage;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.paste.*;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.shape.RoundShape;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.shape.Shape;

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
        return new CantoneseMooncakeImage();
    }
}