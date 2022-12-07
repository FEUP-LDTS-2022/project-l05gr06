package tetrisRunner.controller.menu;


import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.*;
import tetrisRunner.states.InstructionState;
import tetrisRunner.states.SelectModeState;
import tetrisRunner.states.SettingsState;


import java.io.IOException;

public class StartMenuController extends Controller<StartMenu> {
    public StartMenuController(StartMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedGameMode()) game.setState(new SelectModeState(new SelectMode()));
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedInstructions()) game.setState(new InstructionState(new Instruction()));
                if (getModel().isSelectedSettings())
                    game.setState(new SettingsState(new Settings(game.getMusic().isMuted())));
            }
        }
    }
}
