package fivefishes.design.patterns.group.assignment.components.observer;

import fivefishes.design.patterns.group.assignment.controllers.observer.ObserverController;
import fivefishes.design.patterns.group.assignment.entities.observer.RabbitObserver;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Subject;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RabbitObserverCheckBox extends JCheckBox {
    private ObserverController observerController;
    private static final Class<?> clazz = RabbitObserver.class;

    public RabbitObserverCheckBox(ObserverController observerController) {
        this.observerController = observerController;
        this.setText("RabbitObserver");
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
