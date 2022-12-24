package tetrisRunner.states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.controller.menu.GameOverController;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.viewer.menu.GameOverViewer;

public class GameOverStateTest {
    private GameOverState gameOverState;
    private GameOver gameOver;
    @BeforeEach
    public void helper(){
        gameOver = new GameOver(GUI.NAME_STATES.GAME_OVER);
        gameOverState = new GameOverState(gameOver);
    }
    @Test
    public void getViewerTest(){
        Assertions.assertInstanceOf(GameOverViewer.class,gameOverState.getViewer());
    }
    @Test
    public void getControllerTest(){
        Assertions.assertInstanceOf(GameOverController.class,gameOverState.getController());
    }
}
