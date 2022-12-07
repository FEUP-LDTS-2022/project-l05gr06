package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.shapes.Shape;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.states.GameOverState;
import tetrisRunner.states.PauseState;

import java.io.IOException;
import java.util.List;

public class LayoutController extends GameController{
    private final JacobController jacobController;
    private final ShapeController shapeController;
    public LayoutController(Layout model) {
        super(model);
        jacobController = new JacobController(model);
        shapeController = new ShapeController(model);
    }

    public void Transform(){
        List<Shape> shapes = getModel().getShapes();
        for(Shape shape: shapes){
            if(!shapeController.isFalling(shape)){
                for (Position position : shape.getShapePos()){
                    getModel().addBlock(new Block(position.getX(), position.getY(), shape.getColor()));
                }
                getModel().removeShape(shape);
            }
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.ESCAPE) {
            game.setState(new PauseState(new Pause(game.getState())));
        } else {
            if (!jacobController.jacobIsAlive() && !jacobController.isFalling()) {
                game.setState(new GameOverState(new GameOver()));
            }
            Transform();
            jacobController.step(game, action, time);
            shapeController.step(game, action, time);
        }
    }
}
