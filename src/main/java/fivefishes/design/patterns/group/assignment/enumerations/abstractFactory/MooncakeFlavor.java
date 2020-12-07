package fivefishes.design.patterns.group.assignment.enumerations.abstractFactory;

import fivefishes.design.patterns.group.assignment.entities.abstractFactory.factory.KluangMooncakeFactory;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.factory.ShanghaiMooncakeFactory;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.factory.TraditionalMooncakeFactory;
import fivefishes.design.patterns.group.assignment.interfaces.abstractFactory.MooncakeFactory;

public enum MooncakeFlavor {
    RedBean("Red Bean"),
    LotusSeed("Lotus Seed");

    private final String value;

    MooncakeFlavor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
