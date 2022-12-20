package tetrisRunner.model.shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.shapes.Shape;
import tetrisRunner.model.menu.Menu;
import tetrisRunner.model.menu.MenuTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeTest {
    private ShapeTestAbstract shapeTestAbstract;
    List<Position> moveRightExp;
    List<Position> moveLeftExp;
    List<Position> fallExp;

    @BeforeEach
    public void helper(){
        shapeTestAbstract = new ShapeTestAbstract();
        moveRightExp = Arrays.asList(new Position(6,5),new Position(6,6), new Position(6,7), new Position(6,8));
        moveLeftExp = Arrays.asList(new Position(4,5),new Position(4,6),new Position(4,7), new Position(4,8));
        fallExp = Arrays.asList(new Position(5,6), new Position(5,7),new Position(5,8),new Position(5,9));
        shapeTestAbstract.setDirection(2);
    }

    @Test
    public void moveRightTest(){
        shapeTestAbstract.moveRight();
        int i = 0;
        for(Position position: shapeTestAbstract.getShapePos()){
            Assertions.assertEquals(moveRightExp.get(i).getX(),position.getX());
            Assertions.assertEquals(moveRightExp.get(i).getY(),position.getY());
            i++;
        }

    }
    @Test
    public void moveLeftTest(){
        shapeTestAbstract.moveLeft();
        int i = 0;
        for(Position position: shapeTestAbstract.getShapePos()){
            Assertions.assertEquals(moveLeftExp.get(i).getX(),position.getX());
            Assertions.assertEquals(moveLeftExp.get(i).getY(),position.getY());
            i++;
        }
    }
    @Test
    public void fallTest(){
        shapeTestAbstract.fall();
        int i = 0;
        for(Position position: shapeTestAbstract.getShapePos()){
            Assertions.assertEquals(fallExp.get(i).getX(),position.getX());
            Assertions.assertEquals(fallExp.get(i).getY(),position.getY());
            i++;
        }
    }
    @Test
    public void rotateClockwiseTest(){
        shapeTestAbstract.rotateClockwise();
        Assertions.assertEquals(3,shapeTestAbstract.getDirection());
        shapeTestAbstract.rotateClockwise();
        Assertions.assertEquals(0,shapeTestAbstract.getDirection());
        shapeTestAbstract.rotateClockwise();
        Assertions.assertEquals(1,shapeTestAbstract.getDirection());
    }
    @Test
    public void rotateAntiClockwiseTest(){
        shapeTestAbstract.rotateAntiClockwise();
        Assertions.assertEquals(1,shapeTestAbstract.getDirection());
        shapeTestAbstract.rotateAntiClockwise();
        Assertions.assertEquals(0,shapeTestAbstract.getDirection());
        shapeTestAbstract.rotateAntiClockwise();
        Assertions.assertEquals(3,shapeTestAbstract.getDirection());
    }
    static class ShapeTestAbstract extends Shape {
        ShapeTestAbstract(){
            super(Arrays.asList(new Position(5,5),new Position(5,6), new Position(5,7),new Position(5,8)), GUI.COLOR.WHITE);
        }

        @Override
        public List<Position> rotate(List<Position> positions1) {
            return new ArrayList<>();
        }
    }
}
