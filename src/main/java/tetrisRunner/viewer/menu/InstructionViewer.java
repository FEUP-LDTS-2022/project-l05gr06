package tetrisRunner.viewer.menu;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.Instruction;
import tetrisRunner.viewer.Viewer;



public class InstructionViewer extends Viewer<Instruction> {
    int x,y;
    public InstructionViewer(Instruction inst) {
        super(inst);
    }

    @Override
    public void drawElements(GUI gui) {

        if(getModel().getMenu() == 0){
            gui.drawText(
                    new Position(4, 4),
                    "Shape",
                    gui.getStringColor(GUI.COLOR.WHITE),
                    gui.getStringColor(GUI.COLOR.BLACK));
        }
        else if(getModel().getMenu() == 1){
            gui.drawText(
                    new Position(4, 4),
                    "Sh231ape",
                    gui.getStringColor(GUI.COLOR.WHITE),
                    gui.getStringColor(GUI.COLOR.BLACK));
        }
        else if(getModel().getMenu() == 2){
            gui.drawText(
                    new Position(4, 4),
                    "Sh231ap312e",
                    gui.getStringColor(GUI.COLOR.WHITE),
                    gui.getStringColor(GUI.COLOR.BLACK));
        }
        String color;
        if(getModel().getMenu() != 0 && getModel().getMenu() != 3){
            x = 4;  y = 15;
        }
        else{
            x = 4; y = 7;
        }
        for (int i = 0; i < getModel().getNumberEntries(); i++){
            if ("Return".equals(getModel().getEntry(i))) {
                color = gui.getStringColor(GUI.COLOR.ORANGE);
            } else {
                color = gui.getStringColor(GUI.COLOR.CYAN);
            }
            gui.drawText(
                    new Position(x, y + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? color : gui.getStringColor(GUI.COLOR.WHITE),
                    gui.getStringColor(GUI.COLOR.BLACK));
        }
    }
}

