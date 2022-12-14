package tetrisRunner.model.menu;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.gamebehavior.GameBehavior;

import java.util.Arrays;

public class GameOver extends Menu {

    GUI.NAME_STATES title;
    public GameOver(GUI.NAME_STATES title) {
        this.title = title;
        super.entries = Arrays.asList("Play Again","Main Menu","Exit");
    }

    public GUI.NAME_STATES getTitle() {
        return title;
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
