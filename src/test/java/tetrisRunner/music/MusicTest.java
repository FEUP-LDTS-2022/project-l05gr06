package tetrisRunner.music;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.Clip;

import static org.mockito.Mockito.mock;

public class MusicTest {
    private Clip clip;
    private boolean mute;
    static float currentVolume;
    static float previousVolume;

    @BeforeEach
    public void helper(){
        clip = Mockito.mock(Clip.class);
        mute = true;
        currentVolume = 0;
        previousVolume = 0;
    }

    @Test
    public void volumeUpTest(){

    }
}
