package tetrisRunner.model.menu;

import java.util.Arrays;

public class HighScore extends Menu{
    String name;
    double score;
    boolean isClassic;
    public HighScore(boolean isClassic, double score) {
        super.entries = Arrays.asList("Name:", "Next");
        this.isClassic = isClassic;
        this.score = score;
        name = "";
    }
    public boolean isSelectedName() {
        return isSelected(0);
    }
    public boolean isSelectedNext() {
        return isSelected(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void updateLeaderboardClassic(){

    }
    public void updateLeaderboardClimbing(){

    }
}
