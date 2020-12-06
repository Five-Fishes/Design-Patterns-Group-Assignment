package fivefishes.design.patterns.group.assignment.controllers.observer;

import fivefishes.design.patterns.group.assignment.entities.observer.AudioPlayerObserver;
import fivefishes.design.patterns.group.assignment.entities.observer.RabbitObserver;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Subject;

public class ObserverController {
    private Subject subject;
    private AudioPlayerObserver audioPlayerObserver;
    private RabbitObserver rabbitObserver;

    public ObserverController(Subject subject, AudioPlayerObserver audioPlayerObserver, RabbitObserver rabbitObserver) {
        this.subject = subject;
        this.audioPlayerObserver = audioPlayerObserver;
        this.rabbitObserver = rabbitObserver;
    }

    public boolean isRegistered(Class<?> clazz) {
        return subject.getObservers()
                .stream()
                .anyMatch(clazz::isInstance);
    }

    public void register(Class<?> clazz) {
        if (clazz.isInstance(audioPlayerObserver)) {
            subject.register(audioPlayerObserver);
        } else if (clazz.isInstance(rabbitObserver)) {
            subject.register(rabbitObserver);
        }
    }

    public void unregister(Class<?> clazz) {
        if (clazz.isInstance(audioPlayerObserver)) {
            subject.unregister(audioPlayerObserver);
        } else if (clazz.isInstance(rabbitObserver)) {
            subject.unregister(rabbitObserver);
        }
    }
}
