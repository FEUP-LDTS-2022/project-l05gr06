package tetrisRunner.states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.controller.menu.StartMenuController;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.viewer.menu.StartMenuViewer;

public class StartMenuStateTest {
    private StartMenuState startMenuState;
    private StartMenu startMenu;
    @BeforeEach
    public void helper(){
        startMenu = new StartMenu();
        startMenuState = new StartMenuState(startMenu);
    }
    @Test
    public void getViewerTest(){
        Assertions.assertInstanceOf(StartMenuViewer.class,startMenuState.getViewer());
    }
    @Test
    public void getControllerTest(){
        Assertions.assertInstanceOf(StartMenuController.class,startMenuState.getController());
    }
}
