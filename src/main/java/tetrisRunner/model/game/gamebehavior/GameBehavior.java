package tetrisRunner.model.game.gamebehavior;

import tetrisRunner.controller.game.LayoutController;

public interface GameBehavior {
    boolean gameOverStatus(LayoutController layoutController);
    boolean gameOverWin(LayoutController layoutController);
    boolean isClassic();

    boolean isPvP();
    boolean instaDropAvailable();
    void incrementScore(double num);
    String getScoreString();
    double getScoreNumber();
    boolean checkLeaderboardUpdate();

}
