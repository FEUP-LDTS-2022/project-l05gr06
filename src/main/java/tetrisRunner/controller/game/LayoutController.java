package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.layout.Layout;

import java.io.IOException;

public class LayoutController extends GameController{
    public LayoutController(Layout model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

    }
}
