package fivefishes.design.patterns.group.assignment.interfaces.observer;

public interface Subject {

    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObserver();
}
