package tetrisRunner.model.menu;

import java.util.Arrays;

public class Leaderboard extends Menu{
    public Leaderboard() {
        super.entries = Arrays.asList("Return");
    }
    public boolean isSelectedReturn() {
        return isSelected(0);
    }
}
