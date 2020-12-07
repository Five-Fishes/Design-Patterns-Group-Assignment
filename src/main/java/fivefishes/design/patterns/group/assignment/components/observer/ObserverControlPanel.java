package fivefishes.design.patterns.group.assignment.components.observer;

import fivefishes.design.patterns.group.assignment.components.DesignPatternControlPanel;
import fivefishes.design.patterns.group.assignment.controllers.observer.ObserverController;

public class ObserverControlPanel extends DesignPatternControlPanel {
    private ObserverController observerController;
    private RabbitObserverCheckBox rabbitObserverCheckBox;
    private AudioPlayerObserverCheckBox audioPlayerObserverCheckBox;
    private TimerLabel timerLabel;

    public ObserverControlPanel(String title, ObserverController observerController, TimerLabel timerLabel) {
        this(title, "", observerController, timerLabel);
    }

    public ObserverControlPanel(String title, String description, ObserverController observerController, TimerLabel timerLabel) {
        super(title, description);
        this.observerController = observerController;
        this.timerLabel = timerLabel;
        this.rabbitObserverCheckBox = new RabbitObserverCheckBox(observerController);
        this.audioPlayerObserverCheckBox = new AudioPlayerObserverCheckBox(observerController);
        this.add(timerLabel);
        this.add(rabbitObserverCheckBox);
        this.add(audioPlayerObserverCheckBox);
    }
}
