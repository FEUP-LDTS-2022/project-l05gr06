package tetrisRunner.model.game.gamebehavior;

import tetrisRunner.controller.game.LayoutController;

public interface GameBehavior {
    boolean gameOverStatus(LayoutController layoutController, long time);
    boolean scoreOrTimer();
    void incrementScore(double num);
    String getScore();
    void leaderboardUpdate();

}
