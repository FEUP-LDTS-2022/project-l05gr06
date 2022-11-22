package states;

import controller.Controller;
import model.menu.Menu;
import viewer.Viewer;

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
