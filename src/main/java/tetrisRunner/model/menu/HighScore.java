package tetrisRunner.model.menu;

import java.util.Arrays;

public class HighScore extends Menu{
    String name;
    public HighScore() {
        super.entries = Arrays.asList("Name:", "Next");
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
}
