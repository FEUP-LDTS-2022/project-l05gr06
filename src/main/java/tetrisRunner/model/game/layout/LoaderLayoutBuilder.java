package tetrisRunner.model.game.layout;

import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;

import java.util.ArrayList;
import java.util.List;

public class LoaderLayoutBuilder extends LayoutBuilder{
    private final int startPosX;
    private final int startPosY;

    public LoaderLayoutBuilder() {
        this.startPosX = getWidth()/2;
        this.startPosY = getHeight()-3;
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
    protected List<Block> createBlocks(){
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(15,getHeight()-3));
        blocks.add(new Block(16,getHeight()-3));
        blocks.add(new Block(17,getHeight()-3));
        blocks.add(new Block(15,getHeight()-4));
        return blocks;
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
