package tetrisRunner.model.game.shapes;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.shapes.RandomShapeFactory;
import tetrisRunner.model.game.shapes.Shape;
import tetrisRunner.model.game.shapes.ShapeI;
import tetrisRunner.model.game.shapes.ShapeS;

import java.util.Arrays;
import java.util.List;

public class RandomShapeFactoryTest {
    private List<Position> case0;
    private List<Position> case1;
    private List<Position> case2;
    private List<Position> case3;
    private List<Position> case4;
    private List<Position> case5;
    private List<Position> case6;
    private RandomShapeFactory factory;

    @BeforeEach
    public void helper() {
        case0 = Arrays.asList(new Position(8, 0), new Position(9, 0), new Position(10, 0), new Position(11, 0));
        case1 = Arrays.asList(new Position(9, 0), new Position(10, 0), new Position(11, 0), new Position(9, -1));
        case2 = Arrays.asList(new Position(9, 0), new Position(10, 0), new Position(11, 0), new Position(11, -1));
        case3 = Arrays.asList(new Position(9, 0), new Position(10, 0), new Position(9, -1), new Position(10, -1));
        case4 = Arrays.asList(new Position(9, 0), new Position(10, 0), new Position(10, -1), new Position(11, -1));
        case5 = Arrays.asList(new Position(9, 0), new Position(10, 0), new Position(11, 0), new Position(10, -1));
        case6 = Arrays.asList(new Position(9, -1), new Position(10, -1), new Position(10, 0), new Position(11, 0));
        factory = Mockito.mock(RandomShapeFactory.class);
        Mockito.doCallRealMethod().when(factory).createShape();
    }
    @Test
    public void createShapeITest() {
        Mockito.when(factory.generateRandomInt()).thenReturn(0);
        Shape shape = factory.createShape();
        int i = 0;
        for(Position position: shape.getShapePos()){
            Assertions.assertEquals(case0.get(i).getX(),position.getX());
            Assertions.assertEquals(case0.get(i).getY(),position.getY());
            i++;
        }
    }
    @Test
    public void createShapeJTest() {
        Mockito.when(factory.generateRandomInt()).thenReturn(1);
        Shape shape = factory.createShape();
        int i = 0;
        for(Position position: shape.getShapePos()){
            Assertions.assertEquals(case1.get(i).getX(),position.getX());
            Assertions.assertEquals(case1.get(i).getY(),position.getY());
            i++;
        }
    }
    @Test
    public void createShapeLTest() {
        Mockito.when(factory.generateRandomInt()).thenReturn(2);
        Shape shape = factory.createShape();
        int i = 0;
        for(Position position: shape.getShapePos()){
            Assertions.assertEquals(case2.get(i).getX(),position.getX());
            Assertions.assertEquals(case2.get(i).getY(),position.getY());
            i++;
        }
    }
    @Test
    public void createShapeOTest() {
        Mockito.when(factory.generateRandomInt()).thenReturn(3);
        Shape shape = factory.createShape();
        int i = 0;
        for(Position position: shape.getShapePos()){
            Assertions.assertEquals(case3.get(i).getX(),position.getX());
            Assertions.assertEquals(case3.get(i).getY(),position.getY());
            i++;
        }
    }
    @Test
    public void createShapeSTest() {
        Mockito.when(factory.generateRandomInt()).thenReturn(4);
        Shape shape = factory.createShape();
        int i = 0;
        for(Position position: shape.getShapePos()){
            Assertions.assertEquals(case4.get(i).getX(),position.getX());
            Assertions.assertEquals(case4.get(i).getY(),position.getY());
            i++;
        }
    }
    @Test
    public void createShapeTTest() {
        Mockito.when(factory.generateRandomInt()).thenReturn(5);
        Shape shape = factory.createShape();
        int i = 0;
        for(Position position: shape.getShapePos()){
            Assertions.assertEquals(case5.get(i).getX(),position.getX());
            Assertions.assertEquals(case5.get(i).getY(),position.getY());
            i++;
        }
    }
    @Test
    public void createShapeZTest() {
        Mockito.when(factory.generateRandomInt()).thenReturn(6);
        Shape shape = factory.createShape();
        int i = 0;
        for(Position position: shape.getShapePos()){
            Assertions.assertEquals(case6.get(i).getX(),position.getX());
            Assertions.assertEquals(case6.get(i).getY(),position.getY());
            i++;
        }
    }
}

