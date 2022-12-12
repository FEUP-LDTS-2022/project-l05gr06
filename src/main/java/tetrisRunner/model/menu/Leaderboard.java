package tetrisRunner.model.menu;

import java.util.Arrays;

public class Leaderboard extends Menu{
    private boolean isClassic;
    public Leaderboard() {
        super.entries = Arrays.asList("Climbing ->", "Return");
        isClassic = true;
    }
    public boolean isSelectedChangeLeaderboard(){
        return isSelected(0);
    }
    public boolean isSelectedReturn() {
        return isSelected(1);
    }
    public void changeLeaderboard(){
        if (super.entries.get(0).equals("Climbing ->")){
            super.entries.set(0, "<- Classic");
            isClassic = false;
        } else{
            super.entries.set(0, "Climbing ->");
            isClassic = true;
        }
    }
    public boolean isClassic(){
        return isClassic;
    }
}
