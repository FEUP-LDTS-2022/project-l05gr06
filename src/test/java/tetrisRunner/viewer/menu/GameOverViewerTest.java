package tetrisRunner.viewer.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.GameOver;

import java.io.IOException;

public class GameOverViewerTest {
    private GUI gui;
    private GameOverViewer viewer;
    private GameOver gameOver;

    @BeforeEach
    public void helper(){
        gameOver = new GameOver(GUI.NAME_STATES.GAME_OVER);
        gui = Mockito.mock(GUI.class);
        viewer = new GameOverViewer(gameOver);
        Mockito.when(gui.getStringColor(GUI.COLOR.WHITE)).thenReturn("#FFFFFF");
        Mockito.when(gui.getStringColor(GUI.COLOR.BLACK)).thenReturn("#000000");
        Mockito.when(gui.getStringColor(GUI.COLOR.CYAN)).thenReturn("#40E0D0");
        Mockito.when(gui.getMenuName(GUI.NAME_STATES.GAME_OVER)).thenReturn("GameOver");
    }

    @Test
    public void drawElementsTest() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getMenuName(GUI.NAME_STATES.GAME_OVER);
        Mockito.verify(gui,Mockito.times(2)).getStringColor(GUI.COLOR.CYAN);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.RED);
        Mockito.verify(gui,Mockito.times(3)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(4)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5, 5),
                "GameOver",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,7),
                "Play Again",
                "#40E0D0",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,8),
                "Main Menu",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,9),
                "Exit",
                "#FFFFFF",
                "#000000"
        );
    }
}
