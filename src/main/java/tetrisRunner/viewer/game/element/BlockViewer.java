package tetrisRunner.viewer.game.element;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.elements.Block;

public class BlockViewer implements ElementViewer<Block>{
    public void draw(Block block, GUI gui){
        gui.drawBlock(block.getPosition(),block.getColor());
    }
}
