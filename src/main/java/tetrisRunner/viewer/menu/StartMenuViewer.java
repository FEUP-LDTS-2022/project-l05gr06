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
        gui.drawText(
                new Position(5, 5),
                gui.getMenuName(GUI.NAME_STATES.START_MENU),
                gui.getStringColor(GUI.COLOR.WHITE),
                gui.getStringColor(GUI.COLOR.BLACK));
        String color;
        for (int i = 0; i < getModel().getNumberEntries(); i++){
            if ("Exit".equals(getModel().getEntry(i))) {
                color = gui.getStringColor(GUI.COLOR.RED);
            } else {
                color = gui.getStringColor(GUI.COLOR.CYAN);
            }
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? color : gui.getStringColor(GUI.COLOR.WHITE),
                    gui.getStringColor(GUI.COLOR.BLACK));
    }
    }
}