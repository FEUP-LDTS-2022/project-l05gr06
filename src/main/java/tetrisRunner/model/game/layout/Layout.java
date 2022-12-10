package tetrisRunner.model.game.layout;

import tetrisRunner.controller.game.LayoutController;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;
import tetrisRunner.model.game.gameover.GameOverBehavior;
import tetrisRunner.model.game.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Layout {
    private final int width;
    private final int height;
    private GameOverBehavior gameOverBehavior;
    private Jacob jacob;

    private List<Wall> walls;
    private Shape fallingShape;

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

    public Shape getShape() {
        return fallingShape;
    }

    public void setShape(Shape fallingShape) {
        this.fallingShape = fallingShape;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
    }
    public void removeBlocks(List<Block> blocksList) {
        for(Block block : blocksList){blocks.remove(block);}
    }


    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        for (Block block : blocks){
            if (block.getPosition().equals(position))
                return false;}
        for (Position pos : fallingShape.getShapePos()){
            if(pos.equals(position)) return false;
        }

        return true;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public boolean isLineComplete(int y){
        boolean isBlock;
        Position position;

        for(int xi=1; xi<width-1;xi++){
            position = new Position(xi,y);

            isBlock = false;
            for (Block block : blocks){
                if (block.getPosition().equals(position))
                    isBlock = true;}

            if(!isBlock) return false;
        }
        return true;
    }

    public boolean checkOver() {
        for(Block block : blocks){
            if(block.getPosition().getY()<1){
                return true;
            }
        }
        return false;
    }

    public void setGameOverBehavior(GameOverBehavior gameOverBehavior) {
        this.gameOverBehavior = gameOverBehavior;
    }

    public boolean gameOverStatus(LayoutController layoutController, long time){
        return this.gameOverBehavior.gameOverStatus(layoutController, time);
    }

    public GameOverBehavior getGameOverBehavior() {
        return gameOverBehavior;
    }
}
