package tetrisRunner.viewer.game.element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Jacob;

public class JacobViewerTest {
    private Jacob jacob;
    private GUI gui;
    private JacobViewer viewer;
    @BeforeEach
    public void helper(){
        jacob = new Jacob(0,1);
        gui = Mockito.mock(GUI.class);
        viewer = new JacobViewer();
    }
    @Test
    public void drawTest(){
        viewer.draw(jacob,gui);
        Mockito.verify(gui,Mockito.times(1)).drawJacob(new Position(0,1));
    }
}
