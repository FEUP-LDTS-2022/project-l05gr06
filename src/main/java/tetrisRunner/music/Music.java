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
    static boolean mute = false;
    public static void RunMusic(String path) {
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

    public void stop(){
        clip.stop();
    }

    public static void volumeUp(){
        currentVolume += 5.0f;
        if (currentVolume>6.0f) currentVolume = 6.0f;
        fc.setValue(currentVolume);
    }
    public static void volumeDown(){
        currentVolume -= 5.0f;
        if (currentVolume<-80.0f) currentVolume = -80.0f;
        fc.setValue(currentVolume);
    }

    public static void volumeMute(){
        if (!mute) {
            previousVolume = currentVolume;
            currentVolume = -80.0f;
            fc.setValue(currentVolume);
            mute = true;
        }
        else if (mute) {
            currentVolume = previousVolume;
            fc.setValue(currentVolume);
            mute = false;
        }

    }

}

