package tetrisRunner.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.music.Music;
import tetrisRunner.states.SelectModeState;
import tetrisRunner.states.SettingsState;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class StartMenuControllerTest {
    private StartMenuController startController;
    private StartMenu startMenu;
    private Game game;
    private Music music;
    private List<GUI.ACTION> guiActions;

    @BeforeEach
    public void helper(){
        startMenu = Mockito.mock(StartMenu.class);
        startController = new StartMenuController(startMenu);
        game = Mockito.mock(Game.class);
        music = Mockito.mock(Music.class);
        Mockito.when(game.getMusic()).thenReturn(music);
        Mockito.when(music.isMuted()).thenReturn(true);
        guiActions = Arrays.asList(GUI.ACTION.ARROW_UP, GUI.ACTION.ARROW_DOWN, GUI.ACTION.SELECT);
    }

    @Test
    public void stepUpTest() throws IOException {
        startController.step(game, guiActions.get(0),0);
        Mockito.verify(startMenu, Mockito.times(1)).previousEntry();
    }

    @Test
    public void stepDownTest() throws IOException {
        startController.step(game, guiActions.get(1),0);
        Mockito.verify(startMenu, Mockito.times(1)).nextEntry();
    }

    @Test
    public void stepSelectGameModeTest() throws IOException {
        Mockito.when(startMenu.isSelectedGameMode()).thenReturn(true);
        startController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(SelectModeState.class));
    }

    @Test
    public void stepSelectExitTest() throws IOException {
        Mockito.when(startMenu.isSelectedExit()).thenReturn(true);
        startController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(null);
    }

    @Test
    public void stepSelectInstructionsTest() throws IOException {
        Mockito.when(startMenu.isSelectedGameMode()).thenReturn(true);
        startController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(SelectModeState.class));
    }

    @Test
    public void stepSelectSettingsTest() throws IOException {
        Mockito.when(startMenu.isSelectedSettings()).thenReturn(true);
        startController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(SettingsState.class));
    }
}
