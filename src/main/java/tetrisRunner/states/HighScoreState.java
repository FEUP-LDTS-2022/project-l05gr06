package tetrisRunner.states;

import tetrisRunner.controller.Controller;
import tetrisRunner.controller.menu.HighScoreController;
import tetrisRunner.model.menu.HighScore;
import tetrisRunner.model.menu.Instruction;
import tetrisRunner.viewer.Viewer;
import tetrisRunner.viewer.menu.HighScoreViewer;

public class HighScoreState extends State<HighScore> {
    public HighScoreState(HighScore model) {
        super(model);
    }
    @Override
    protected Viewer<HighScore> getViewer() {
        return new HighScoreViewer(getModel());
    }

    @Override
    protected Controller<HighScore> getController() {
        return new HighScoreController(getModel());
    }
}
