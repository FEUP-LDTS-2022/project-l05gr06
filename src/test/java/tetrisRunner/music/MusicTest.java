package tetrisRunner.music;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import static org.mockito.Mockito.mock;

public class MusicTest {
    String path;
    Music music;


    @BeforeEach
    public void helper(){
        path = "./src/main/resources/music/theme.wav";
        music = Mockito.mock(Music.class);
    }

    @Test
    public void runMusicTest(){
        music.runMusic(path);
        Assertions.assertNotEquals(music.getFc(),null);
        Assertions.assertNotEquals(music.getClip(),null);
    }
}
