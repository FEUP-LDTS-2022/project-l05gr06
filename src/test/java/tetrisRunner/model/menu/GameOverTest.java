package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.gui.GUI;

public class GameOverTest {
    private GameOver go1, go2, go3;

    @BeforeEach
    public void helper(){
        go1 = new GameOver(GUI.NAME_STATES.GAME_OVER);
        go2 = new GameOver(GUI.NAME_STATES.JACOB_WON);
        go3 = new GameOver(GUI.NAME_STATES.SHAPES_WON);
    }
    @Test
    public void getTitleTest() {
        Assertions.assertEquals(GUI.NAME_STATES.GAME_OVER, go1.getTitle());
        Assertions.assertEquals(GUI.NAME_STATES.JACOB_WON, go2.getTitle());
        Assertions.assertEquals(GUI.NAME_STATES.SHAPES_WON, go3.getTitle());
    }
    @Test
    public void isSelectedPlayAgainTest() {
        Assertions.assertTrue(go1.isSelectedPlayAgain());
        go1.nextEntry();
        Assertions.assertFalse(go1.isSelectedPlayAgain());
        go1.nextEntry();
        Assertions.assertFalse(go1.isSelectedPlayAgain());
    }
    @Test
    public void isSelectedMainMenuTest() {
        Assertions.assertFalse(go1.isSelectedMainMenu());
        go1.nextEntry();
        Assertions.assertTrue(go1.isSelectedMainMenu());
        go1.nextEntry();
        Assertions.assertFalse(go1.isSelectedMainMenu());
    }
    @Test
    public void isSelectedExitTest() {
        Assertions.assertFalse(go1.isSelectedExit());
        go1.nextEntry();
        Assertions.assertFalse(go1.isSelectedExit());
        go1.nextEntry();
        Assertions.assertTrue(go1.isSelectedExit());
    }
}
