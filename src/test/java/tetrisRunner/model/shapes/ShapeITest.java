package tetrisRunner.model.shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.model.Position;
import tetrisRunner.model.PositionTest;
import tetrisRunner.model.game.shapes.ShapeI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ShapeITest {
    private List<Position> startPositions ;
    private List<Position> case0;
    private List<Position> case1;
    private List<Position> case2;
    private List<Position> case3;
    @BeforeEach
    public void helper(){
        startPositions = Arrays.asList(new Position(10,9), new Position(10,8), new Position(10,7), new Position(10,6));
        case0 = Arrays.asList(new Position(9,8),new Position(10,8),new Position(11,8),new Position(12,8));
        case1 = Arrays.asList(new Position(10,7),new Position(10,8),new Position(10,9),new Position(10,10));
        case2 = Arrays.asList(new Position(11,8),new Position(10,8), new Position(9,8), new Position(8,8));
        case3 = Arrays.asList(new Position(10,9),new Position(10,8), new Position(10,7), new Position(10,6));
    }
    @Test
    public void rotateCase0Test(){
        ShapeI shape = new ShapeI(startPositions);
        shape.setDirection(0);
        int i = 0;
        for(Position position: shape.rotate(startPositions)){
            Assertions.assertEquals(case0.get(i).getX(),position.getX());
            Assertions.assertEquals(case0.get(i).getY(),position.getY());
            i++;
        }
    }

    @Test
    public void rotateCase1Test(){
        ShapeI shape = new ShapeI(startPositions);
        shape.setDirection(1);
        int i = 0;
        for(Position position: shape.rotate(startPositions)){
            Assertions.assertEquals(case1.get(i).getX(),position.getX());
            Assertions.assertEquals(case1.get(i).getY(),position.getY());
            i++;
        }
    }
    @Test
    public void rotateCase2Test(){
        ShapeI shape = new ShapeI(startPositions);
        shape.setDirection(2);
        int i = 0;
        for(Position position: shape.rotate(startPositions)){
            Assertions.assertEquals(case2.get(i).getX(),position.getX());
            Assertions.assertEquals(case2.get(i).getY(),position.getY());
            i++;
        }
    }
    @Test
    public void rotateCase3Test(){
        ShapeI shape = new ShapeI(startPositions);
        shape.setDirection(3);
        int i = 0;
        for(Position position: shape.rotate(startPositions)){
            Assertions.assertEquals(case3.get(i).getX(),position.getX());
            Assertions.assertEquals(case3.get(i).getY(),position.getY());
            i++;
        }
    }
}
