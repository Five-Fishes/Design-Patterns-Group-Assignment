package fivefishes.design.patterns.group.assignment.entities.observer;

import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Subject;

import javax.swing.*;

public class RabbitObserver implements Observer {
    
    private boolean showRabbit;
    private JFrame jFrame;
    private Subject subject;

    public RabbitObserver(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void update(Subject subject) {
        this.subject = subject;
        setShowRabbit(true);
        jFrame.repaint();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setShowRabbit(false);
        jFrame.repaint();
    }

    public boolean isShowRabbit() {
        return showRabbit;
    }

    public void setShowRabbit(boolean showRabbit) {
        this.showRabbit = showRabbit;
    }
}
