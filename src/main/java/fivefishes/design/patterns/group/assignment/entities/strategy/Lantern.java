
package fivefishes.design.patterns.group.assignment.entities.strategy;

import fivefishes.design.patterns.group.assignment.interfaces.strategy.LightBehaviour;

public class Lantern {
    private LightBehaviour lightBehaviour;
    
    public Lantern(LightBehaviour lightBehaviour){
        this.lightBehaviour = lightBehaviour;
    }

    public LightBehaviour getLightBehaviour() {
        return lightBehaviour;
    }

    public void setLightBehaviour(LightBehaviour lightBehaviour) {
        this.lightBehaviour = lightBehaviour;
    }
    
    public float getLightIntensity(){
        return lightBehaviour.lightIntensity();
    }
}
