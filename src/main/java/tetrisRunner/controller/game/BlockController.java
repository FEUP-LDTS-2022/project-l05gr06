package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.layout.Layout;

import java.io.IOException;
import java.util.List;

public class BlockController extends GameController {
    private long lastMovementBlock;
    static final long fallTimeBlock = 700;

    final int ground;
    public BlockController(Layout layout){
        super(layout);
        this.lastMovementBlock = 0;
        this.ground  = getModel().getHeight()-2;
    }
    public void fallBlock(){
        List<Block> blocks = getModel().getBlocks();
        for(Block block:blocks){
            Position position =block.getPosition().fall();
            moveBlock(position,block);
        }
    }
    private void moveBlock(Position position,Block block) {
        if (getModel().isEmpty(position)) {
            block.setPosition(position);
        }
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time-lastMovementBlock>fallTimeBlock) {
            fallBlock();
            lastMovementBlock = time;
        }
    }

}
