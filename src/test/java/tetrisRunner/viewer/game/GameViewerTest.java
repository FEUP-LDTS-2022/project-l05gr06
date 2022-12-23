package tetrisRunner.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Coin;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;
import tetrisRunner.model.game.gamebehavior.ClassicBehavior;
import tetrisRunner.model.game.gamebehavior.PvPBehavior;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.shapes.ShapeI;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GameViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Layout layout;
    @BeforeEach
    public void helper(){
        layout = new Layout(20,20);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(layout);
        layout.setJacob(new Jacob(2,18));
        layout.setBlocks(Arrays.asList(new Block(1,18, GUI.COLOR.YELLOW),
                new Block(1,17, GUI.COLOR.GREEN), new Block(1,16, GUI.COLOR.BLUE)));
        layout.setWalls(Arrays.asList(new Wall(0,18), new Wall(0,19), new Wall(1,19),
                new Wall(2,19)));
        layout.setShape(new ShapeI(Arrays.asList(new Position(8, 0),
            new Position(9, 0),
            new Position(10, 0),
            new Position(11, 0))));
        layout.setCoins(Arrays.asList(new Coin(1,1), new Coin(2,2)));
        layout.setGameOverBehavior(new ClassicBehavior());
        Mockito.when(gui.getStringColor(GUI.COLOR.BRICK)).thenReturn("#BC4A3C");
        Mockito.when(gui.getStringColor(GUI.COLOR.WHITE)).thenReturn("#FFFFFF");
    }
    @Test
    public void drawElementsNotPvPTest() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui,Mockito.times(1)).paintBackground(GUI.COLOR.CYAN, 20, 20);

        Mockito.verify(gui,Mockito.times(1)).drawJacob(new Position(2,18));
        Mockito.verify(gui,Mockito.times(1)).drawJacob(Mockito.any(Position.class));

        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(0,18));
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(0,19));
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(1,19));
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(2,19));
        Mockito.verify(gui,Mockito.times(4)).drawWall(Mockito.any(Position.class));

        Mockito.verify(gui,Mockito.times(1)).drawCoin(new Position(1,1));
        Mockito.verify(gui,Mockito.times(1)).drawCoin(new Position(2,2));
        Mockito.verify(gui,Mockito.times(2)).drawCoin(Mockito.any(Position.class));

        Mockito.verify(gui,Mockito.times(1)).drawBlock(new Position(1,18), GUI.COLOR.YELLOW);
        Mockito.verify(gui,Mockito.times(1)).drawBlock(new Position(1,17), GUI.COLOR.GREEN);
        Mockito.verify(gui,Mockito.times(1)).drawBlock(new Position(1,16), GUI.COLOR.BLUE);
        Mockito.verify(gui,Mockito.times(3)).drawBlock(Mockito.any(Position.class), Mockito.any(GUI.COLOR.class));

        Mockito.verify(gui,Mockito.times(1)).drawShape(Arrays.asList(new Position(8, 0),
                new Position(9, 0),
                new Position(10, 0),
                new Position(11, 0)), GUI.COLOR.PINK);
        Mockito.verify(gui,Mockito.times(1)).drawShape(Mockito.anyList(), Mockito.any(GUI.COLOR.class));

        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.BRICK);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(1,19),
                "0",
                "#FFFFFF",
                "#BC4A3C"
        );
    }
    @Test
    public void drawElementsPvPTest() throws IOException {
        layout.setGameOverBehavior(new PvPBehavior());
        viewer.draw(gui);

        Mockito.verify(gui,Mockito.times(1)).paintBackground(GUI.COLOR.CYAN, 20, 20);

        Mockito.verify(gui,Mockito.times(1)).drawJacob(new Position(2,18));
        Mockito.verify(gui,Mockito.times(1)).drawJacob(Mockito.any(Position.class));

        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(0,18));
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(0,19));
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(1,19));
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(2,19));
        Mockito.verify(gui,Mockito.times(4)).drawWall(Mockito.any(Position.class));

        Mockito.verify(gui,Mockito.times(1)).drawCoin(new Position(1,1));
        Mockito.verify(gui,Mockito.times(1)).drawCoin(new Position(2,2));
        Mockito.verify(gui,Mockito.times(2)).drawCoin(Mockito.any(Position.class));

        Mockito.verify(gui,Mockito.times(1)).drawBlock(new Position(1,18), GUI.COLOR.YELLOW);
        Mockito.verify(gui,Mockito.times(1)).drawBlock(new Position(1,17), GUI.COLOR.GREEN);
        Mockito.verify(gui,Mockito.times(1)).drawBlock(new Position(1,16), GUI.COLOR.BLUE);
        Mockito.verify(gui,Mockito.times(3)).drawBlock(Mockito.any(Position.class), Mockito.any(GUI.COLOR.class));

        Mockito.verify(gui,Mockito.times(1)).drawShape(Arrays.asList(new Position(8, 0),
                new Position(9, 0),
                new Position(10, 0),
                new Position(11, 0)), GUI.COLOR.PINK);
        Mockito.verify(gui,Mockito.times(1)).drawShape(Mockito.anyList(), Mockito.any(GUI.COLOR.class));

        Mockito.verify(gui,Mockito.times(2)).getStringColor(GUI.COLOR.BRICK);
        Mockito.verify(gui,Mockito.times(2)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(1,19),
                "01:00",
                "#FFFFFF",
                "#BC4A3C"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(15,19),
                " 0-0",
                "#FFFFFF",
                "#BC4A3C"
        );
    }
}
