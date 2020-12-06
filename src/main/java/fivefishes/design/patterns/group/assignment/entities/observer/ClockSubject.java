package fivefishes.design.patterns.group.assignment.entities.observer;

import fivefishes.design.patterns.group.assignment.interfaces.observer.Subject;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;

import java.util.HashSet;
import java.util.Set;

public class ClockSubject implements Subject {

    private Set<Observer> observers;

    public ClockSubject(Set<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public Set<Observer> getObservers() {
        return observers;
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update(this));
    }
}
