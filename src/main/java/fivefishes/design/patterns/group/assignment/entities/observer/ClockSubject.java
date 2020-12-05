package fivefishes.design.patterns.group.assignment.entities.observer;

import fivefishes.design.patterns.group.assignment.interfaces.observer.Subject;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;

import java.util.HashSet;
import java.util.Set;

public class ClockSubject implements Subject {

    private Set<Observer> observers = new HashSet<>();

    public ClockSubject(Set<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public boolean isRegistered(Observer observer) {
        return observers.contains(observer);
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
