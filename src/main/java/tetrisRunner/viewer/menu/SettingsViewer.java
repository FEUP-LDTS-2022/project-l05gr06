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
        gui.drawText(new Position(5, 5), "Settings", "#FFFFFF");

        String color;
        for (int i = 0; i < getModel().getNumberEntries() ; i++) {

            switch (getModel().getEntry(i)) {
                case "Mute":
                    color = "#FF0000"; break;
                case "Unmute":
                    color = "#00FF00"; break;
                case "Return":
                    color = "#E47200"; break;
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