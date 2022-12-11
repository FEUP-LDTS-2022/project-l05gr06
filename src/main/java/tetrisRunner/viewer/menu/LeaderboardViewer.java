package tetrisRunner.viewer.menu;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.Leaderboard;
import tetrisRunner.viewer.Viewer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeaderboardViewer extends Viewer<Leaderboard> {
    public LeaderboardViewer(Leaderboard model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(
                new Position(5, 5),
                gui.getMenuName(GUI.NAME_STATES.LEADERBOARD),
                gui.getStringColor(GUI.COLOR.WHITE),
                gui.getStringColor(GUI.COLOR.BLACK));

        String file = "docs/leaderboard/classicLeaderboard.txt";
        int j = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();

            while (line != null) {
                gui.drawText(new Position(5, 7 + j), line,
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                line = br.readLine();
                j++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String color;
        for (int i = 0; i < getModel().getNumberEntries(); i++){
            if ("Return".equals(getModel().getEntry(i))) {
                color = gui.getStringColor(GUI.COLOR.ORANGE);
            } else {
                color = gui.getStringColor(GUI.COLOR.CYAN);
            }
            gui.drawText(
                    new Position(5, 16 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? color : gui.getStringColor(GUI.COLOR.WHITE),
                    gui.getStringColor(GUI.COLOR.BLACK));
        }
    }
}
