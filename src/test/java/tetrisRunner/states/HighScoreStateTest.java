package tetrisRunner.states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.controller.menu.HighScoreController;
import tetrisRunner.model.menu.HighScore;
import tetrisRunner.viewer.menu.HighScoreViewer;

public class HighScoreStateTest {
    private HighScoreState highScoreState;
    private HighScore highScore;
    @BeforeEach
    public void helper(){
        highScore = new HighScore(true,20);
        highScoreState = new HighScoreState(highScore);
    }
    @Test
    public void getViewerTest(){
        Assertions.assertInstanceOf(HighScoreViewer.class,highScoreState.getViewer());
    }
    @Test
    public void getControllerTest(){
        Assertions.assertInstanceOf(HighScoreController.class,highScoreState.getController());
    }
}
