
package fivefishes.design.patterns.group.assignment.entities.lantern;

import fivefishes.design.patterns.group.assignment.interfaces.lantern.LightBehaviour;

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
