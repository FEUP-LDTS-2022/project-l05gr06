import gui.LanternaGUI;
import states.MenuState;
import states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {

    private final LanternaGUI gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(20, 20);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) {
        System.out.println("Hello world2!");
    }
}