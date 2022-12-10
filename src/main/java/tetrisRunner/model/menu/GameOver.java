package tetrisRunner.model.menu;

import tetrisRunner.model.game.gameover.GameOverBehavior;

import java.util.Arrays;

public class GameOver extends Menu {
    private GameOverBehavior gameOverBehavior;
    public GameOver() {
        super.entries = Arrays.asList("Play Again","Main Menu","Exit");
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

}
