package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.layout.Layout;

import java.io.IOException;

public class JacobController extends GameController{
    private long lastMovementJacob;

    static final long fallTimeJacob = 300;

    
    final int ground;

    public JacobController(Layout layout){
        super(layout);
        this.lastMovementJacob = 0;
        this.ground  = getModel().getHeight()-2;
    }

    public void moveJacobLeft(){
        moveJacob(getModel().getJacob().getPosition().getLeft());
    }
    public void moveJacobRight(){
        moveJacob(getModel().getJacob().getPosition().getRight());
    }
    public void jumpJacob(){
        int x = getModel().getJacob().getPosition().getX();
        int y = getModel().getJacob().getPosition().getY();
        for(int i=0;i<2;i++){
            Position position = new Position(x,y+1);
            if (!getModel().isEmpty(position) ) {
                moveJacob(getModel().getJacob().getPosition().jump());
            }
        }
    }
    public void fallJacob(){
        if (getModel().getJacob().getPosition().getY() < (ground-1)){
            moveJacob(getModel().getJacob().getPosition().fall());
        }
    }
    public boolean isFalling() {
        Position position = getModel().getJacob().getPosition();
        if (!getModel().isEmpty(position.fall()))
            return false;

        return true;
    }


    private void moveJacob(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getJacob().setPosition(position);
        }
    }
    public boolean jacobIsAlive(){
        Position position = getModel().getJacob().getPosition();
        return getModel().isEmpty(position);
    }

    public boolean hasReachedTop(){

        if(getModel().getJacob().getPosition().getY() == -1 &&
          (getModel().getJacob().getPosition().getX() == 0 ||
           getModel().getJacob().getPosition().getX() == getModel().getWidth()-1)) return true;

        return false;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time-lastMovementJacob>fallTimeJacob) {
            fallJacob();
            lastMovementJacob = time;
        }
        switch (action) {
            case UP -> jumpJacob();
            case JACOB_LEFT -> moveJacobLeft();
            case JACOB_RIGHT -> moveJacobRight();
        }

    }
}
