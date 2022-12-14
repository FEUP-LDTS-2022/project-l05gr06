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
        gui.drawText(
                new Position(5, 5),
                gui.getMenuName(GUI.NAME_STATES.SETTINGS),
                gui.getStringColor(GUI.COLOR.WHITE),
                gui.getStringColor(GUI.COLOR.BLACK));

        String color;
        for (int i = 0; i < getModel().getNumberEntries() ; i++) {

            color = switch (getModel().getEntry(i)) {
                case "Mute" -> gui.getStringColor(GUI.COLOR.RED);
                case "Unmute" -> gui.getStringColor(GUI.COLOR.GREEN);
                case "Return" -> gui.getStringColor(GUI.COLOR.ORANGE);
                default -> gui.getStringColor(GUI.COLOR.CYAN);
            };

            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? color : gui.getStringColor(GUI.COLOR.WHITE),
                    gui.getStringColor(GUI.COLOR.BLACK));
        }
    }
}