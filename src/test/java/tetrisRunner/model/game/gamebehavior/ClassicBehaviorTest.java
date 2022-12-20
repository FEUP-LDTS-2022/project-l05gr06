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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassicBehaviorTest {
    private ClassicBehavior classicBehavior;
    private Layout layout;
    private Jacob jacob;
    private LayoutController layoutController;
    private File file;

    @BeforeEach
    public void helper() throws IOException {
        classicBehavior = new ClassicBehavior();
        file = File.createTempFile("testClassic",".txt");
        String path = file.getAbsolutePath();
        classicBehavior.setFile(path);
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
        Assertions.assertTrue(classicBehavior.gameOverStatus(layoutController));
        layout.setWalls(new ArrayList<>());
        Assertions.assertFalse(classicBehavior.gameOverStatus(layoutController));
        layout.setWalls(Arrays.asList(new Wall(10,16)));
        layout.setBlocks(new ArrayList<>());
        Assertions.assertFalse(classicBehavior.gameOverStatus(layoutController));
    }
    @Test
    public void gameOverStatusShapeOverLimitTest(){
        Assertions.assertFalse(classicBehavior.gameOverStatus(layoutController));
        layout.setBlocks(Arrays.asList(new Block(0,16, GUI.COLOR.WHITE), new Block(1,16, GUI.COLOR.WHITE),
                new Block(5,13, GUI.COLOR.WHITE)));
        Assertions.assertFalse(classicBehavior.gameOverStatus(layoutController));
        layout.setBlocks(Arrays.asList(new Block(1,1, GUI.COLOR.WHITE), new Block(1,0, GUI.COLOR.WHITE),
                new Block(-1,6, GUI.COLOR.WHITE)));
        Assertions.assertFalse(classicBehavior.gameOverStatus(layoutController));
        layout.setBlocks(Arrays.asList(new Block(3,-1, GUI.COLOR.WHITE)));
        Assertions.assertTrue(classicBehavior.gameOverStatus(layoutController));
    }
    @Test
    public void gameOverWinTest(){
        Assertions.assertFalse(classicBehavior.gameOverWin(layoutController));
    }
    @Test
    public void isPvPTest() {
        Assertions.assertFalse(classicBehavior.isPvP());
    }

    @Test
    public void instaDropAvailableTest() {
        Assertions.assertTrue(classicBehavior.instaDropAvailable());
    }

    @Test
    public void incrementScoreTest() {
        classicBehavior.incrementScore(1);
        Assertions.assertEquals(1,classicBehavior.getScoreNumber());
    }

    @Test
    public void getScoreStringTest() {
        Assertions.assertEquals("0",classicBehavior.getScoreString());
    }

    @Test
    public void getScoreNumberTest() {
        Assertions.assertEquals(0,classicBehavior.getScoreNumber());
    }

    @Test
    public void checkLeaderboardUpdateTest() throws FileNotFoundException {
        List<String> newLeaderboard = Arrays.asList("AAA - 5000", "BBB - 4000", "CCC - 3000");
        PrintWriter writer = new PrintWriter(file);
        for (String leader: newLeaderboard){
            writer.println(leader);
        }
        writer.close();
        Assertions.assertTrue(classicBehavior.checkLeaderboardUpdate());
        newLeaderboard = Arrays.asList("AAA - 5000", "BBB - 4500", "CCC - 4000", "DDD - 3500",
                "EEE - 3000", "FFF - 2500", "GGG - 2000", "HHH - 1500");
        writer = new PrintWriter(file);
        for (String leader: newLeaderboard){
            writer.println(leader);
        }
        writer.close();
        Assertions.assertFalse(classicBehavior.checkLeaderboardUpdate());
        classicBehavior.incrementScore(1500);
        Assertions.assertTrue(classicBehavior.checkLeaderboardUpdate());
    }
}
