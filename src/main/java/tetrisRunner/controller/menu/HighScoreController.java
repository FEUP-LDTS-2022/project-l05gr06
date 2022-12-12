package tetrisRunner.controller.menu;

import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.model.menu.HighScore;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.states.GameOverState;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;

public class HighScoreController extends Controller<HighScore> {

    public HighScoreController(HighScore model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        int nameSize = getModel().getName().length();
        if (getModel().isSelectedName()){
            if (nameSize<3){
                switch (action) {
                    case A -> getModel().setName(getModel().getName()+"A");
                    case B -> getModel().setName(getModel().getName()+"B");
                    case C -> getModel().setName(getModel().getName()+"C");
                    case D -> getModel().setName(getModel().getName()+"D");
                    case E -> getModel().setName(getModel().getName()+"E");
                    case F -> getModel().setName(getModel().getName()+"F");
                    case G -> getModel().setName(getModel().getName()+"G");
                    case H -> getModel().setName(getModel().getName()+"H");
                    case I -> getModel().setName(getModel().getName()+"I");
                    case J -> getModel().setName(getModel().getName()+"J");
                    case K -> getModel().setName(getModel().getName()+"K");
                    case L -> getModel().setName(getModel().getName()+"L");
                    case M -> getModel().setName(getModel().getName()+"M");
                    case N -> getModel().setName(getModel().getName()+"N");
                    case O -> getModel().setName(getModel().getName()+"O");
                    case P -> getModel().setName(getModel().getName()+"P");
                    case Q -> getModel().setName(getModel().getName()+"Q");
                    case R -> getModel().setName(getModel().getName()+"R");
                    case S -> getModel().setName(getModel().getName()+"S");
                    case T -> getModel().setName(getModel().getName()+"T");
                    case U -> getModel().setName(getModel().getName()+"U");
                    case V -> getModel().setName(getModel().getName()+"V");
                    case W -> getModel().setName(getModel().getName()+"W");
                    case X -> getModel().setName(getModel().getName()+"X");
                    case Y -> getModel().setName(getModel().getName()+"Y");
                    case Z -> getModel().setName(getModel().getName()+"Z");
                }
            }
            if (nameSize != 0){
                if (action == GUI.ACTION.BACKSPACE)
                    getModel().setName(getModel().getName().substring(0, nameSize - 1));
            }

        }
        switch (action) {
            case ARROW_UP:
                getModel().previousEntry();
                break;
            case ARROW_DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedNext() && nameSize == 3)
                    game.setState(new GameOverState(new GameOver()));
        }
    }
}
