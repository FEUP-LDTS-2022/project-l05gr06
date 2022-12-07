package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.states.GameOverState;
import tetrisRunner.states.PauseState;

import java.io.IOException;

public class LayoutController extends GameController{
    private final JacobController jacobController;
    private final ShapeController shapeController;
    public LayoutController(Layout model) {
        super(model);
        jacobController = new JacobController(model);
        shapeController = new ShapeController(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.ESCAPE) {
            game.setState(new PauseState(new Pause(game.getState())));
        } else {
            if (!jacobController.JacobIsAlive()) {
                game.setState(new GameOverState(new GameOver()));
            }
            jacobController.step(game, action, time);
            shapeController.step(game, action, time);
        }
    }
}
