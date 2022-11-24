package tetrisRunner.controller.menu;

import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.layout.LoaderLayoutBuilder;
import tetrisRunner.model.menu.Instruction;
import tetrisRunner.model.menu.SelectMode;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.states.GameState;
import tetrisRunner.states.InstructionState;
import tetrisRunner.states.SelectModeState;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;

public class SelectModeController extends Controller<SelectMode> {
    public SelectModeController(SelectMode selectMode){
        super(selectMode);
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
                if (getModel().isSelectedReturn()) game.setState(new StartMenuState(new StartMenu()));
                //---------------------------------------------------------------------------------------------
                if (getModel().isSelectedClassic())  game.setState(new GameState(new LoaderLayoutBuilder().createLayout()));
                if (getModel().isSelectedCoOp())  game.setState(new GameState(new LoaderLayoutBuilder().createLayout()));
                if (getModel().isSelected1v1()) game.setState(new GameState(new LoaderLayoutBuilder().createLayout()));
                //TODO -> Criar o layout builder + Design Pattern para GameOver
        }
    }
}
