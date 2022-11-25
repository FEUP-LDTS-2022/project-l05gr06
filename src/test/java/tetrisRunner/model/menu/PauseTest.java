package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PauseTest {

    Pause menu;

    @BeforeEach
    public void helper(){
        menu = new Pause();
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
