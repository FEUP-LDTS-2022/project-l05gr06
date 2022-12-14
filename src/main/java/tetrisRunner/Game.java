package tetrisRunner;

import tetrisRunner.gui.LanternaGUI;
import tetrisRunner.model.game.layout.MatchScore;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.music.Music;
import tetrisRunner.states.StartMenuState;
import tetrisRunner.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private Music music;

    private MatchScore matchScore = new MatchScore();
    public MatchScore getMatchScore() {
        return matchScore;
    }


    public int FPS = 40;

    public Music getMusic() {
        return music;
    }

    public int getFPS() {
        return FPS;
    }

    public Game() throws FontFormatException, IOException, URISyntaxException {


        this.gui = new LanternaGUI(20, 20);
        this.state = new StartMenuState(new StartMenu());

        this.music = new Music("./src/main/resources/music/theme.wav");
        //music.runMusic();

    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {

        new Game().start();

    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {

        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}
