package tetrisRunner.viewer.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.gamebehavior.ClassicBehavior;
import tetrisRunner.model.game.layout.LoaderLayoutBuilder;
import tetrisRunner.model.menu.Settings;
import tetrisRunner.states.GameState;

import java.io.IOException;

public class SettingsViewerTest {
    private GUI gui;
    private SettingsViewer viewerUnmuted, viewerMuted;
    private Settings settingsUnmuted, settingsMuted;

    @BeforeEach
    public void helper(){
        settingsUnmuted = new Settings(false,new GameState(new LoaderLayoutBuilder(new ClassicBehavior()).createLayout()));
        settingsMuted = new Settings(true,new GameState(new LoaderLayoutBuilder(new ClassicBehavior()).createLayout()));
        gui = Mockito.mock(GUI.class);
        viewerUnmuted = new SettingsViewer(settingsUnmuted);
        viewerMuted = new SettingsViewer(settingsMuted);
        Mockito.when(gui.getStringColor(GUI.COLOR.WHITE)).thenReturn("#FFFFFF");
        Mockito.when(gui.getStringColor(GUI.COLOR.BLACK)).thenReturn("#000000");
        Mockito.when(gui.getStringColor(GUI.COLOR.CYAN)).thenReturn("#40E0D0");
        Mockito.when(gui.getStringColor(GUI.COLOR.RED)).thenReturn("#D22B2B");
        Mockito.when(gui.getStringColor(GUI.COLOR.GREEN)).thenReturn("#50C878");
        Mockito.when(gui.getMenuName(GUI.NAME_STATES.SETTINGS)).thenReturn("Settings");
    }

    @Test
    public void drawElementsUnmutedTest() throws IOException {
        viewerUnmuted.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getMenuName(GUI.NAME_STATES.SETTINGS);
        Mockito.verify(gui,Mockito.times(2)).getStringColor(GUI.COLOR.CYAN);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.RED);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.ORANGE);
        Mockito.verify(gui,Mockito.times(4)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(5)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5, 5),
                "Settings",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,7),
                "Mute",
                "#D22B2B",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,8),
                "Volume UP",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,9),
                "Volume DOWN",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,10),
                "Return",
                "#FFFFFF",
                "#000000"
        );
    }
    @Test
    public void drawElementsMutedTest() throws IOException {
        viewerMuted.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getMenuName(GUI.NAME_STATES.SETTINGS);
        Mockito.verify(gui,Mockito.times(2)).getStringColor(GUI.COLOR.CYAN);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.GREEN);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.ORANGE);
        Mockito.verify(gui,Mockito.times(4)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(5)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5, 5),
                "Settings",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,7),
                "Unmute",
                "#50C878",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,8),
                "Volume UP",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,9),
                "Volume DOWN",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,10),
                "Return",
                "#FFFFFF",
                "#000000"
        );
    }
}
