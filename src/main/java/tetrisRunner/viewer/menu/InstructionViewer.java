package tetrisRunner.viewer.menu;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.Instruction;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.viewer.Viewer;



public class InstructionViewer extends Viewer<Instruction> {
    public InstructionViewer(Instruction inst) {
        super(inst);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), gui.getMenuName(GUI.NAME_STATES.INSTRUCTION), gui.getStringColor(GUI.COLOR.WHITE));
        String color;
        for (int i = 0; i < getModel().getNumberEntries(); i++){
            switch (getModel().getEntry(i)) {
                case "Return":
                    color = gui.getStringColor(GUI.COLOR.ORANGE);
                    break;
                default:
                    color = gui.getStringColor(GUI.COLOR.CYAN);
            }
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? color : gui.getStringColor(GUI.COLOR.WHITE));
    }
}
}

