package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StartMenuTest {
    StartMenu menu;

    @BeforeEach
    public void helper(){
        menu = new StartMenu();
    }

    @Test
    public void isSelectedGameModeTest() {
        Assertions.assertTrue(menu.isSelectedGameMode());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedGameMode());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedGameMode());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedGameMode());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedGameMode());
    }

    @Test
    public void isSelectedInstructionsTest() {
        Assertions.assertFalse(menu.isSelectedInstructions());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedInstructions());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedInstructions());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedInstructions());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedInstructions());
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
