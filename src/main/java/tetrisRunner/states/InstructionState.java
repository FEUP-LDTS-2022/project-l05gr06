package tetrisRunner.states;

import tetrisRunner.controller.Controller;
import tetrisRunner.controller.menu.InstructionController;
import tetrisRunner.model.menu.Instruction;
import tetrisRunner.viewer.Viewer;
import tetrisRunner.viewer.menu.InstructionViewer;

public class InstructionState extends State<Instruction> {
    public InstructionState(Instruction model) {
        super(model);
    }

    @Override
    protected Viewer<Instruction> getViewer() {
        return new InstructionViewer(getModel());
    }

    @Override
    protected Controller<Instruction> getController() {
        return new InstructionController(getModel());
    }
}
