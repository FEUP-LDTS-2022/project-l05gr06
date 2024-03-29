package tetrisRunner.music;

import javax.sound.sampled.*;
import java.io.File;

public class Music {
    protected Clip clip;
    private float currentVolume;
    private float previousVolume;
    protected FloatControl fc;
    private boolean muted;

    public Music(String path) {
        try {
            muted = false;
            currentVolume = 0;
            previousVolume = 0;
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isMuted() {
        return muted;
    }

    public void runMusic() {
        play();
        loop();
    }
    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void volumeUp(){
        if (!isMuted()) {
            currentVolume += 5.0f;
            if (currentVolume>6.0f) currentVolume = 6.0f;
            fc.setValue(currentVolume);
        }
    }
    public void volumeDown(){
        if (!isMuted()) {
            currentVolume -= 5.0f;
            if (currentVolume < -80.0f) currentVolume = -80.0f;
            fc.setValue(currentVolume);
        }
    }

    public void volumeMute(){
        if (!isMuted()) {
            previousVolume = currentVolume;
            currentVolume = -80.0f;
            fc.setValue(currentVolume);
            muted = true;
        }
        else {
            currentVolume = previousVolume;
            fc.setValue(currentVolume);
            muted = false;
        }

    }

    public float getCurrentVolume() {
        return currentVolume;
    }
}

