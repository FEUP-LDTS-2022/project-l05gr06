package tetrisRunner;

import tetrisRunner.gui.LanternaGUI;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.music.Music;
import tetrisRunner.states.StartMenuState;
import tetrisRunner.states.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;



    public Game() throws FontFormatException, IOException, URISyntaxException {

        //window
        this.gui = new LanternaGUI(20, 20);
        this.state = new StartMenuState(new StartMenu());

        //Music
        //Music.runMusic("./src/main/resources/music/theme.wav");


    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {

        new Game().start();

    }


    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        int FPS = 40;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, frameTime);

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
