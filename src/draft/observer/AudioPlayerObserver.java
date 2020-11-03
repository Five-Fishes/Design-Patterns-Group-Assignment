package draft.observer;

import javax.sound.sampled.*;
import java.io.IOException;

public class AudioPlayerObserver implements Observer {

    @Override
    public void update() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(AudioPlayerObserver.class.getResource("song.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            System.out.println("error occur!");
            System.out.println(e);
        }
    }
}
