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
        moveHero(getModel().getJacob().getPosition().getLeft());
    }
    public void moveJacobRight(){
        moveHero(getModel().getJacob().getPosition().getRight());
    }
    private void moveHero(Position position) {
            getModel().getJacob().setPosition(position);
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
