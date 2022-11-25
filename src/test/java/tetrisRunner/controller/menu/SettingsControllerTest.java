package tetrisRunner.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.Settings;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.music.Music;
import tetrisRunner.states.SelectModeState;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class SettingsControllerTest {
    private SettingsController settingsController;
    private Settings settings;
    private Game game;
    private List<GUI.ACTION> guiActions;
    private String path;

    @BeforeEach
    public void helper(){
        settings = Mockito.mock(Settings.class);
        settingsController = new SettingsController(settings);
        game = Mockito.mock(Game.class);
        guiActions = Arrays.asList(GUI.ACTION.UP, GUI.ACTION.DOWN, GUI.ACTION.SELECT);
        path = "./src/main/resources/music/theme.wav";
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
        Mockito.verify(settings, Mockito.times(1)).switchMute();
    }

    @Test
    public void stepSelectVolumeUpTest() throws IOException {
        Mockito.when(settings.isSelectedVolumeUp()).thenReturn(true);
        settingsController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(null);
    }

    @Test
    public void stepSelectVolumeDownTest() throws IOException {
        Mockito.when(settings.isSelectedVolumeDown()).thenReturn(true);
        settingsController.step(game, guiActions.get(2),0);
        //Mockito.verify(music, Mockito.times(1)).volumeDown();
    }

    @Test
    public void stepSelectReturnTest() throws IOException {
        Mockito.when(settings.isSelectedReturn()).thenReturn(true);
        settingsController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(SelectModeState.class));
    }
}
