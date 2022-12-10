package tetrisRunner.controller.menu;

import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.gameover.ClassicBehavior;
import tetrisRunner.model.game.gameover.ClimbingBehavior;
import tetrisRunner.model.game.gameover.PvPBehavior;
import tetrisRunner.model.game.layout.LoaderLayoutBuilder;
import tetrisRunner.model.menu.*;
import tetrisRunner.states.GameState;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;

public class SelectModeController extends Controller<SelectMode> {
    public SelectModeController(SelectMode selectMode){
        super(selectMode);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedReturn()) game.setState(new StartMenuState(new StartMenu()));
                if (getModel().isSelectedClassic())
                    game.setState(new GameState(new LoaderLayoutBuilder(new ClassicBehavior()).createLayout()));
                if (getModel().isSelectedCoOp()) game.setState(new GameState(new LoaderLayoutBuilder(new ClimbingBehavior()).createLayout()));
                if (getModel().isSelected1v1()) game.setState(new GameState(new LoaderLayoutBuilder(new PvPBehavior()).createLayout()));
            }
        }
    }
}
