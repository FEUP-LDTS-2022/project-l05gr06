package tetrisRunner.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.menu.Settings;
import tetrisRunner.music.Music;
import tetrisRunner.states.GameState;
import tetrisRunner.states.PauseState;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class SettingsControllerTest {
    private SettingsController settingsController;
    private SettingsController pauseSettingsController;
    private Settings settings;
    private Settings pauseSettings;
    private Game game;
    private Music music;
    private List<GUI.ACTION> guiActions;

    @BeforeEach
    public void helper(){
        settings = Mockito.mock(Settings.class, Mockito.withSettings().useConstructor(true));
        pauseSettings = Mockito.mock(Settings.class, Mockito.withSettings().useConstructor(true));
        settingsController = new SettingsController(settings);
        pauseSettingsController = new SettingsController(pauseSettings);
        Mockito.when(pauseSettingsController.getModel().getGameState()).thenReturn(new GameState(new Layout(10,10)));
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

    @Test
    public void stepSelectedReturnMenuTest() throws IOException {
        Mockito.when(settings.isSelectedReturn()).thenReturn(true);
        settingsController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(StartMenuState.class));
    }

    @Test
    public void stepSelectedReturnPauseTest() throws IOException {
        Mockito.when(pauseSettings.isSelectedReturn()).thenReturn(true);
        pauseSettingsController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(PauseState.class));
    }

}
