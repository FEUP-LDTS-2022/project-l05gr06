import gui.LanternaGUI;

import java.io.IOException;

public class Game {
    private final LanternaGUI gui;

    public Game() throws IOException {
        this.gui = new LanternaGUI(40,20);
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.start();
    }

    private void start() throws IOException {

    }
}