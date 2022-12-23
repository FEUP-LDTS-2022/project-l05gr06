package tetrisRunner.viewer.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.gamebehavior.ClassicBehavior;
import tetrisRunner.model.game.layout.LoaderLayoutBuilder;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.states.GameState;

import java.io.IOException;

public class PauseViewerTest {
    private GUI gui;
    private PauseViewer viewer;
    private Pause pause;

    @BeforeEach
    public void helper(){
        pause = new Pause(new GameState(new LoaderLayoutBuilder(new ClassicBehavior()).createLayout()));
        gui = Mockito.mock(GUI.class);
        viewer = new PauseViewer(pause);
        Mockito.when(gui.getStringColor(GUI.COLOR.WHITE)).thenReturn("#FFFFFF");
        Mockito.when(gui.getStringColor(GUI.COLOR.BLACK)).thenReturn("#000000");
        Mockito.when(gui.getStringColor(GUI.COLOR.CYAN)).thenReturn("#40E0D0");
        Mockito.when(gui.getMenuName(GUI.NAME_STATES.PAUSE)).thenReturn("Game Paused");
    }

    @Test
    public void drawElementsTest() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getMenuName(GUI.NAME_STATES.PAUSE);
        Mockito.verify(gui,Mockito.times(3)).getStringColor(GUI.COLOR.CYAN);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.RED);
        Mockito.verify(gui,Mockito.times(4)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(5)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5, 5),
                "Game Paused",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,7),
                "Return to Game",
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
                "Settings",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,10),
                "Exit",
                "#FFFFFF",
                "#000000"
        );
    }
}
