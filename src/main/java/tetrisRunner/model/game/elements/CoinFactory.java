package tetrisRunner.model.game.elements;

import java.util.concurrent.ThreadLocalRandom;

public class CoinFactory extends ElementFactory{
    @Override
    public Coin createElement() {
        int width = 20;
        int height = 20;
        int randomX = ThreadLocalRandom.current().nextInt(1, width-1);
        int randomY = ThreadLocalRandom.current().nextInt(7, height-5);
        return new Coin(randomX, randomY);
    }
}
