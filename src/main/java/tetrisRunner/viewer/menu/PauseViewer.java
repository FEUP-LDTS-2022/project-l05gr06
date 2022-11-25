package tetrisRunner.viewer.menu;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.viewer.Viewer;

public class PauseViewer extends Viewer<Pause> {
    public PauseViewer(Pause pause) {
        super(pause);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Game Paused", "#FFFFFF");
        String color;
        for (int i = 0; i < getModel().getNumberEntries(); i++){
            switch (getModel().getEntry(i)) {
                case "Exit":
                    color = "#FF0000";
                    break;
                default:
                    color = "#00FFFF";
            }
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? color : "#FFFFFF");
        }
    }
}