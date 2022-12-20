package tetrisRunner.model.game.gamebehavior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.controller.game.LayoutController;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.shapes.ShapeJ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PvPBehaviorTest {
    private PvPBehavior pvpBehavior;
    private Layout layout;
    private Jacob jacob;
    private LayoutController layoutController;

    @BeforeEach
    public void helper() throws IOException {
        pvpBehavior = new PvPBehavior();
        layout = new Layout(20,20);
        jacob = new Jacob(10,15);
        layout.setJacob(jacob);
        layout.setWalls(new ArrayList<>()); layout.setBlocks(new ArrayList<>());
        layout.setShape(new ShapeJ(Arrays.asList(new Position(9, 0),
                new Position(10, 0),
                new Position(11, 0),
                new Position(9, -1))));
        layoutController = new LayoutController(layout);
    }

    @Test
    public void gameOverStatusJacobDiedTest(){
        layout.setWalls(Arrays.asList(new Wall(10,16)));
        layout.setBlocks(Arrays.asList(new Block(10,15, GUI.COLOR.WHITE)));
        Assertions.assertTrue(pvpBehavior.gameOverStatus(layoutController));
        layout.setWalls(new ArrayList<>());
        Assertions.assertFalse(pvpBehavior.gameOverStatus(layoutController));
        layout.setWalls(Arrays.asList(new Wall(10,16)));
        layout.setBlocks(new ArrayList<>());
        Assertions.assertFalse(pvpBehavior.gameOverStatus(layoutController));
    }
    @Test
    public void gameOverWinShapeOverLimitTest(){
        Assertions.assertFalse(pvpBehavior.gameOverWin(layoutController));
        layout.setBlocks(Arrays.asList(new Block(0,16, GUI.COLOR.WHITE), new Block(1,16, GUI.COLOR.WHITE),
                new Block(5,13, GUI.COLOR.WHITE)));
        Assertions.assertFalse(pvpBehavior.gameOverWin(layoutController));
        layout.setBlocks(Arrays.asList(new Block(1,1, GUI.COLOR.WHITE), new Block(1,0, GUI.COLOR.WHITE),
                new Block(-1,6, GUI.COLOR.WHITE)));
        Assertions.assertFalse(pvpBehavior.gameOverWin(layoutController));
        layout.setBlocks(Arrays.asList(new Block(3,-1, GUI.COLOR.WHITE)));
        Assertions.assertTrue(pvpBehavior.gameOverWin(layoutController));
    }
    @Test
    public void gameOverWinOverTimeTest(){
        Assertions.assertFalse(pvpBehavior.gameOverWin(layoutController));
        pvpBehavior.incrementScore(15);
        Assertions.assertFalse(pvpBehavior.gameOverWin(layoutController));
        pvpBehavior.incrementScore(45);
        Assertions.assertFalse(pvpBehavior.gameOverWin(layoutController));
        pvpBehavior.incrementScore(1);
        Assertions.assertTrue(pvpBehavior.gameOverWin(layoutController));
    }
    @Test
    public void isPvPTest() {
        Assertions.assertTrue(pvpBehavior.isPvP());
    }

    @Test
    public void instaDropAvailableTest() {
        Assertions.assertFalse(pvpBehavior.instaDropAvailable());
    }

    @Test
    public void incrementScoreTest() {
        pvpBehavior.incrementScore(1);
        Assertions.assertEquals(1,pvpBehavior.getScoreNumber());
    }

    @Test
    public void getScoreStringTest() {
        Assertions.assertEquals("01:00",pvpBehavior.getScoreString());
        pvpBehavior.incrementScore(10);
        Assertions.assertEquals("00:50",pvpBehavior.getScoreString());
        pvpBehavior.incrementScore(49);
        Assertions.assertEquals("00:01",pvpBehavior.getScoreString());
    }

    @Test
    public void getScoreNumberTest() {
        Assertions.assertEquals(0,pvpBehavior.getScoreNumber());
    }

    @Test
    public void checkLeaderboardUpdateTest() {
        Assertions.assertFalse(pvpBehavior.checkLeaderboardUpdate());
    }
}
