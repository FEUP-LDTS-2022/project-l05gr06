package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.layout.Layout;

import java.io.IOException;

public class JacobController extends GameController{
    public JacobController(Layout layout){
        super(layout);
    }

    public void moveJacobLeft(){
        moveJacob(getModel().getJacob().getPosition().getLeft());
    }
    public void moveJacobRight(){
        moveJacob(getModel().getJacob().getPosition().getRight());
    }
    private void moveJacob(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getJacob().setPosition(position);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action){
            case LEFT:
                moveJacobLeft();
                break;
            case RIGHT:
                moveJacobRight();
                break;
        }

    }
}
