package fivefishes.design.patterns.group.assignment.entities.observer;

import fivefishes.design.patterns.group.assignment.interfaces.observer.Subject;

import javax.swing.*;

public class SubjectWorker implements Runnable {

    private ClockSubject clockSubject;
    private JFrame jFrame;

    public SubjectWorker(ClockSubject clockSubject, JFrame jFrame) {
        this.clockSubject = clockSubject;
        this.jFrame = jFrame;
    }

    @Override
    public void run() {
        clockSubject.notifyObserver();
        clockSubject.setActive(true);
        jFrame.repaint();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clockSubject.setActive(false);
        jFrame.repaint();
    }
}
