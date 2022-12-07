package tetrisRunner.states;

import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.controller.game.LayoutController;
import tetrisRunner.controller.menu.GameOverController;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.model.menu.Instruction;
import tetrisRunner.viewer.Viewer;
import tetrisRunner.viewer.game.GameViewer;
import tetrisRunner.viewer.menu.GameOverViewer;

public class GameOverState extends State<GameOver>{

    public GameOverState(GameOver model) {
        super(model);
    }
    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
