package tetrisRunner.music;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import static org.mockito.Mockito.*;

public class MusicTest {
    String path;
    Music music;
    Clip clip;
    FloatControl fc;

    @BeforeEach
    public void helper(){
        path = "./src/main/resources/music/theme.wav";
        clip = Mockito.mock(Clip.class);
        fc = Mockito.mock(FloatControl.class);
        music = new MusicTesting(path,clip,fc);
    }

    @Test
    public void playTest(){
        music.play();
        Mockito.verify(clip,times(1)).start();
        Mockito.verify(clip,times(1)).setFramePosition(0);
    }

    @Test
    public void loopTest(){
        music.loop();
        Mockito.verify(clip,times(1)).loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Test
    public void volumeUpTest(){
        float volume = music.getCurrentVolume();
        music.volumeUp();
        Mockito.verify(fc,times(1)).setValue(music.getCurrentVolume());
        Assertions.assertEquals(volume + 5.0f, music.getCurrentVolume());
        for (int i=0; i<20;i++) music.volumeUp();
        Assertions.assertEquals(6.0f,music.getCurrentVolume());
    }

    @Test
    public void volumeDownTest(){
        float volume = music.getCurrentVolume();
        music.volumeDown();
        Mockito.verify(fc,times(1)).setValue(music.getCurrentVolume());
        Assertions.assertEquals(volume - 5.0f, music.getCurrentVolume());
        for (int i=0; i<20;i++) music.volumeDown();
        Assertions.assertEquals(-80.0f,music.getCurrentVolume());
    }

    @Test
    public void volumeMuteTest(){
        music.volumeMute();
        Mockito.verify(fc,times(1)).setValue(music.getCurrentVolume());
        Assertions.assertEquals(-80.f,music.getCurrentVolume());
        music.volumeMute();
        Mockito.verify(fc,times(1)).setValue(music.getCurrentVolume());
    }

    class MusicTesting extends Music{

        public MusicTesting(String path, Clip clip, FloatControl fc) {
            super(path); super.clip = clip; super.fc = fc;
        }
    }
}
