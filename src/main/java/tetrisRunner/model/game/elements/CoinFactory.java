package tetrisRunner.model.game.elements;

import java.util.concurrent.ThreadLocalRandom;

public class CoinFactory extends ElementFactory<Coin>{
    @Override
    public Coin createElement() {
        int width = 20;
        int height = 20;
        int randomX = ThreadLocalRandom.current().nextInt(1, width-1);
        int randomY = ThreadLocalRandom.current().nextInt(4, height-2);
        return new Coin(randomX, randomY);
    }
}
