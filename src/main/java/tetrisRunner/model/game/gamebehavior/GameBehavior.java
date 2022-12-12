package tetrisRunner.model.game.gamebehavior;

import tetrisRunner.controller.game.LayoutController;

public interface GameBehavior {
    boolean gameOverStatus(LayoutController layoutController);
    boolean gameOverWin(LayoutController layoutController);
    boolean scoreOrTimer();
    void incrementScore(double num);
    String getScore();
    boolean checkLeaderboardUpdate();

}
