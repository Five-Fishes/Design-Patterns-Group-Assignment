package fivefishes.design.patterns.group.assignment.entities.abstractFactory;

import fivefishes.design.patterns.group.assignment.entities.abstractFactory.factory.TraditionalMooncakeFactory;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.factory.KluangMooncakeFactory;
import fivefishes.design.patterns.group.assignment.interfaces.abstractFactory.MooncakeFactory;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.factory.ShanghaiMooncakeFactory;

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
