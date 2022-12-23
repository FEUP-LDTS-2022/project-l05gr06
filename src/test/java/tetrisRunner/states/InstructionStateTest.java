package tetrisRunner.states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.controller.menu.InstructionController;
import tetrisRunner.model.menu.Instruction;
import tetrisRunner.viewer.menu.InstructionViewer;

public class InstructionStateTest {
    private InstructionState instructionState;
    private Instruction instruction;
    @BeforeEach
    public void helper(){
        instruction = new Instruction();
        instructionState = new InstructionState(instruction);
    }
    @Test
    public void getViewerTest(){
        Assertions.assertInstanceOf(InstructionViewer.class,instructionState.getViewer());
    }
    @Test
    public void getControllerTest(){
            Assertions.assertInstanceOf(InstructionController.class,instructionState.getController());
    }
}
