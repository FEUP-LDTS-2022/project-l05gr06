package tetrisRunner.model.menu;

import java.util.Arrays;

public class Pause extends Menu{
    public Pause() {
        super.entries = Arrays.asList("Return to Game", "Main Menu", "Settings", "Exit");
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
}

