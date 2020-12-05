package fivefishes.design.patterns.group.assignment.entities.observer;

import fivefishes.design.patterns.group.assignment.components.observer.RabbitGifLabel;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Subject;
import fivefishes.design.patterns.group.assignment.worker.observer.RabbitGifWorker;

import javax.swing.*;

public class RabbitObserver implements Observer {

    private Subject subject;
    private RabbitGifWorker rabbitGifWorker;


    public RabbitObserver(RabbitGifLabel dancingRabbitLabel, RabbitGifLabel singingRabbitLabel) {
        this.rabbitGifWorker = new RabbitGifWorker(dancingRabbitLabel, singingRabbitLabel);
    }

    @Override
    public void update(Subject subject) {
        this.subject = subject;
        new Thread(rabbitGifWorker).start();
    }

}
