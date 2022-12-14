package tetrisRunner.viewer.menu;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.HighScore;
import tetrisRunner.viewer.Viewer;

public class HighScoreViewer extends Viewer<HighScore> {
    public HighScoreViewer(HighScore model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(
                new Position(5, 5),
                gui.getMenuName(GUI.NAME_STATES.HIGH_SCORE),
                gui.getStringColor(GUI.COLOR.WHITE),
                gui.getStringColor(GUI.COLOR.BLACK));

        gui.drawText(
                new Position(5, 8),
                "(3 Letters)",
                gui.getStringColor(GUI.COLOR.WHITE),
                gui.getStringColor(GUI.COLOR.BLACK));

        gui.drawText(
                new Position(5+getModel().getEntry(0).length(),7),
                getModel().getName(),
                gui.getStringColor(GUI.COLOR.WHITE),
                gui.getStringColor(GUI.COLOR.BLACK));

        for (int i = 0; i < getModel().getNumberEntries(); i++){
            gui.drawText(
                    new Position(5, 7 + 3*i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? gui.getStringColor(GUI.COLOR.CYAN) : gui.getStringColor(GUI.COLOR.WHITE),
                    gui.getStringColor(GUI.COLOR.BLACK));
        }
    }
}
