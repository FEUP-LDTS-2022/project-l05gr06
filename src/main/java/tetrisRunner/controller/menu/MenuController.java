package tetrisRunner.controller.menu;


import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.Menu;


import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
        }
    }
}
