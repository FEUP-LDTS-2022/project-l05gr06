package tetrisRunner.viewer.game.element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Coin;

public class CoinViewerTest {
    private Coin coin;
    private GUI gui;
    private CoinViewer viewer;
    @BeforeEach
    public void helper(){
        coin = new Coin(1,2);
        gui = Mockito.mock(GUI.class);
        viewer = new CoinViewer();
    }
    @Test
    public void drawTest(){
        viewer.draw(coin,gui);
        Mockito.verify(gui,Mockito.times(1)).drawCoin(new Position(1,2));
    }
}
