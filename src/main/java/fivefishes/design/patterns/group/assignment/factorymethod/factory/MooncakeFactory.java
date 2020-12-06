package fivefishes.design.patterns.group.assignment.factorymethod.factory;

import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.dough.Dough;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.fillings.Fillings;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.mooncakeImage.MooncakeImage;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.paste.GreenTeaPaste;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.paste.LotusSeedPaste;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.paste.RedBeanPaste;
import fivefishes.design.patterns.group.assignment.factorymethod.ingredient.shape.Shape;

public interface MooncakeFactory {

    public Dough createDough();
    public Shape createShape();
    public RedBeanPaste createRedBeanPaste();
    public GreenTeaPaste createGreenTeaPaste();
    public LotusSeedPaste createLotusSeedPaste();
    public Fillings createFillings();
    public MooncakeImage createImage();
}
