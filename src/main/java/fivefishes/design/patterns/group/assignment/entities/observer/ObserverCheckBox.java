package fivefishes.design.patterns.group.assignment.entities.observer;

import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Subject;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ObserverCheckBox extends JCheckBox {
    private Subject subject;
    private Observer observer;

    public ObserverCheckBox(Subject subject, Observer observer) {
        this.subject = subject;
        this.observer = observer;
        this.setText(getObserverName());
        this.setSelected(subject.isRegistered(observer));
        this.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (subject.isRegistered(observer)) {
                    subject.unregister(observer);
                } else {
                    subject.register(observer);
                }
            }
        });
    }

    public String getObserverName() {
        if (observer instanceof  RabbitObserver) {
            return "RabbitObserver";
        } else {
            return "AudioPlayerObserver";
        }
    }
}
