
package fivefishes.design.patterns.group.assignment.entities.behaviour;

import fivefishes.design.patterns.group.assignment.interfaces.behaviour.LightBehaviour;

public class NoLight implements LightBehaviour {

    @Override
    public float lightIntensity() {
        return 0.0f;
    }
    
}
