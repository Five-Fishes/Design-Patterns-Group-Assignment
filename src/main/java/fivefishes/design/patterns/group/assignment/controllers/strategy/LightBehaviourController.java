package fivefishes.design.patterns.group.assignment.controllers.strategy;

import fivefishes.design.patterns.group.assignment.components.strategy.LanternLabel;
import fivefishes.design.patterns.group.assignment.entities.strategy.*;
import fivefishes.design.patterns.group.assignment.enumerations.strategy.LightBrightness;

public class LightBehaviourController {

    private LanternLabel lanternLabel;

    public LightBehaviourController(LanternLabel lanternLabel) {
        this.lanternLabel = lanternLabel;
    }

    public void setLightBehaviour(LightBrightness lightBehaviour) {
        switch (lightBehaviour) {
            case NoLight:
                lanternLabel.getLantern().setLightBehaviour(new NoLight());
                break;
            case Dim:
                lanternLabel.getLantern().setLightBehaviour(new Dim());
                break;
            case Normal:
                lanternLabel.getLantern().setLightBehaviour(new Normal());
                break;
            case Bright:
                lanternLabel.getLantern().setLightBehaviour(new Bright());
                break;
        }
        lanternLabel.repaint();
    }
}
