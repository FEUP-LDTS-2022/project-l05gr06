package tetrisRunner.model.game.layout;

import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;

import java.util.List;

public abstract class LayoutBuilder {

    public Layout createLayout(){
        Layout layout = new Layout(getWidth(),getHeight());
        layout.setJacob(createJacob());
        layout.setWalls(createWalls());
        layout.setBlocks(createBlocks());
        return layout;
    }
    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract Jacob createJacob();
    protected abstract List<Block> createBlocks();
    protected abstract List<Wall> createWalls();

}
