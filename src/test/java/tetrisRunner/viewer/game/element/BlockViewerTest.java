package tetrisRunner.viewer.game.element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;

public class BlockViewerTest {
    private Block block;
    private GUI gui;
    private BlockViewer viewer;
    @BeforeEach
    public void helper(){
        block = new Block(4,4, GUI.COLOR.YELLOW);
        gui = Mockito.mock(GUI.class);
        viewer = new BlockViewer();
    }
    @Test
    public void drawTest(){
        viewer.draw(block,gui);
        Mockito.verify(gui,Mockito.times(1)).drawBlock(new Position(4,4), GUI.COLOR.YELLOW);
    }
}
