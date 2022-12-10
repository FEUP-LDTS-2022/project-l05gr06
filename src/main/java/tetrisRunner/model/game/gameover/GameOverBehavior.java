package tetrisRunner.model.game.gameover;

import tetrisRunner.controller.game.LayoutController;

public interface GameOverBehavior {
    boolean gameOverStatus(LayoutController layoutController, long time);
    void leaderboardUpdate();

}
