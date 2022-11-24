package tetrisRunner.states;

import tetrisRunner.controller.Controller;
import tetrisRunner.controller.game.GameController;
import tetrisRunner.controller.game.LayoutController;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.viewer.Viewer;
import tetrisRunner.viewer.game.GameViewer;

public class GameState extends State<Layout> {
    public GameState(Layout model) {
        super(model);
    }

    @Override
    protected Viewer<Layout> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Layout> getController() {
        return new LayoutController(getModel());
    }
}
