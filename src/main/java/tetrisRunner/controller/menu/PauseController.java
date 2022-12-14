package tetrisRunner.controller.menu;

import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.model.menu.Settings;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.states.SettingsState;
import tetrisRunner.states.StartMenuState;


import java.io.IOException;

public class PauseController extends Controller<Pause> {
    public PauseController(Pause pause){
        super(pause);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case ARROW_UP -> getModel().previousEntry();
            case ARROW_DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedSettings()) {
                    game.setState(new SettingsState(new Settings(game.getMusic().isMuted(), getModel().getGameState())));
                }
                if (getModel().isSelectedMenu()) game.setState(new StartMenuState(new StartMenu()));
                if (getModel().isSelectedGame()) game.setState(getModel().getGameState());
            }
        }
    }
}

