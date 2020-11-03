package prototype.observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver {

    public static void main(String[] args) {

        Subject subject = setupSubject();
        JFrame f = new JFrame("Button Example");

        JButton b = new JButton("Click Here");
        b.setBounds(50, 100, 95, 30);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello world");
                subject.notifyObservers();
            }
        });

        f.add(b);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

    private static Subject setupSubject() {
        Subject subject = new SomeSubject();
        subject.register(new AudioPlayerObserver());
        return subject;
    }
}
