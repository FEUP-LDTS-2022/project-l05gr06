package tetrisRunner.model.game.gameover;

import tetrisRunner.controller.game.LayoutController;
import tetrisRunner.model.game.gameover.GameOverBehavior;
import tetrisRunner.model.game.layout.Layout;

public class PvPBehavior implements GameOverBehavior {
    @Override
    public boolean gameOverStatus(LayoutController layoutController, long time) {
        return false;
    }

    @Override
    public void leaderboardUpdate() {

    }
}
