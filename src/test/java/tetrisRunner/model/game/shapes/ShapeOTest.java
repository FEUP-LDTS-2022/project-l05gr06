package tetrisRunner.model.game.shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.shapes.ShapeO;

import java.util.Arrays;
import java.util.List;

public class ShapeOTest {
    private List<Position> startPositions ;
    @BeforeEach
    public void helper(){
        startPositions = Arrays.asList(new Position(10,9), new Position(10,8), new Position(10,7), new Position(10,6));
    }
    @Test
    public void rotateTest(){
        ShapeO shape = new ShapeO(startPositions);
        int i = 0;
        for(Position position: shape.rotate(startPositions)){
            Assertions.assertEquals(startPositions.get(i).getX(),position.getX());
            Assertions.assertEquals(startPositions.get(i).getY(),position.getY());
            i++;
        }
    }


}
