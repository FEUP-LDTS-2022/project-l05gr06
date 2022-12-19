package tetrisRunner.model.shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.shapes.ShapeZ;

import java.util.Arrays;
import java.util.List;

public class ShapeZTest {
    private List<Position> startPositions ;
    private List<Position> case0;
    private List<Position> case1;
    private List<Position> case2;
    private List<Position> case3;
    @BeforeEach
    public void helper(){
        startPositions = Arrays.asList(new Position(9,9), new Position(10,9), new Position(10,8), new Position(11,8));
        case0 = Arrays.asList(new Position(9,9), new Position(10,9), new Position(10,8), new Position(11,8));
        case1 = Arrays.asList(new Position(10,8), new Position(10,9), new Position(11,9), new Position(11,10));
        case2 = Arrays.asList(new Position(11,9), new Position(10,9), new Position(10,10), new Position(9,10));
        case3 = Arrays.asList(new Position(10,10), new Position(10,9), new Position(9,9), new Position(9,8));
    }
    @Test
    public void rotateCase0Test(){
        ShapeZ shape = new ShapeZ(startPositions);
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
        ShapeZ shape = new ShapeZ(startPositions);
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
        ShapeZ shape = new ShapeZ(startPositions);
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
        ShapeZ shape = new ShapeZ(startPositions);
        shape.setDirection(3);
        int i = 0;
        for(Position position: shape.rotate(startPositions)){
            Assertions.assertEquals(case3.get(i).getX(),position.getX());
            Assertions.assertEquals(case3.get(i).getY(),position.getY());
            i++;
        }
    }
}
