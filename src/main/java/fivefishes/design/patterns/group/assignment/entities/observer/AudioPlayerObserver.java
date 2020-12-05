package fivefishes.design.patterns.group.assignment.entities.observer;

import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Subject;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayerObserver implements Observer {

    private Subject subject;

    @Override
    public void update(Subject subject) {
        try {
            String url = "src/main/java/fivefishes/design/patterns/group/assignment/resources/observer/song.wav";
            File songFile = new File(url);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(songFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            System.out.println("error occur!");
            System.out.println(e);
        }
    }
}
