package tetrisRunner.model.menu;

import java.util.Arrays;

public class Settings extends Menu{

    public Settings() {
        super.entries = Arrays.asList("Mute", "Volume UP", "Volume DOWN", "Return");
    }

    public boolean isSelectedMute() {
        return isSelected(0);
    }

    public boolean isSelectedUp() {
        return isSelected(1);
    }

    public boolean isSelectedDown() {
        return isSelected(2);
    }

    public boolean isSelectedReturn() {
        return isSelected(3);
    }
}

