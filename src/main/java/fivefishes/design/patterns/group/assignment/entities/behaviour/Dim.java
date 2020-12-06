
package fivefishes.design.patterns.group.assignment.entities.behaviour;

import fivefishes.design.patterns.group.assignment.interfaces.behaviour.LightBehaviour;

public class Dim implements LightBehaviour{

    @Override
    public int lightRadiusRatio() {
        return 2;
    }
    
    @Override
    public float lightIntensity() {
        return 0.2f;
    }
    
}
