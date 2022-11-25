package tetrisRunner.music;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MusicTest {
    String path;

/*
    @BeforeEach
    public void helper(){
        path = "./src/main/resources/music/theme.wav";
        Music.runMusic(path);
    }

    @Test
    public void runMusicTest(){
        Assertions.assertNotEquals(Music.getFc(),null);
        Assertions.assertNotEquals(Music.getClip(),null);
    }

    @Test
    public void volumeMuteTest(){
        if (Music.isMuted()){
            Music.volumeMute();
            Assertions.assertEquals(Music.isMuted(),false);
        }
        else{
            Music.volumeMute();
            Assertions.assertEquals(Music.isMuted(),true);
            Assertions.assertEquals(Music.getFc().getValue(), -80.0f);
        }
    }
 */
}
