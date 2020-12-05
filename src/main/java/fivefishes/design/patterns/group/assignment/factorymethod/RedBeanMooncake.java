package fivefishes.design.patterns.group.assignment.factorymethod;

import fivefishes.design.patterns.group.assignment.factorymethod.factory.MooncakeFactory;

public class RedBeanMooncake extends Mooncake{
    private MooncakeFactory mooncakeFactory;

    public RedBeanMooncake(MooncakeFactory mooncakeFactory){
        this.mooncakeFactory = mooncakeFactory;
    }

    @Override
    public void prepare() {
        this.image = mooncakeFactory.createImage();
        this.shape = mooncakeFactory.createShape();
        this.dough = mooncakeFactory.createDough();
        this.redBeanPaste = mooncakeFactory.createRedBeanPaste();
        this.yolk = mooncakeFactory.createFillings();
    }
}
