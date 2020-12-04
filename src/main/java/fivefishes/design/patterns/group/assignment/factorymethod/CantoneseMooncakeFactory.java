package fivefishes.design.patterns.group.assignment.factorymethod;

public class CantoneseMooncakeFactory implements MooncakeFactory{
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
    public Yolk createYolk() {
        return new SaltedEggYolk();
    }

    @Override
    public MooncakeImage createImage() {
        return new CantoneseMooncakeImage();
    }
}