package tetrisRunner.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.SelectMode;
import tetrisRunner.states.GameState;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class SelectModeControllerTest {

    private SelectModeController modeController;
    private SelectMode selectMode;
    private Game game;
    private List<GUI.ACTION> guiActions;

    @BeforeEach
    public void helper(){
        selectMode = Mockito.mock(SelectMode.class);
        modeController = new SelectModeController(selectMode);
        game = Mockito.mock(Game.class);
        guiActions = Arrays.asList(GUI.ACTION.ARROW_UP, GUI.ACTION.ARROW_DOWN, GUI.ACTION.SELECT);
    }

    @Test
    public void stepUpTest() throws IOException {
        modeController.step(game, guiActions.get(0),0);
        Mockito.verify(selectMode, Mockito.times(1)).previousEntry();
    }

    @Test
    public void stepDownTest() throws IOException {
        modeController.step(game, guiActions.get(1),0);
        Mockito.verify(selectMode, Mockito.times(1)).nextEntry();
    }

    @Test
    public void stepSelectedReturnTest() throws IOException {
        Mockito.when(selectMode.isSelectedReturn()).thenReturn(true);
        modeController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(StartMenuState.class));
    }

    @Test
    public void stepSelectedClassicTest() throws IOException {
        Mockito.when(selectMode.isSelectedClassic()).thenReturn(true);
        modeController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(GameState.class));
    }

    @Test
    public void stepSelectedCoOpTest() throws IOException {
        Mockito.when(selectMode.isSelectedCoOp()).thenReturn(true);
        modeController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(GameState.class));
    }

    @Test
    public void stepSelected1v1Test() throws IOException {
        Mockito.when(selectMode.isSelected1v1()).thenReturn(true);
        modeController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(GameState.class));
    }
}
