package tetrisRunner.viewer.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.StartMenu;

import java.io.IOException;

public class StartMenuViewerTest {
    private GUI gui;
    private StartMenuViewer viewer;
    private StartMenu startMenu;

    @BeforeEach
    public void helper(){
        startMenu = new StartMenu();
        gui = Mockito.mock(GUI.class);
        viewer = new StartMenuViewer(startMenu);
        Mockito.when(gui.getStringColor(GUI.COLOR.WHITE)).thenReturn("#FFFFFF");
        Mockito.when(gui.getStringColor(GUI.COLOR.BLACK)).thenReturn("#000000");
        Mockito.when(gui.getStringColor(GUI.COLOR.CYAN)).thenReturn("#40E0D0");
        Mockito.when(gui.getMenuName(GUI.NAME_STATES.START_MENU)).thenReturn("Menu");
    }

    @Test
    public void drawElementsTest() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getMenuName(GUI.NAME_STATES.START_MENU);
        Mockito.verify(gui,Mockito.times(4)).getStringColor(GUI.COLOR.CYAN);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.RED);
        Mockito.verify(gui,Mockito.times(5)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(6)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5, 5),
                "Menu",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,7),
                "Game Mode",
                "#40E0D0",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,8),
                "Instructions",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,9),
                "Leaderboard",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,10),
                "Settings",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,11),
                "Exit",
                "#FFFFFF",
                "#000000"
        );
    }
}
