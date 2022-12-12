package tetrisRunner.controller.menu;

import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.model.menu.HighScore;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.states.GameOverState;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;

public class HighScoreController extends Controller<HighScore> {

    public HighScoreController(HighScore model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (getModel().isSelectedName()){

        }
        switch (action) {
            case ARROW_UP:
                getModel().previousEntry();
                break;
            case ARROW_DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedNext() && getModel().getName().length() == 3)
                    game.setState(new GameOverState(new GameOver()));
        }
    }
}
