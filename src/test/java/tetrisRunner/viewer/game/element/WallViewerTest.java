package tetrisRunner.viewer.game.element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Coin;
import tetrisRunner.model.game.elements.Wall;

public class WallViewerTest {
    private Wall wall;
    private GUI gui;
    private WallViewer viewer;
    @BeforeEach
    public void helper(){
        wall = new Wall(10,-1);
        gui = Mockito.mock(GUI.class);
        viewer = new WallViewer();
    }
    @Test
    public void drawTest(){
        viewer.draw(wall,gui);
        Mockito.verify(gui,Mockito.times(1)).drawWall(new Position(10,-1));
    }
}
