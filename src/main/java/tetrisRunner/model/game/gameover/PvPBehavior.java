package tetrisRunner.model.game.gameover;

import tetrisRunner.controller.game.LayoutController;
import tetrisRunner.model.game.gameover.GameOverBehavior;
import tetrisRunner.model.game.layout.Layout;

public class PvPBehavior implements GameOverBehavior {
    @Override
    public boolean gameOverStatus(LayoutController layoutController, long time) {
        return ((!layoutController.getJacobController().jacobIsAlive() &&
                !layoutController.getJacobController().isFalling())

                || layoutController.getModel().checkOver());
    }

    @Override
    public boolean scoreOrTimer() {
        return false;
    }

    @Override
    public void leaderboardUpdate() {

    }
}
