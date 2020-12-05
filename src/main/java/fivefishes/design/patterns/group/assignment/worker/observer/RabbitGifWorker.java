package fivefishes.design.patterns.group.assignment.worker.observer;

import fivefishes.design.patterns.group.assignment.components.observer.RabbitGifLabel;


public class RabbitGifWorker implements Runnable {

    private RabbitGifLabel dancingRabbitLabel, singingRabbitLabel;

    public RabbitGifWorker(RabbitGifLabel dancingRabbitLabel, RabbitGifLabel singingRabbitLabel) {
        this.dancingRabbitLabel = dancingRabbitLabel;
        this.singingRabbitLabel = singingRabbitLabel;
    }

    @Override
    public void run() {
        showRabbit(true);
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        showRabbit(false);
    }

    public void showRabbit(boolean showRabbit) {
        dancingRabbitLabel.setVisible(showRabbit);
        singingRabbitLabel.setVisible(showRabbit);
    }
}
