package fivefishes.design.patterns.group.assignment.entities;

import fivefishes.design.patterns.group.assignment.interfaces.Subject;
import fivefishes.design.patterns.group.assignment.interfaces.Observer;

import java.util.List;

public class ClockSubject extends Subject {

    private List<Observer> observers;

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver() {
        observers.forEach(Observer::update);
    }
}
