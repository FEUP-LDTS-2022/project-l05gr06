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
        int x,y;
        if(getModel().getMenu() != 0 && getModel().getMenu() != 3){
            x = 5; y = 16;
        }
        else{
            x = 5; y = 7;
        }

        String color;
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

        switch (getModel().getMenu()){
            case 0:
                gui.drawText(
                        new Position(4, 5),
                        gui.getMenuName(GUI.NAME_STATES.INSTRUCTION),
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                break;
            case 1:
                gui.drawText(
                        new Position(3, 3),
                        "Jacob",
                        gui.getStringColor(GUI.COLOR.RED),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(
                        new Position(3, 7),
                        "Move sideways",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(
                        new Position(3, 8),
                        "and jump using",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(
                        new Position(3, 9),
                        "the arrows!",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                break;
            case 2:
                gui.drawText(new Position(3, 1),
                        "Shape",
                        gui.getStringColor(GUI.COLOR.RED),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(
                        new Position(6, 3),
                        "Rotate",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(
                        new Position(3, 4),
                        "W: Clockwise",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(
                        new Position(3, 5),
                        "S: AntiClockwise",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(
                        new Position(6, 7),
                        "Move",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(
                        new Position(3, 8),
                        "A: Left",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(
                        new Position(3, 9),
                        "D: Right",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(
                        new Position(3, 11),
                        "Space: Drop",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(
                        new Position(3, 12),
                        "(not in PvP)",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(
                        new Position(3, 14),
                        "R: PvP-Resign",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));

                break;
            case 3:
                gui.drawText(new Position(5, 4),
                        "Game Modes",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                break;
            case 4:
                gui.drawText(new Position(3, 3),
                        "Classic",
                        gui.getStringColor(GUI.COLOR.RED),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 6),
                        "Tetris as we",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 7),
                        "all know it...",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 8),
                        "bonus points",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 9),
                        "if Jacob grabs",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 10),
                        "floating coins!",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 12),
                        "(1/2 Players)",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));

                break;
            case 5:
                gui.drawText(new Position(3, 3),
                        "Climbing",
                        gui.getStringColor(GUI.COLOR.RED),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 6),
                        "Shapes and Jacob",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 7),
                        "must cooperate",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 8),
                        "because he is",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 9),
                        "on a rush to",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 10),
                        "get to the Top!",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 12),
                        "(1/2 Players)",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                break;
            case 6:
                gui.drawText(new Position(3, 3),
                        "PvP",
                        gui.getStringColor(GUI.COLOR.RED),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 7),
                        "Run Jacob!",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 8),
                        "The pieces are",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 9),
                        "out to get ya!",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                gui.drawText(new Position(3, 11),
                        "(2 Players)",
                        gui.getStringColor(GUI.COLOR.WHITE),
                        gui.getStringColor(GUI.COLOR.BLACK));
                break;
        }

    }
}

