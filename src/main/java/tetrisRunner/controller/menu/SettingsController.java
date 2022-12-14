package tetrisRunner.controller.menu;

import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.model.menu.Settings;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.states.PauseState;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;

public class SettingsController extends Controller<Settings> {

    public SettingsController(Settings settings) {
        super(settings);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case ARROW_UP -> getModel().previousEntry();
            case ARROW_DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedMute()) {
                    getModel().switchMute();
                    game.getMusic().volumeMute();
                }
                if (getModel().isSelectedVolumeUp()) game.getMusic().volumeUp();
                if (getModel().isSelectedVolumeDown()) game.getMusic().volumeDown();
                if (getModel().isSelectedReturn()) {
                    if (getModel().getGameState() != null)
                        game.setState(new PauseState(new Pause(getModel().getGameState())));
                    else game.setState(new StartMenuState(new StartMenu()));
                }
            }
        }
    }
}