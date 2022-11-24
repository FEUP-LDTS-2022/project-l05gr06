package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.menu.Settings;
import tetrisRunner.states.SettingsState;

import java.io.IOException;

public class LayoutController extends GameController{
    private final JacobController jacobController;
    public LayoutController(Layout model) {
        super(model);
        jacobController = new JacobController(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action){
            case ESCAPE:
                break;
            default:
                jacobController.step(game, action, time);
        }
    }
}
