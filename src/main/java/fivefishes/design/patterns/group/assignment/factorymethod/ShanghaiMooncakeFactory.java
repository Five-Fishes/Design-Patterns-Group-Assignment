package fivefishes.design.patterns.group.assignment.factorymethod;

public class ShanghaiMooncakeFactory implements MooncakeFactory{
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
    public Yolk createYolk() {
        return new SaltedEggYolk();
    }

    @Override
    public MooncakeImage createImage() {
        return new ShanghaiMooncakeImage();
    }
}