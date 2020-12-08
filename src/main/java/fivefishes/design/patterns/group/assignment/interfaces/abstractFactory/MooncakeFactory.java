package fivefishes.design.patterns.group.assignment.interfaces.abstractFactory;

import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.dough.Dough;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.fillings.Fillings;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.mooncakeImage.MooncakeImage;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.paste.LotusSeedPaste;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.paste.RedBeanPaste;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.shape.Shape;

public interface MooncakeFactory {

    public Dough createDough();
    public Shape createShape();
    public RedBeanPaste createRedBeanPaste();
    public LotusSeedPaste createLotusSeedPaste();
    public Fillings createFillings();
    public MooncakeImage createImage();
}
