
package fivefishes.design.patterns.group.assignment.entities.behaviour;

import fivefishes.design.patterns.group.assignment.interfaces.behaviour.LightBehaviour;

public class Bright implements LightBehaviour {

    @Override
    public int lightRadiusRatio() {
        return 4;
    }
    
    @Override
    public float lightIntensity() {
        return 0.5f;
    }
}
