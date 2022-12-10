package tetrisRunner.model.game.layout;

import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;
import tetrisRunner.model.game.gameover.GameOverBehavior;
import tetrisRunner.model.game.shapes.Shape;

import java.util.List;

public abstract class LayoutBuilder {

    public Layout createLayout(){
        Layout layout = new Layout(getWidth(),getHeight());
        layout.setGameOverBehavior(typeGameOver());
        layout.setJacob(createJacob());
        layout.setWalls(createWalls());
        layout.setShape(createShape());
        layout.setBlocks(initializeBlocks());
        return layout;
    }
    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract Jacob createJacob();

    protected abstract Shape createShape();

    protected abstract List<Wall> createWalls();
    protected abstract List<Block> initializeBlocks();
    protected abstract GameOverBehavior typeGameOver();

}
