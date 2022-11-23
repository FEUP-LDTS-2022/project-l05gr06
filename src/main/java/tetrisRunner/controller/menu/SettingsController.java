package tetrisRunner.controller.menu;

import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.model.menu.Settings;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.music.Music;
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
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedMute()){
                    getModel().switchMute();
                    Music.volumeMute();
                }
                if (getModel().isSelectedUp()) Music.volumeUp();
                if (getModel().isSelectedDown()) Music.volumeDown();
                if (getModel().isSelectedReturn()) {
                    if(Settings.wasPlaying){
                        Settings.wasPlaying = false;
                        game.setState(new PauseState(new Pause()));
                    }
                    else game.setState(new StartMenuState(new StartMenu()));
                }
        }
    }
}