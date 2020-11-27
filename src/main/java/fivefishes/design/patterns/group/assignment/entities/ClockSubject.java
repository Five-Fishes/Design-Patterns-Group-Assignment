package fivefishes.design.patterns.group.assignment.entities;

import fivefishes.design.patterns.group.assignment.interfaces.Subject;
import fivefishes.design.patterns.group.assignment.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class ClockSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

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
}
