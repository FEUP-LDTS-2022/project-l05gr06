package tetrisRunner.viewer.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.SelectMode;

import java.io.IOException;

public class SelectModeViewerTest {
    private GUI gui;
    private SelectGameModeViewer viewer;
    private SelectMode selectMode;

    @BeforeEach
    public void helper(){
        selectMode = new SelectMode();
        gui = Mockito.mock(GUI.class);
        viewer = new SelectGameModeViewer(selectMode);
        Mockito.when(gui.getStringColor(GUI.COLOR.WHITE)).thenReturn("#FFFFFF");
        Mockito.when(gui.getStringColor(GUI.COLOR.BLACK)).thenReturn("#000000");
        Mockito.when(gui.getStringColor(GUI.COLOR.CYAN)).thenReturn("#40E0D0");
        Mockito.when(gui.getMenuName(GUI.NAME_STATES.SELECT_MODE)).thenReturn("Select Mode");
    }

    @Test
    public void drawElementsTest() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getMenuName(GUI.NAME_STATES.SELECT_MODE);
        Mockito.verify(gui,Mockito.times(3)).getStringColor(GUI.COLOR.CYAN);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.ORANGE);
        Mockito.verify(gui,Mockito.times(4)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(5)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5, 5),
                "Select Mode",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,7),
                "Classic",
                "#40E0D0",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,8),
                "Climbing",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,9),
                "PvP",
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
