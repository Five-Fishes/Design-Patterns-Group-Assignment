package fivefishes.design.patterns.group.assignment.entities.observer;

import fivefishes.design.patterns.group.assignment.interfaces.observer.Subject;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ClockSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private boolean active = false;

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
        observers.forEach(Observer::update);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
