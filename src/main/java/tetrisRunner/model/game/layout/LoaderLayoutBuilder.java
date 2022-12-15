package tetrisRunner.model.game.layout;

import tetrisRunner.model.game.elements.*;
import tetrisRunner.model.game.shapes.Shape;
import tetrisRunner.model.game.shapes.*;
import tetrisRunner.model.game.gamebehavior.GameBehavior;

import java.util.ArrayList;
import java.util.List;

public class LoaderLayoutBuilder extends LayoutBuilder{
    private final int startPosX;
    private final int startPosY;

    private final GameBehavior gameBehavior;

    public LoaderLayoutBuilder(GameBehavior gameBehavior) {
        this.startPosX = getWidth()/2;
        this.startPosY = getHeight()-3;
        this.gameBehavior = gameBehavior;
    }

    @Override
    protected int getWidth(){
        return 20;
    }
    @Override
    protected int getHeight(){
        return 20;
    }
    @Override
    protected Jacob createJacob(){
        return new Jacob(startPosX,startPosY);
    }
    @Override
    protected Shape createShape(){
        ShapeFactory factory = new RandomShapeFactory();
        return factory.createShape();
    }
    @Override
    protected List<Coin> createCoins() {
        ElementFactory<Coin> factory = new CoinFactory();
        List<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            coins.add(factory.createElement());
        }
        return coins;
    }

    @Override
    protected List<Block> initializeBlocks() {
        return  new ArrayList<>();
    }

    @Override
    protected GameBehavior typeGameOver() {
        return this.gameBehavior;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < getWidth(); c++) {
            walls.add(new Wall(c, getHeight()-2));
        }
        for (int r = 0; r < getHeight() - 1 ; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(getWidth() - 1, r));
        }
        return walls;
    }
}
