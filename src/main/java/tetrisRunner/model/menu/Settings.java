package tetrisRunner.model.menu;

import tetrisRunner.music.Music;

import java.util.Arrays;

public class Settings extends Menu{

    public Settings() {
        super.entries = Arrays.asList(!Music.isMuted() ? "Mute" : "Unmute", "Volume UP", "Volume DOWN", "Return");
    }

    public void switchMute() {
        if (super.entries.get(0) == "Mute") super.entries.set(0, "Unmute");
        else super.entries.set(0, "Mute");
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

