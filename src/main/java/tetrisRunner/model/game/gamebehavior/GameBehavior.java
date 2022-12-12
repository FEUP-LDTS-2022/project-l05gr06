package tetrisRunner.model.game.gamebehavior;

import tetrisRunner.controller.game.LayoutController;

public interface GameBehavior {
    boolean gameOverStatus(LayoutController layoutController, long time);
    boolean scoreOrTimer();

    boolean instaDropAvailable();
    void incrementScore(double num);
    String getScore();
    void leaderboardUpdate();

}
