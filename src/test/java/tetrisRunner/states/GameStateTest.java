package tetrisRunner.states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.controller.game.GameController;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.viewer.game.GameViewer;

public class GameStateTest {
    private GameState gameState;
    private Layout layout;
    @BeforeEach
    public void helper(){
        layout = new Layout(20,20);
        gameState = new GameState(layout);
    }
    @Test
    public void getViewerTest(){
        Assertions.assertInstanceOf(GameViewer.class,gameState.getViewer());
    }
    @Test
    public void getControllerTest(){
        Assertions.assertInstanceOf(GameController.class,gameState.getController());
    }
}
