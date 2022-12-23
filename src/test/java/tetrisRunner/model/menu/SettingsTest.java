package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.music.Music;

public class SettingsTest {
    Settings menu;
    Game game;
    String path;

    @BeforeEach
    public void helper(){
        path = "./src/main/resources/music/theme.wav";
        game = Mockito.mock(Game.class);
        Mockito.when(game.getMusic()).thenReturn(new Music(path));
        menu = new Settings(game.getMusic().isMuted());
    }

    @Test
    public void isSelectedMuteTest() {
        Assertions.assertTrue(menu.isSelectedMute());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedMute());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedMute());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedMute());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedMute());
    }

    @Test
    public void isSelectedUpTest() {
        Assertions.assertFalse(menu.isSelectedVolumeUp());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedVolumeUp());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedVolumeUp());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedVolumeUp());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedVolumeUp());
    }

    @Test
    public void isSelectedDownTest() {
        Assertions.assertFalse(menu.isSelectedVolumeDown());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedVolumeDown());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedVolumeDown());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedVolumeDown());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedVolumeDown());
    }

    @Test
    public void isSelectedReturnTest() {
        Assertions.assertFalse(menu.isSelectedReturn());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedReturn());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedReturn());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedReturn());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedReturn());
    }

    @Test
    public void switchMuteTest() {
        Assertions.assertEquals("Mute", menu.entries.get(0));
        menu.switchMute();
        Assertions.assertEquals("Unmute", menu.entries.get(0));
        menu.switchMute();
        Assertions.assertEquals("Mute", menu.entries.get(0));
    }
}
