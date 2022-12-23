package tetrisRunner.viewer.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.HighScore;

import java.io.IOException;

public class HighScoreViewerTest {
    private GUI gui;
    private HighScoreViewer viewer;
    private HighScore highScore;

    @BeforeEach
    public void helper(){
        highScore = new HighScore(true, 1000);
        gui = Mockito.mock(GUI.class);
        viewer = new HighScoreViewer(highScore);
        Mockito.when(gui.getStringColor(GUI.COLOR.WHITE)).thenReturn("#FFFFFF");
        Mockito.when(gui.getStringColor(GUI.COLOR.BLACK)).thenReturn("#000000");
        Mockito.when(gui.getStringColor(GUI.COLOR.CYAN)).thenReturn("#40E0D0");
        Mockito.when(gui.getMenuName(GUI.NAME_STATES.HIGH_SCORE)).thenReturn("HighScore!");
    }

    @Test
    public void drawElementsTest() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getMenuName(GUI.NAME_STATES.HIGH_SCORE);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.CYAN);
        Mockito.verify(gui,Mockito.times(4)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(5)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5, 5),
                "HighScore!",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,7),
                "Name:",
                "#40E0D0",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,8),
                "(3 Letters)",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,10),
                "Next",
                "#FFFFFF",
                "#000000"
        );
    }
}
