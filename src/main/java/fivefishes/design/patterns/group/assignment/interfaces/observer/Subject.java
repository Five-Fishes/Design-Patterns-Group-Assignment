package fivefishes.design.patterns.group.assignment.interfaces.observer;

import java.util.Set;

public interface Subject {

    Set<Observer> getObservers();

    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObserver();
}
