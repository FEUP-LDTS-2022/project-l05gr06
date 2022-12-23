package tetrisRunner.viewer.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.Leaderboard;
import tetrisRunner.model.menu.SelectMode;

import java.io.BufferedReader;
import java.io.IOException;

public class LeaderboardViewerTest {
    private GUI gui;
    private LeaderboardViewer viewer;
    private Leaderboard leaderboard;

    @BeforeEach
    public void helper(){
        leaderboard = new Leaderboard();
        gui = Mockito.mock(GUI.class);
        viewer = new LeaderboardViewer(leaderboard);
        Mockito.when(gui.getStringColor(GUI.COLOR.WHITE)).thenReturn("#FFFFFF");
        Mockito.when(gui.getStringColor(GUI.COLOR.BLACK)).thenReturn("#000000");
        Mockito.when(gui.getStringColor(GUI.COLOR.CYAN)).thenReturn("#40E0D0");
        Mockito.when(gui.getMenuName(GUI.NAME_STATES.LEADERBOARD)).thenReturn("Leaderboard");
    }

    @Test
    public void drawElementsClassicTest() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getMenuName(GUI.NAME_STATES.LEADERBOARD);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.CYAN);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.ORANGE);
        Mockito.verify(gui,Mockito.times(10)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(11)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5, 5),
                "Leaderboard",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,16),
                "Climbing ->",
                "#40E0D0",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,17),
                "Return",
                "#FFFFFF",
                "#000000"
        );

        for (int i=0; i<8; i++){
            Mockito.verify(gui,Mockito.times(1)).drawText(
                    Mockito.eq(new Position(5,7)),
                    Mockito.anyString(),
                    Mockito.eq("#FFFFFF"),
                    Mockito.eq("#000000")
            );
        }
    }
    @Test
    public void drawElementsClimbingTest() throws IOException {
        leaderboard.changeLeaderboard();
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getMenuName(GUI.NAME_STATES.LEADERBOARD);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.CYAN);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.ORANGE);
        Mockito.verify(gui,Mockito.times(10)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(11)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5, 5),
                "Leaderboard",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,16),
                "<- Classic",
                "#40E0D0",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,17),
                "Return",
                "#FFFFFF",
                "#000000"
        );

        for (int i=0; i<8; i++){
            Mockito.verify(gui,Mockito.times(1)).drawText(
                    Mockito.eq(new Position(5,7)),
                    Mockito.anyString(),
                    Mockito.eq("#FFFFFF"),
                    Mockito.eq("#000000")
            );
        }
    }
}
