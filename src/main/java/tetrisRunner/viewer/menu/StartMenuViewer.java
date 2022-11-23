package tetrisRunner.viewer.menu;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.viewer.Viewer;

public class StartMenuViewer extends Viewer<StartMenu> {
    public StartMenuViewer(StartMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");
        String color;
        for (int i = 0; i < getModel().getNumberEntries(); i++){
            switch (getModel().getEntry(i)) {
                case "Exit":
                    color = "#FF0000"; break;
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