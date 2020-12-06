package fivefishes.design.patterns.group.assignment.factorymethod;

import fivefishes.design.patterns.group.assignment.factorymethod.factory.TraditionalMooncakeFactory;
import fivefishes.design.patterns.group.assignment.factorymethod.factory.KluangMooncakeFactory;
import fivefishes.design.patterns.group.assignment.factorymethod.factory.MooncakeFactory;
import fivefishes.design.patterns.group.assignment.factorymethod.factory.ShanghaiMooncakeFactory;

public enum MooncakeStyle {
    Traditional(new TraditionalMooncakeFactory()), Shanghai(new ShanghaiMooncakeFactory()), Kluang(new KluangMooncakeFactory());

    private final MooncakeFactory mooncakeFactory;

    private MooncakeStyle(MooncakeFactory mooncakeFactory){
        this.mooncakeFactory = mooncakeFactory;
    }

    public MooncakeFactory getMooncakeFactory(){
        return mooncakeFactory;
    }
}
