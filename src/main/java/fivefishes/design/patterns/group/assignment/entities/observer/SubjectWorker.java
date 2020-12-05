package fivefishes.design.patterns.group.assignment.entities.observer;

import fivefishes.design.patterns.group.assignment.interfaces.observer.Subject;

import javax.swing.*;

public class SubjectWorker implements Runnable {

    private ClockSubject clockSubject;

    public SubjectWorker(ClockSubject clockSubject) {
        this.clockSubject = clockSubject;
    }

    @Override
    public void run() {
        clockSubject.notifyObserver();
    }
}
