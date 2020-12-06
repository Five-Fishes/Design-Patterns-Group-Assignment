
package fivefishes.design.patterns.group.assignment.entities.behaviour;

import fivefishes.design.patterns.group.assignment.interfaces.behaviour.LightBehaviour;

public class Normal implements LightBehaviour {

    @Override
    public int lightRadiusRatio() {
        return 3;
    }
    
    @Override
    public float lightIntensity() {
        return 0.4f;
    }
    
}
