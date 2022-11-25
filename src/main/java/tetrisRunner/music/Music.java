package tetrisRunner.music;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Music {
    static Clip clip;
    static float currentVolume = 0;
    static float previousVolume = 0;
    static FloatControl fc;
    static boolean muted = false;

    public static boolean isMuted() {
        return muted;
    }

    public static void runMusic(String path) {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            Music.play();
            Music.loop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void play(){
        clip.setFramePosition(0);
        clip.start();
    }

    public static void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void volumeUp(){
        if (!muted) {
            currentVolume += 5.0f;
            if (currentVolume>6.0f) currentVolume = 6.0f;
            fc.setValue(currentVolume);
        }
    }
    public static void volumeDown(){
        if (!muted) {
            currentVolume -= 5.0f;
            if (currentVolume < -80.0f) currentVolume = -80.0f;
            fc.setValue(currentVolume);
        }
    }

    public static void volumeMute(){
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

    public static FloatControl getFc() {
        return fc;
    }

    public static Clip getClip() {
        return clip;
    }
}

