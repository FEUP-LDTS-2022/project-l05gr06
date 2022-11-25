package tetrisRunner.model.game.layout;

import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;

import java.util.List;

public class Layout {
    private final int width;
    private final int height;
    private Jacob jacob;

    private List<Wall> walls;
    private List<Block> blocks;
    public Layout(int width,int height){
        this.width = width;
        this.height = height;
    }
    public Jacob getJacob(){
        return jacob;
    }

    public void setJacob(Jacob jacob) {
        this.jacob = jacob;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        for (Block block : blocks)
            if (block.getPosition().equals(position))
                return false;
        return true;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
