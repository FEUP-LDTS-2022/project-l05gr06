package tetrisRunner.music;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Music {
    private Clip clip;
    private float currentVolume;
    private float previousVolume;
    private FloatControl fc;
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
        if (!muted) {
            currentVolume += 5.0f;
            if (currentVolume>6.0f) currentVolume = 6.0f;
            fc.setValue(currentVolume);
        }
    }
    public void volumeDown(){
        if (!muted) {
            currentVolume -= 5.0f;
            if (currentVolume < -80.0f) currentVolume = -80.0f;
            fc.setValue(currentVolume);
        }
    }

    public void volumeMute(){
        if (!muted) {
            previousVolume = currentVolume;
            currentVolume = -80.0f;
            fc.setValue(currentVolume);
            muted = true;
        }
        else if (muted) {
            currentVolume = previousVolume;
            fc.setValue(currentVolume);
            muted = false;
        }

    }

    public FloatControl getFc() {
        return fc;
    }
    public Clip getClip() {
        return clip;
    }
}

