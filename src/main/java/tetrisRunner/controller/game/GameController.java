package tetrisRunner.controller.game;

import tetrisRunner.controller.Controller;
import tetrisRunner.model.game.layout.Layout;

public abstract class GameController extends Controller<Layout> {
    public GameController(Layout model) {
        super(model);
    }
}
