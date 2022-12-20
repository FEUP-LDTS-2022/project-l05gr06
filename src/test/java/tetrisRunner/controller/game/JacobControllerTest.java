package tetrisRunner.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.layout.LoaderLayoutBuilder;
import tetrisRunner.model.game.shapes.RandomShapeFactory;
import tetrisRunner.model.game.shapes.ShapeFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JacobControllerTest {
    private JacobController controller;
    private Jacob jacob;
    private Layout layout;

    @BeforeEach
    void setUp() {
        layout = new Layout(20, 20);

        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < layout.getWidth(); c++) {
            walls.add(new Wall(c, layout.getHeight()-2));
        }
        for (int r = 0; r < layout.getHeight() - 1 ; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(layout.getWidth() - 1, r));
        }

        ShapeFactory factory = new RandomShapeFactory();


        jacob = new Jacob(10, 17);
        layout.setJacob(jacob);

        layout.setBlocks(Arrays.asList());
        layout.setWalls(walls);
        layout.setShape(factory.createShape());

        controller = new JacobController(layout);
    }


    @Test
    void moveJacobRightEmpty() {
        controller.moveJacobRight();
        assertEquals(new Position(11, 17), jacob.getPosition());
    }

    @Test
    void moveJacobRightNotEmpty() {
        layout.setBlocks(Arrays.asList(new Block(11, 17, GUI.COLOR.RED)));
        controller.moveJacobRight();
        assertEquals(new Position(10, 17), jacob.getPosition());
    }

    @Test
    void moveJacobLeftEmpty() {
        controller.moveJacobLeft();
        assertEquals(new Position(9, 17), jacob.getPosition());
    }

    @Test
    void moveJacobLeftNotEmpty() {
        layout.setBlocks(Arrays.asList(new Block(9, 17, GUI.COLOR.RED)));
        controller.moveJacobLeft();
        assertEquals(new Position(10, 17), jacob.getPosition());
    }

    @Test
    void jumpJacobEmpty() {
        controller.jumpJacob();
        assertEquals(new Position(10, 15), jacob.getPosition());
    }

    @Test
    void jumpJacobNotEmpty() {
        layout.setBlocks(Arrays.asList(new Block(10, 16, GUI.COLOR.RED)));
        controller.jumpJacob();
        assertEquals(new Position(10, 17), jacob.getPosition());
    }

    @Test
    void fallJacobEmpty() {
        jacob = new Jacob(10, 13);
        layout.setJacob(jacob);
        controller.fallJacob();
        assertEquals(new Position(10, 14), jacob.getPosition());
    }

    @Test
    void fallJacobNotEmpty() {
        layout.setBlocks(Arrays.asList(new Block(10, 14, GUI.COLOR.RED)));
        jacob = new Jacob(10, 13);
        layout.setJacob(jacob);
        controller.fallJacob();
        assertEquals(new Position(10, 13), jacob.getPosition());
    }


    @Test
    void isFallingJacob() {
        jacob = new Jacob(10, 13);
        layout.setJacob(jacob);
        assertEquals(controller.isFalling(),true);
    }

    @Test
    void isNotFallingJacob() {
        layout.setBlocks(Arrays.asList(new Block(10, 14, GUI.COLOR.RED)));
        jacob = new Jacob(10, 13);
        layout.setJacob(jacob);
        assertEquals(controller.isFalling(),false);

    }

    @Test
    void isAliveJacob() {
        assertEquals(controller.jacobIsAlive(),true);
    }

    @Test
    void isNotAliveJacob() {
        layout.setBlocks(Arrays.asList(new Block(10, 17, GUI.COLOR.RED)));
        assertEquals(controller.jacobIsAlive(),false);
    }

    @Test
    void hasReachedTop() {
        jacob = new Jacob(0, -1);
        layout.setJacob(jacob);
        assertEquals(controller.jacobIsAlive(),true);
        jacob = new Jacob(19, -1);
        layout.setJacob(jacob);
        assertEquals(controller.hasReachedTop(),true);
    }


    @Test
    void hasNotReachedTop() {
        assertEquals(controller.hasReachedTop(),false);
    }


}

