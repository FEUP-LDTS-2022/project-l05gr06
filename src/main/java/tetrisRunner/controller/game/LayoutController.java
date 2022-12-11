package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.gameover.ClimbingBehavior;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.shapes.Shape;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.states.GameOverState;
import tetrisRunner.states.PauseState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LayoutController extends GameController{
    private final JacobController jacobController;
    private final ShapeController shapeController;
    public LayoutController(Layout model) {
        super(model);
        jacobController = new JacobController(model);
        shapeController = new ShapeController(model);
    }

    public void clearLine(int y){
        List<Block> blocksToGo = new ArrayList<>();
        for (Block block : getModel().getBlocks()){
            if(block.getPosition().getY() == y) {
                blocksToGo.add(block);
            }
            else if (block.getPosition().getY() < y) block.setPosition(block.getPosition().fall());
        }
        getModel().removeBlocks(blocksToGo);
    }

    public JacobController getJacobController() {
        return jacobController;
    }

    public void transform(){
        for (int yi = 1; yi< getModel().getHeight()-2;yi++)
        if(getModel().isLineComplete(yi)) clearLine(yi);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.ESCAPE) {
            game.setState(new PauseState(new Pause(game.getState())));
        }
        else if (getModel().gameOverStatus(this,time))
            game.setState(new GameOverState(new GameOver(getModel().getGameOverBehavior())));

        transform();
        jacobController.step(game, action, time);
        shapeController.step(game, action, time);
    }

}
