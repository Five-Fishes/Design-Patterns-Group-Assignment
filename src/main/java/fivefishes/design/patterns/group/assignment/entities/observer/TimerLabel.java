package fivefishes.design.patterns.group.assignment.entities.observer;

import javax.swing.*;

public class TimerLabel extends JLabel {

    public TimerLabel() {
        Runnable runnable = () -> {
        };
        new Thread(runnable).start();
    }
}
