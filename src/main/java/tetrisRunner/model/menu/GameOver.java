package tetrisRunner.model.menu;

import tetrisRunner.model.game.gameover.GameOverBehavior;

import java.util.Arrays;

public class GameOver extends Menu {
    private final GameOverBehavior gameOverBehavior;
    public GameOver(GameOverBehavior gameOverBehavior) {
        super.entries = Arrays.asList("Play Again","Main Menu","Exit");
        this.gameOverBehavior = gameOverBehavior;
    }
    public boolean isSelectedPlayAgain() {
        return isSelected(0);
    }

    public boolean isSelectedMainMenu() {
        return isSelected(1);
    }
    public boolean isSelectedExit() {
        return isSelected(2);
    }
    public void leaderboardUpdate(){
        this.gameOverBehavior.leaderboardUpdate();
    }
}
