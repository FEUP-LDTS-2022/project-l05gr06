package tetrisRunner.viewer.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.menu.Instruction;
import tetrisRunner.model.menu.SelectMode;

import java.io.IOException;

public class InstructionViewerTest {
    private GUI gui;
    private InstructionViewer viewer;
    private Instruction instruction;

    @BeforeEach
    public void helper(){
        instruction = new Instruction();
        gui = Mockito.mock(GUI.class);
        viewer = new InstructionViewer(instruction);
        Mockito.when(gui.getStringColor(GUI.COLOR.WHITE)).thenReturn("#FFFFFF");
        Mockito.when(gui.getStringColor(GUI.COLOR.BLACK)).thenReturn("#000000");
        Mockito.when(gui.getStringColor(GUI.COLOR.ORANGE)).thenReturn("#FFAC1C");
        Mockito.when(gui.getStringColor(GUI.COLOR.RED)).thenReturn("#D22B2B");
        Mockito.when(gui.getStringColor(GUI.COLOR.CYAN)).thenReturn("#40E0D0");
        Mockito.when(gui.getMenuName(GUI.NAME_STATES.INSTRUCTION)).thenReturn("Instructions");
    }

    @Test
    public void drawElementsMenu0Test() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getMenuName(GUI.NAME_STATES.INSTRUCTION);
        Mockito.verify(gui,Mockito.times(3)).getStringColor(GUI.COLOR.CYAN);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.ORANGE);
        Mockito.verify(gui,Mockito.times(4)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(5)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(4, 5),
                "Instructions",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,7),
                "Jacob",
                "#40E0D0",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,8),
                "Shape",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,9),
                "Game Modes",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,10),
                "Return",
                "#FFFFFF",
                "#000000"
        );
    }
    @Test
    public void drawElementsMenu1Test() throws IOException {
        instruction.setMenu(1);
        instruction.changeInstruction();
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.RED);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.ORANGE);
        Mockito.verify(gui,Mockito.times(3)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(5)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 3),
                "Jacob",
                "#D22B2B",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 7),
                "Move sideways",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 8),
                "and jump using",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 9),
                "the arrows!",
                "#FFFFFF",
                "#000000"
        );

        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,16),
                "Return",
                "#FFAC1C",
                "#000000"
        );
    }
    @Test
    public void drawElementsMenu2Test() throws IOException {
        instruction.setMenu(2);
        instruction.changeInstruction();
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.RED);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.ORANGE);
        Mockito.verify(gui,Mockito.times(9)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(11)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 1),
                "Shape",
                "#D22B2B",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(6, 3),
                "Rotate",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 4),
                "W: Clockwise",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 5),
                "S: AntiClockwise",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(6, 7),
                "Move",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 8),
                "A: Left",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 9),
                "D: Right",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 11),
                "Space: Drop",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 12),
                "(not in PvP)",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 14),
                "R: PvP-Resign",
                "#FFFFFF",
                "#000000");

        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,16),
                "Return",
                "#FFAC1C",
                "#000000"
        );
    }
    @Test
    public void drawElementsMenu3Test() throws IOException {
        instruction.setMenu(3);
        instruction.changeInstruction();
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(3)).getStringColor(GUI.COLOR.CYAN);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.ORANGE);
        Mockito.verify(gui,Mockito.times(4)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(5)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5, 5),
                "Game Modes",
                "#FFFFFF",
                "#000000");
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,7),
                "Classic",
                "#40E0D0",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,8),
                "Climbing",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,9),
                "PvP",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,10),
                "Return",
                "#FFFFFF",
                "#000000"
        );
    }
    @Test
    public void drawElementsMenu4Test() throws IOException {
        instruction.setMenu(4);
        instruction.changeInstruction();
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.RED);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.ORANGE);
        Mockito.verify(gui,Mockito.times(6)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(8)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 3),
                "Classic",
                "#D22B2B",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 6),
                "Tetris as we",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 7),
                "all know it...",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 8),
                "bonus points",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 9),
                "if Jacob grabs",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 10),
                "floating coins!",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 12),
                "(1/2 Players)",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,16),
                "Return",
                "#FFAC1C",
                "#000000"
        );
    }
    @Test
    public void drawElementsMenu5Test() throws IOException {
        instruction.setMenu(5);
        instruction.changeInstruction();
        viewer.draw(gui);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.RED);
        Mockito.verify(gui,Mockito.times(1)).getStringColor(GUI.COLOR.ORANGE);
        Mockito.verify(gui,Mockito.times(6)).getStringColor(GUI.COLOR.WHITE);
        Mockito.verify(gui,Mockito.times(8)).getStringColor(GUI.COLOR.BLACK);
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 3),
                "Climbing",
                "#D22B2B",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 6),
                "Shapes and Jacob",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 7),
                "must cooperate",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 8),
                "because he is",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 9),
                "on a rush to",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 10),
                "get to the Top!",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui, Mockito.times(1)).drawText(
                new Position(3, 12),
                "(1/2 Players)",
                "#FFFFFF",
                "#000000"
        );
        Mockito.verify(gui,Mockito.times(1)).drawText(
                new Position(5,16),
                "Return",
                "#FFAC1C",
                "#000000"
        );
    }
}
