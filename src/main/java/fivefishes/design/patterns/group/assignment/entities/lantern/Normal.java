
package fivefishes.design.patterns.group.assignment.entities.lantern;

import fivefishes.design.patterns.group.assignment.interfaces.lantern.LightBehaviour;

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
