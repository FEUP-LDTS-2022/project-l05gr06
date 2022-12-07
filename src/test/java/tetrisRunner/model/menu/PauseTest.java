package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.states.GameState;

public class PauseTest {
    Game game;
    Pause menu;

    @BeforeEach
    public void helper(){
        game = Mockito.mock(Game.class);
        Mockito.when(game.getState()).thenReturn(new GameState(new Layout(10,10)));
        menu = new Pause(game.getState());
    }


    @Test
    public void isSelectedGameTest() {
        Assertions.assertTrue(menu.isSelectedGame());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedGame());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedGame());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedGame());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedGame());
    }



    @Test
    public void isSelectedMenuTest() {
        Assertions.assertFalse(menu.isSelectedMenu());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedMenu());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedMenu());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedMenu());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedMenu());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedMenu());
    }

    @Test
    public void isSelectedSettingsTest() {
        Assertions.assertFalse(menu.isSelectedSettings());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedSettings());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedSettings());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedSettings());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedSettings());
    }

    @Test
    public void isSelectedExitTest() {
        Assertions.assertFalse(menu.isSelectedExit());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedExit());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedExit());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedExit());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedExit());
    }


}
