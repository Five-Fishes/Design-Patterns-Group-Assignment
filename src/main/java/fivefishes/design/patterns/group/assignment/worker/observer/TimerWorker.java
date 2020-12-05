package fivefishes.design.patterns.group.assignment.worker.observer;

import javax.swing.*;

public class TimerWorker implements Runnable {
    long startTime = System.currentTimeMillis();
    private JLabel jLabel;

    public TimerWorker(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    @Override
    public void run() {
        while (true) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            long elapsedSeconds = elapsedTime / 1000;
            long secondsUntilNextNotify = 60 - (elapsedSeconds % 60);
            String textValue = "The subject will notify in " + secondsUntilNextNotify + " seconds";
            jLabel.setText(textValue);
            jLabel.repaint();
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
