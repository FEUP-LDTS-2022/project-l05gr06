package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.layout.Layout;

import java.io.IOException;

public class JacobController extends GameController{
    private long lastMovement;
    static final long falltime = 400;
    public JacobController(Layout layout){
        super(layout);
        this.lastMovement = 0;
    }

    public void moveJacobLeft(){
        moveJacob(getModel().getJacob().getPosition().getLeft());
    }
    public void moveJacobRight(){
        moveJacob(getModel().getJacob().getPosition().getRight());
    }
    public void jumpJacob(){
        if (getModel().getJacob().getPosition().getY() == (getModel().getHeight()-3)){
            moveJacob(getModel().getJacob().getPosition().jump());
        }
    }
    public void fallJacob(){
        if (getModel().getJacob().getPosition().getY() < (getModel().getHeight()-3)){
            moveJacob(getModel().getJacob().getPosition().fall());
        }
    }
    private void moveJacob(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getJacob().setPosition(position);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time-lastMovement>falltime) {
            fallJacob();
            lastMovement = time;
        }
        switch (action){
            case LEFT:
                moveJacobLeft();
                break;
            case RIGHT:
                moveJacobRight();
                break;
            case UP:
                jumpJacob();
                break;

        }

    }
}
