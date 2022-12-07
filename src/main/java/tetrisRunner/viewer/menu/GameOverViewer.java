package tetrisRunner.viewer.menu;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.states.GameState;
import tetrisRunner.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver gameOver) {
        super(gameOver);
    }
    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), gui.getMenuName(GUI.NAME_STATES.GAME_OVER), gui.getStringColor(GUI.COLOR.WHITE));
        String color;
        for (int i = 0; i < getModel().getNumberEntries(); i++){
            switch (getModel().getEntry(i)) {
                case "Exit":
                    color = gui.getStringColor(GUI.COLOR.RED);
                    break;
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
