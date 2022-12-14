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
        for (int i=0; i<4;i++){
            menu.nextEntry();
            Assertions.assertFalse(menu.isSelectedGameMode());
        }
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedGameMode());
    }

    @Test
    public void isSelectedInstructionsTest() {
        Assertions.assertFalse(menu.isSelectedInstructions());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedInstructions());
        for (int i=0;i<3;i++){
            menu.nextEntry();
            Assertions.assertFalse(menu.isSelectedInstructions());
        }
    }

    @Test
    public void isSelectedLeaderboardTest() {
        Assertions.assertFalse(menu.isSelectedLeaderboard());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedLeaderboard());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedLeaderboard());
        for (int i=0;i<3;i++){
            menu.nextEntry();
            Assertions.assertFalse(menu.isSelectedLeaderboard());
        }
    }
    @Test
    public void isSelectedSettingsTest() {
        Assertions.assertFalse(menu.isSelectedSettings());
        menu.nextEntry();
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
        for (int i=0; i<4;i++){
            Assertions.assertFalse(menu.isSelectedExit());
            menu.nextEntry();
        }
        Assertions.assertTrue(menu.isSelectedExit());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedExit());
    }
}
