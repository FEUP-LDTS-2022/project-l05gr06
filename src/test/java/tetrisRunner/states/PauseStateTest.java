package tetrisRunner.states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.controller.menu.PauseController;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.viewer.menu.PauseViewer;

public class PauseStateTest {
    private PauseState pauseState;
    private Pause pause;
    @BeforeEach
    public void helper(){
        pause = new Pause(new GameState(new Layout(10,10)));
        pauseState = new PauseState(pause);
    }
    @Test
    public void getViewerTest(){
        Assertions.assertInstanceOf(PauseViewer.class,pauseState.getViewer());
    }
    @Test
    public void getControllerTest(){
        Assertions.assertInstanceOf(PauseController.class,pauseState.getController());
    }
}
