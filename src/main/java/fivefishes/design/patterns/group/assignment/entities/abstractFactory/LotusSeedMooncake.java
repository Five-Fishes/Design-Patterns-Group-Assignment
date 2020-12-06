package fivefishes.design.patterns.group.assignment.entities.abstractFactory;

public class LotusSeedMooncake extends Mooncake {

    @Override
    public void prepare() {
        this.image = mooncakeFactory.createImage();
        this.shape = mooncakeFactory.createShape();
        this.dough = mooncakeFactory.createDough();
        this.lotusSeedPaste = mooncakeFactory.createLotusSeedPaste();
        this.yolk = mooncakeFactory.createFillings();
    }


}
