package tetrisRunner.viewer.game.element;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin>{
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}
