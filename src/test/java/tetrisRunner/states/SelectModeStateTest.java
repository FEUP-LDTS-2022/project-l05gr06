package tetrisRunner.states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.controller.menu.SelectModeController;
import tetrisRunner.model.menu.SelectMode;
import tetrisRunner.viewer.menu.SelectGameModeViewer;

public class SelectModeStateTest {
    private SelectModeState selectModeState;
    private SelectMode selectMode;
    @BeforeEach
    public void helper(){
        selectMode = new SelectMode();
        selectModeState = new SelectModeState(selectMode);
    }
    @Test
    public void getViewerTest(){
        Assertions.assertInstanceOf(SelectGameModeViewer.class,selectModeState.getViewer());
    }
    @Test
    public void getControllerTest(){
        Assertions.assertInstanceOf(SelectModeController.class,selectModeState.getController());
    }
}
