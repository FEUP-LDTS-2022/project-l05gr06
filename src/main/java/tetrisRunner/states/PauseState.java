package tetrisRunner.states;

import tetrisRunner.controller.Controller;
import tetrisRunner.controller.menu.PauseController;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.viewer.Viewer;
import tetrisRunner.viewer.menu.PauseViewer;



public class PauseState extends State<Pause> {

    public PauseState(Pause model) {
        super(model);
    }

    @Override
    protected Viewer<Pause> getViewer() {
        return new PauseViewer(getModel());
    }

    @Override
    protected Controller<Pause> getController() {
        return new PauseController(getModel());
    }
}
