package tetrisRunner.states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.controller.menu.SettingsController;
import tetrisRunner.model.menu.Settings;
import tetrisRunner.viewer.menu.SettingsViewer;

public class SettingsStateTest {
    private SettingsState settingsState;
    private Settings settings;
    @BeforeEach
    public void helper(){
        settings = new Settings(true);
        settingsState = new SettingsState(settings);
    }
    @Test
    public void getViewerTest(){
        Assertions.assertInstanceOf(SettingsViewer.class,settingsState.getViewer());
    }
    @Test
    public void getControllerTest(){
        Assertions.assertInstanceOf(SettingsController.class,settingsState.getController());
    }
}
