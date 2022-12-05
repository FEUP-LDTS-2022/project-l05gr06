package tetrisRunner.viewer.menu;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.Settings;
import tetrisRunner.viewer.Viewer;

public class SettingsViewer extends Viewer<Settings> {
    public SettingsViewer(Settings setting) {
        super(setting);
    }
    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), gui.getMenuName(GUI.NAME_STATES.SETTINGS), gui.getStringColor(GUI.COLOR.WHITE));

        String color;
        for (int i = 0; i < getModel().getNumberEntries() ; i++) {

            switch (getModel().getEntry(i)) {
                case "Mute":
                    color = gui.getStringColor(GUI.COLOR.RED); break;
                case "Unmute":
                    color = gui.getStringColor(GUI.COLOR.GREEN); break;
                case "Return":
                    color = gui.getStringColor(GUI.COLOR.ORANGE); break;
                default:
                    color = gui.getStringColor(GUI.COLOR.CYAN);
            }

            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? color : gui.getStringColor(GUI.COLOR.WHITE));
        }
    }
}