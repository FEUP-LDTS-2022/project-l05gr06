package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.model.menu.Settings;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.states.PauseState;
import tetrisRunner.states.SettingsState;
import tetrisRunner.states.StartMenuState;

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
        switch (action){
            case ESCAPE:
                game.setState(new PauseState(new Pause()));
                break;
            default:
                jacobController.step(game, action, time);
                shapeController.step(game,action,time);
        }
    }
}
