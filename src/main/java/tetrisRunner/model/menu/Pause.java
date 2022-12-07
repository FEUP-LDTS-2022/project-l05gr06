package tetrisRunner.model.menu;

import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.states.State;

import java.util.Arrays;

public class Pause extends Menu{
    private final State gameState;
    public Pause(State gameState) {
        super.entries = Arrays.asList("Return to Game", "Main Menu", "Settings", "Exit");
        this.gameState = gameState;
    }

    public boolean isSelectedGame() {
        return isSelected(0);
    }

    public boolean isSelectedMenu() {
        return isSelected(1);
    }

    public boolean isSelectedSettings() {
        return isSelected(2);
    }

    public boolean isSelectedExit() {
        return isSelected(3);
    }

    public State<Layout> getGameState() {
        return gameState;
    }
}

