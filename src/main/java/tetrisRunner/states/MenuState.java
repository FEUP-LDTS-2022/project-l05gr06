package tetrisRunner.states;

import tetrisRunner.controller.Controller;
import tetrisRunner.controller.menu.MenuController;
import tetrisRunner.model.menu.Menu;
import tetrisRunner.viewer.Viewer;
import tetrisRunner.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
