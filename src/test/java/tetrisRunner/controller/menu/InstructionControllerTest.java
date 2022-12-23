package tetrisRunner.controller.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.Instruction;
import tetrisRunner.states.SelectModeState;
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
        for (int i=0; i<7;i++)
            Mockito.doCallRealMethod().when(inst).setMenu(i);
        Mockito.doCallRealMethod().when(inst).getMenu();
        guiActions = Arrays.asList(GUI.ACTION.ARROW_UP, GUI.ACTION.ARROW_DOWN, GUI.ACTION.SELECT);
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
    public void setSelectedReturnTest() throws IOException {
        Mockito.when(inst.isSelectedReturn()).thenReturn(true);
        instController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(StartMenuState.class));
        inst.setMenu(1);
        instController.step(game, guiActions.get(2),0);
        Assertions.assertEquals(0,inst.getMenu());
        inst.setMenu(3);
        instController.step(game, guiActions.get(2),0);
        Assertions.assertEquals(0,inst.getMenu());
        inst.setMenu(4);
        instController.step(game, guiActions.get(2),0);
        Assertions.assertEquals(3,inst.getMenu());
    }
    @Test
    public void setSelectedJacobTest() throws IOException {
        Mockito.when(inst.isSelectedJacob()).thenReturn(true);
        instController.step(game, guiActions.get(2),0);
        Assertions.assertEquals(1,inst.getMenu());
    }
    @Test
    public void setSelectedShapeTest() throws IOException {
        Mockito.when(inst.isSelectedShape()).thenReturn(true);
        instController.step(game, guiActions.get(2),0);
        Assertions.assertEquals(2,inst.getMenu());
    }
    @Test
    public void setSelectedGameModesTest() throws IOException {
        Mockito.when(inst.isSelectedGameModes()).thenReturn(true);
        instController.step(game, guiActions.get(2),0);
        Assertions.assertEquals(3,inst.getMenu());
    }
    @Test
    public void setSelectedClassicTest() throws IOException {
        inst.setMenu(3);
        Mockito.when(inst.isSelectedClassic()).thenReturn(true);
        instController.step(game, guiActions.get(2),0);
        Assertions.assertEquals(4,inst.getMenu());
    }
    @Test
    public void setSelectedClimbingTest() throws IOException {
        inst.setMenu(3);
        Mockito.when(inst.isSelectedClimbing()).thenReturn(true);
        instController.step(game, guiActions.get(2),0);
        Assertions.assertEquals(5,inst.getMenu());
    }
    @Test
    public void setSelectedPvPTest() throws IOException {
        inst.setMenu(3);
        Mockito.when(inst.isSelectedPvP()).thenReturn(true);
        instController.step(game, guiActions.get(2),0);
        Assertions.assertEquals(6,inst.getMenu());
    }
}
