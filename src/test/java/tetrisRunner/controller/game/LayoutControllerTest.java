package tetrisRunner.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;
import tetrisRunner.model.game.gamebehavior.ClassicBehavior;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.shapes.RandomShapeFactory;
import tetrisRunner.model.game.shapes.ShapeFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LayoutControllerTest {

    private LayoutController controller;
    private Jacob jacob;
    private Layout layout;

    @BeforeEach
    void setUp() {
        layout = new Layout(20, 20);

        ShapeFactory factory = new RandomShapeFactory();

        jacob = new Jacob(10, 10);
        layout.setJacob(jacob);

        layout.setBlocks(Arrays.asList());
        layout.setWalls(Arrays.asList());
        layout.setShape(factory.createShape());
        layout.setGameOverBehavior(new ClassicBehavior());

        controller = new LayoutController(layout);
    }

    @Test
    void clearLineTest() {

        List<Block> blocks = new ArrayList<>();

        for (int i = 1; i < 19; i++) blocks.add(new Block(i, 17, GUI.COLOR.RED));

        layout.setBlocks(blocks);
        controller.clearLine(17);

        assertEquals(layout.getBlocks(),new ArrayList<>());
    }

    @Test
    void transformTest(){
        List<Block> blocks = new ArrayList<>();
        int lines;

        for (int i = 1; i < 19; i++) blocks.add(new Block(i, 17, GUI.COLOR.RED));

        layout.setBlocks(blocks);
        lines = controller.transform();

        assertEquals(layout.getBlocks(),new ArrayList<>());
        assertEquals(lines,1);

        for (int i = 1; i < 19; i++) blocks.add(new Block(i, 17, GUI.COLOR.RED));
        for (int i = 1; i < 19; i++) blocks.add(new Block(i, 16, GUI.COLOR.RED));

        layout.setBlocks(blocks);
        lines = controller.transform();

        assertEquals(layout.getBlocks(),new ArrayList<>());
        assertEquals(lines,2);

        for (int i = 1; i < 19; i++) blocks.add(new Block(i, 17, GUI.COLOR.RED));
        for (int i = 1; i < 19; i++) blocks.add(new Block(i, 16, GUI.COLOR.RED));
        for (int i = 1; i < 19; i++) blocks.add(new Block(i, 15, GUI.COLOR.RED));

        layout.setBlocks(blocks);
        lines = controller.transform();

        assertEquals(layout.getBlocks(),new ArrayList<>());
        assertEquals(lines,3);

        for (int i = 1; i < 19; i++) blocks.add(new Block(i, 17, GUI.COLOR.RED));
        for (int i = 1; i < 19; i++) blocks.add(new Block(i, 16, GUI.COLOR.RED));
        for (int i = 1; i < 19; i++) blocks.add(new Block(i, 15, GUI.COLOR.RED));
        for (int i = 1; i < 19; i++) blocks.add(new Block(i, 14, GUI.COLOR.RED));

        layout.setBlocks(blocks);
        lines = controller.transform();

        assertEquals(layout.getBlocks(),new ArrayList<>());
        assertEquals(lines,4);

    }

    @Test
    void updateScoreTest(){

        controller.updateScore(1);
        assertEquals(layout.getScoreNumber(),100);
        layout.incrementScore(-100);

        controller.updateScore(2);
        assertEquals(layout.getScoreNumber(),300);
        layout.incrementScore(-300);

        controller.updateScore(3);
        assertEquals(layout.getScoreNumber(),500);
        layout.incrementScore(-500);

        controller.updateScore(4);
        assertEquals(layout.getScoreNumber(),800);
        layout.incrementScore(-800);

        controller.updateScore(1);
        assertEquals(layout.getScoreNumber(),100);

        controller.updateScore(2);
        assertEquals(layout.getScoreNumber(),400);

        controller.updateScore(3);
        assertEquals(layout.getScoreNumber(),900);

        controller.updateScore(4);
        assertEquals(layout.getScoreNumber(),1700);
    }


}
