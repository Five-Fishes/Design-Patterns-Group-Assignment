
package fivefishes.design.patterns.group.assignment.entities.behaviour;

import fivefishes.design.patterns.group.assignment.interfaces.behaviour.LightBehaviour;
import java.awt.image.BufferedImage;

public class Lantern {
    private BufferedImage baseImage;
    private LightBehaviour lightBehaviour;
    
    public Lantern(BufferedImage image, LightBehaviour lightBehaviour){
        this.baseImage = image;
        this.lightBehaviour = lightBehaviour;
    }

    public BufferedImage getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(BufferedImage baseImage) {
        this.baseImage = baseImage;
    }

    public LightBehaviour getLightBehaviour() {
        return lightBehaviour;
    }

    public void setLightBehaviour(LightBehaviour lightBehaviour) {
        this.lightBehaviour = lightBehaviour;
    }
    
    public int getLightRadiusRatio(){
        return lightBehaviour.lightRadiusRatio();
    }
    
    public float getLightIntensity(){
        return lightBehaviour.lightIntensity();
    }
}