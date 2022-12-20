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

public class ClimbingBehaviorTest {
    private ClimbingBehavior climbingBehavior;
    private Layout layout;
    private Jacob jacob;
    private LayoutController layoutController;
    private File file;

    @BeforeEach
    public void helper() throws IOException {
        climbingBehavior = new ClimbingBehavior();
        file = File.createTempFile("testClimbing",".txt");
        String path = file.getAbsolutePath();
        climbingBehavior.setFile(path);
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
        Assertions.assertTrue(climbingBehavior.gameOverStatus(layoutController));
        layout.setWalls(new ArrayList<>());
        Assertions.assertFalse(climbingBehavior.gameOverStatus(layoutController));
        layout.setWalls(Arrays.asList(new Wall(10,16)));
        layout.setBlocks(new ArrayList<>());
        Assertions.assertFalse(climbingBehavior.gameOverStatus(layoutController));
    }
    @Test
    public void gameOverStatusShapeOverLimitTest(){
        Assertions.assertFalse(climbingBehavior.gameOverStatus(layoutController));
        layout.setBlocks(Arrays.asList(new Block(0,16, GUI.COLOR.WHITE), new Block(1,16, GUI.COLOR.WHITE),
                new Block(5,13, GUI.COLOR.WHITE)));
        Assertions.assertFalse(climbingBehavior.gameOverStatus(layoutController));
        layout.setBlocks(Arrays.asList(new Block(1,1, GUI.COLOR.WHITE), new Block(1,0, GUI.COLOR.WHITE),
                new Block(-1,6, GUI.COLOR.WHITE)));
        Assertions.assertFalse(climbingBehavior.gameOverStatus(layoutController));
        layout.setBlocks(Arrays.asList(new Block(3,-1, GUI.COLOR.WHITE)));
        Assertions.assertTrue(climbingBehavior.gameOverStatus(layoutController));
    }
    @Test
    public void gameOverWinTest(){
        Assertions.assertFalse(climbingBehavior.gameOverWin(layoutController));
        layout.setJacob(new Jacob(10,10));
        Assertions.assertFalse(climbingBehavior.gameOverWin(layoutController));
        layout.setJacob(new Jacob(0,-1));
        Assertions.assertTrue(climbingBehavior.gameOverWin(layoutController));
        layout.setJacob(new Jacob(19,-1));
        Assertions.assertTrue(climbingBehavior.gameOverWin(layoutController));
    }
    @Test
    public void isPvPTest() {
        Assertions.assertFalse(climbingBehavior.isPvP());
    }

    @Test
    public void instaDropAvailableTest() {
        Assertions.assertTrue(climbingBehavior.instaDropAvailable());
    }

    @Test
    public void incrementScoreTest() {
        climbingBehavior.incrementScore(1);
        Assertions.assertEquals(1,climbingBehavior.getScoreNumber());
    }

    @Test
    public void getScoreStringTest() {
        Assertions.assertEquals("00:00",climbingBehavior.getScoreString());
        climbingBehavior.incrementScore(34);
        Assertions.assertEquals("00:34",climbingBehavior.getScoreString());
        climbingBehavior.incrementScore(26+60*2+30);
        Assertions.assertEquals("03:30",climbingBehavior.getScoreString());
    }

    @Test
    public void getScoreNumberTest() {
        Assertions.assertEquals(0,climbingBehavior.getScoreNumber());
    }

    @Test
    public void checkLeaderboardUpdateTest() throws FileNotFoundException {
        List<String> newLeaderboard = Arrays.asList("AAA - 00:30", "BBB - 04:12", "CCC - 40:00");
        PrintWriter writer = new PrintWriter(file);
        for (String leader: newLeaderboard){
            writer.println(leader);
        }
        writer.close();
        Assertions.assertTrue(climbingBehavior.checkLeaderboardUpdate());
        newLeaderboard = Arrays.asList("AAA - 00:30", "BBB - 00:40", "CCC - 00:50", "DDD - 01:10",
                "EEE - 01:15", "FFF - 02:14", "GGG - 03:00", "HHH - 04:00");
        writer = new PrintWriter(file);
        for (String leader: newLeaderboard){
            writer.println(leader);
        }
        writer.close();
        Assertions.assertTrue(climbingBehavior.checkLeaderboardUpdate());
        climbingBehavior.incrementScore(15000);
        Assertions.assertFalse(climbingBehavior.checkLeaderboardUpdate());
    }
}
