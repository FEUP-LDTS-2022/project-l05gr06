package tetrisRunner.states;

import tetrisRunner.controller.Controller;
import tetrisRunner.model.menu.Menu;
import tetrisRunner.viewer.Viewer;

public class MenuState extends State<Menu> {

    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return null;
    }

    @Override
    protected Controller<Menu> getController() {
        return null;
    }
}
