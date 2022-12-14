package tetrisRunner.controller.menu;

import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.Leaderboard;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;

public class LeaderboardController extends Controller<Leaderboard> {
    public LeaderboardController(Leaderboard model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case ARROW_UP:
                getModel().previousEntry();
                break;
            case ARROW_DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedReturn()) game.setState(new StartMenuState(new StartMenu()));
                if (getModel().isSelectedChangeLeaderboard()) getModel().changeLeaderboard();
        }
    }
}
