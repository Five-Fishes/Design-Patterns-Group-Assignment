
package fivefishes.design.patterns.group.assignment.entities.strategy;

import fivefishes.design.patterns.group.assignment.interfaces.strategy.LightBehaviour;
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
    
    public float getLightIntensity(){
        return lightBehaviour.lightIntensity();
    }
}
