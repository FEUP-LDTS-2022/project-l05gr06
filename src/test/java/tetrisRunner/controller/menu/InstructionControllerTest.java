package tetrisRunner.controller.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.controller.Controller;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.Instruction;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class InstructionControllerTest {
    private InstructionController instController;
    private Instruction inst;
    private Game game;
    private List<GUI.ACTION> guiActions;

    @BeforeEach
    public void helper(){
        inst = Mockito.mock(Instruction.class);
        instController = new InstructionController(inst);
        game = Mockito.mock(Game.class);
        guiActions = Arrays.asList(GUI.ACTION.UP, GUI.ACTION.DOWN, GUI.ACTION.SELECT);
    }

    @Test
    public void stepUpTest() throws IOException {
        instController.step(game, guiActions.get(0),0);
        Mockito.verify(inst, Mockito.times(1)).previousEntry();
    }

    @Test
    public void stepDownTest() throws IOException {
        instController.step(game, guiActions.get(1),0);
        Mockito.verify(inst, Mockito.times(1)).nextEntry();
    }

    @Test
    public void stepSelectReturnTest() throws IOException {
        Mockito.when(inst.isSelectedReturn()).thenReturn(true);
        instController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(StartMenuState.class));

    }
}
