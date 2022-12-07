package tetrisRunner.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.Settings;
import tetrisRunner.music.Music;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SettingsControllerTest {
    private SettingsController settingsController;
    private Settings settings;
    private Game game;
    private Music music;
    private List<GUI.ACTION> guiActions;

    @BeforeEach
    public void helper(){
        settings = Mockito.mock(Settings.class, Mockito.withSettings().useConstructor(true));
        settingsController = new SettingsController(settings);
        game = Mockito.mock(Game.class);
        music = Mockito.mock(Music.class);
        Mockito.when(game.getMusic()).thenReturn(music);
        Mockito.doNothing().when(music).volumeMute();
        Mockito.doNothing().when(music).volumeUp();
        Mockito.doNothing().when(music).volumeDown();
        guiActions = Arrays.asList(GUI.ACTION.UP, GUI.ACTION.DOWN, GUI.ACTION.SELECT);
    }

    @Test
    public void stepUpTest() throws IOException {
        settingsController.step(game, guiActions.get(0),0);
        Mockito.verify(settings, Mockito.times(1)).previousEntry();
    }

    @Test
    public void stepDownTest() throws IOException {
        settingsController.step(game, guiActions.get(1),0);
        Mockito.verify(settings, Mockito.times(1)).nextEntry();
    }

    @Test
    public void stepSelectMuteTest() throws IOException {
        Mockito.when(settings.isSelectedMute()).thenReturn(true);
        settingsController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).getMusic();
        Mockito.verify(music,Mockito.times(1)).volumeMute();

    }

    @Test
    public void stepSelectVolumeUpTest() throws IOException {
        Mockito.when(settings.isSelectedVolumeUp()).thenReturn(true);
        settingsController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).getMusic();
        Mockito.verify(music,Mockito.times(1)).volumeUp();
    }

    @Test
    public void stepSelectVolumeDownTest() throws IOException {
        Mockito.when(settings.isSelectedVolumeDown()).thenReturn(true);
        settingsController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).getMusic();
        Mockito.verify(music,Mockito.times(1)).volumeDown();
    }

    //TODO stepSelectReturn (stop static dependency)
}
