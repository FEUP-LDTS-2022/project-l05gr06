package tetrisRunner.viewer.menu;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.SelectMode;
import tetrisRunner.viewer.Viewer;

public class SelectGameModeViewer extends Viewer<SelectMode> {
    public SelectGameModeViewer(SelectMode mode) {
        super(mode);
    }
    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Select Mode", "#FFFFFF");
        String color;
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            switch (getModel().getEntry(i)) {
                case "Return":
                    color = "#E47200";
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

