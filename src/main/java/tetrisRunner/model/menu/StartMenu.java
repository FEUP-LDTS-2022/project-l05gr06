package tetrisRunner.model.menu;

import java.util.Arrays;

public class StartMenu extends Menu{
    public StartMenu() {
        super.entries = Arrays.asList("Game Mode", "Instructions", "Exit");
    }

    public boolean isSelectedGameMode() {
        return isSelected(0);
    }


    public boolean isSelectedInstructions() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
}
