package tetrisRunner.viewer.menu;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.Leaderboard;
import tetrisRunner.viewer.Viewer;

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

        String color;
        for (int i = 0; i < getModel().getNumberEntries(); i++){
            if ("Return".equals(getModel().getEntry(i))) {
                color = gui.getStringColor(GUI.COLOR.ORANGE);
            } else {
                color = gui.getStringColor(GUI.COLOR.CYAN);
            }
            gui.drawText(
                    new Position(5, 14 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? color : gui.getStringColor(GUI.COLOR.WHITE),
                    gui.getStringColor(GUI.COLOR.BLACK));
        }
    }
}
