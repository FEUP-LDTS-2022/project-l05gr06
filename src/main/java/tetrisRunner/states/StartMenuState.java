package tetrisRunner.states;

import tetrisRunner.controller.Controller;
import tetrisRunner.controller.menu.StartMenuController;
import tetrisRunner.model.menu.Menu;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.viewer.Viewer;
import tetrisRunner.viewer.menu.StartMenuViewer;

public class StartMenuState extends State<StartMenu> {
    public StartMenuState(StartMenu model) {
        super(model);
    }

    @Override
    protected Viewer<StartMenu> getViewer() {
        return new StartMenuViewer(getModel());
    }

    @Override
    protected Controller<StartMenu> getController() {
        return new StartMenuController(getModel());
    }
}
