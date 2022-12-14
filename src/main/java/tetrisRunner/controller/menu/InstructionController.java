package tetrisRunner.controller.menu;

import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.Instruction;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.states.InstructionState;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;

public class InstructionController extends Controller<Instruction> {
    public InstructionController(Instruction inst) {
        super(inst);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case ARROW_UP:
                getModel().previousEntry();
                break;
            case ARROW_DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().getMenu() > 0 && getModel().getMenu() < 4 && getModel().isSelectedReturn()) {
                    getModel().setMenu(0);
                    getModel().changeInstruction();
                    break;
                }
                if (getModel().getMenu() == 0) {
                    if (getModel().isSelectedJacob()) {
                        getModel().setMenu(1);
                        getModel().changeInstruction();
                        break;
                    }
                    else if (getModel().isSelectedShape()) {
                        getModel().setMenu(2);
                        getModel().changeInstruction();
                        break;
                    }
                    else if (getModel().isSelectedGameModes()) {
                        getModel().setMenu(3);
                        getModel().changeInstruction();
                        break;
                    }
                    else if (getModel().isSelectedReturn()) {
                        game.setState(new StartMenuState(new StartMenu()));
                    }
                }
                if (getModel().getMenu() == 3) {
                    if (getModel().isSelectedClassic()) {
                        getModel().setMenu(4);
                        getModel().changeInstruction();
                        break;
                    }
                    if (getModel().isSelectedClimbing()) {
                        getModel().setMenu(5);
                        getModel().changeInstruction();
                        break;
                    }
                    if (getModel().isSelectedPvP()) {
                        getModel().setMenu(6);
                        getModel().changeInstruction();
                        break;
                    }
                }

                if (getModel().getMenu() > 3 && getModel().isSelectedReturn()) {
                    getModel().setMenu(3);
                    getModel().changeInstruction();
                    break;
                }


            }

        }
    }

