package tetrisRunner.model.menu;

import java.util.Arrays;

public class StartMenu extends Menu{
    public StartMenu() {
        super.entries = Arrays.asList("Start", "Instructions", "Exit");
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedInstructions() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
}
