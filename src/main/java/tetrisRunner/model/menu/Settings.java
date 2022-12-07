package tetrisRunner.model.menu;

import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.music.Music;
import tetrisRunner.states.State;

import java.util.Arrays;

public class Settings extends Menu{

    private State gameState;

    public State getGameState() {
        return gameState;
    }

    public Settings(boolean ismuted) {
        super.entries = Arrays.asList(!ismuted ? "Mute" : "Unmute", "Volume UP", "Volume DOWN", "Return");
    }

    public Settings(boolean ismuted, State<Layout> gameState){
        super.entries = Arrays.asList(!ismuted ? "Mute" : "Unmute", "Volume UP", "Volume DOWN", "Return");
        this.gameState = gameState;
    }

    public void switchMute() {
        if (super.entries.get(0) == "Mute") super.entries.set(0, "Unmute");
        else super.entries.set(0, "Mute");
    }
    public boolean isSelectedMute() {
        return isSelected(0);
    }

    public boolean isSelectedVolumeUp() {
        return isSelected(1);
    }

    public boolean isSelectedVolumeDown() {
        return isSelected(2);
    }

    public boolean isSelectedReturn() {
        return isSelected(3);
    }
}

