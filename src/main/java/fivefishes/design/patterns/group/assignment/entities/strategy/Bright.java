
package fivefishes.design.patterns.group.assignment.entities.strategy;

import fivefishes.design.patterns.group.assignment.interfaces.strategy.LightBehaviour;

public class Bright implements LightBehaviour {

    @Override
    public float lightIntensity() {
        return 0.5f;
    }
}
