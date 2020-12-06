package fivefishes.design.patterns.group.assignment.components.observer;

import fivefishes.design.patterns.group.assignment.controllers.observer.ObserverController;
import fivefishes.design.patterns.group.assignment.entities.observer.AudioPlayerObserver;
import fivefishes.design.patterns.group.assignment.entities.observer.RabbitObserver;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AudioPlayerObserverCheckBox extends JCheckBox {
    private ObserverController observerController;
    private static final Class<?> clazz = AudioPlayerObserver.class;

    public AudioPlayerObserverCheckBox(ObserverController observerController) {
        this.observerController = observerController;
        this.setText("AudioPlayerObserver");
        this.setSelected(observerController.isRegistered(clazz));
        this.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (observerController.isRegistered(clazz)) {
                    observerController.unregister(clazz);
                } else {
                    observerController.register(clazz);
                }
            }
        });
    }
}
