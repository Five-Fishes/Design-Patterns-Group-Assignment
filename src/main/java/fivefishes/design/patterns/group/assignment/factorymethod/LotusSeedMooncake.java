package fivefishes.design.patterns.group.assignment.factorymethod;

import fivefishes.design.patterns.group.assignment.factorymethod.factory.MooncakeFactory;

public class LotusSeedMooncake extends Mooncake {
    private MooncakeFactory mooncakeFactory;

    public LotusSeedMooncake(MooncakeFactory mooncakeFactory){
        this.mooncakeFactory = mooncakeFactory;
    }

    @Override
    public void prepare() {
        this.image = mooncakeFactory.createImage();
        this.shape = mooncakeFactory.createShape();
        this.dough = mooncakeFactory.createDough();
        this.lotusSeedPaste = mooncakeFactory.createLotusSeedPaste();
        this.yolk = mooncakeFactory.createFillings();
    }


}
