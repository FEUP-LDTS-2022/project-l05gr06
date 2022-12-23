package tetrisRunner.controller.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.shapes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ShapeControllerTest {
    private ShapeController shapeController;
    private Layout layout;

    @BeforeEach
    void setUp() {
        layout = new Layout(20,20);
        layout.setBlocks(Arrays.asList());
        layout.setJacob(new Jacob(19,19));
        layout.setWalls(Arrays.asList(new Wall(10, 18)));
        shapeController = new ShapeController(layout);
    }

    @Test
    public void goFasterTest() {
        shapeController.setFallTimeBlock(300);
        shapeController.goFaster();
        Assertions.assertEquals(275, shapeController.getFallTimeBlock());
        shapeController.setFallTimeBlock(101);
        shapeController.goFaster();
        Assertions.assertEquals(76, shapeController.getFallTimeBlock());
        shapeController.setFallTimeBlock(100);
        shapeController.goFaster();
        Assertions.assertEquals(100, shapeController.getFallTimeBlock());
    }

    @Test
    public void fallShapeEmptyTest() {
       layout.setShape(new ShapeToTest(Arrays.asList(new Position(5, 5), new Position(6, 5))));
       shapeController.fallShape();
       List<Position> exp = Arrays.asList(new Position(5,6),new Position(6,6));
       int i = 0;
       for(Position position:layout.getShape().getShapePos()){
           Assertions.assertEquals(exp.get(i).getX(), position.getX());
           Assertions.assertEquals(exp.get(i).getY(), position.getY());
           i++;
       }
    }

    @Test
    public void fallShapeNotEmptyTest() {
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(5, 5), new Position(6, 5))));
        layout.setBlocks(Arrays.asList(new Block(5,6,GUI.COLOR.RED)));
        shapeController.fallShape();
        List<Position> exp = Arrays.asList(new Position(5,5),new Position(6,5));
        int i = 0;
        for(Position position:layout.getShape().getShapePos()){
            Assertions.assertEquals(exp.get(i).getX(), position.getX());
            Assertions.assertEquals(exp.get(i).getY(), position.getY());
            i++;
        }
    }
    @Test
    public void isFallingTest() {
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(5, 5), new Position(6, 5))));
        Assertions.assertEquals(true,shapeController.isFalling(layout.getShape()));
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(-3, 17), new Position(-4, 17))));
        Assertions.assertEquals(false,shapeController.isFalling(layout.getShape()));
    }
    @Test
    public void canMoveRightTest(){
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(5, 5), new Position(6, 5))));
        Assertions.assertEquals(true,shapeController.canMoveRight(layout.getShape()));
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(0, 5), new Position(1, 5))));
        Assertions.assertEquals(true,shapeController.canMoveRight(layout.getShape()));
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(18, 5), new Position(19, 5))));
        Assertions.assertEquals(false,shapeController.canMoveRight(layout.getShape()));
    }
    @Test
    public void canMoveLeftTest(){
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(5, 5), new Position(6, 5))));
        Assertions.assertEquals(true,shapeController.canMoveLeft(layout.getShape()));
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(0, 5), new Position(1, 5))));
        Assertions.assertEquals(false,shapeController.canMoveLeft(layout.getShape()));
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(18, 5), new Position(19, 5))));
        Assertions.assertEquals(true,shapeController.canMoveLeft(layout.getShape()));
    }
    @Test
    public void moveShapeLeftTest(){
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(5, 5), new Position(6, 5))));
        shapeController.moveShapeLeft();
        List<Position> exp = Arrays.asList(new Position(4, 5), new Position(5, 5));
        int i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp.get(i).getX(), position.getX());
            Assertions.assertEquals(exp.get(i).getY(), position.getY());
            i++;
        }
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(10, 10), new Position(11, 10))));
        shapeController.moveShapeLeft();
        List<Position> exp1 = Arrays.asList(new Position(9, 10), new Position(10, 10));
        i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp1.get(i).getX(), position.getX());
            Assertions.assertEquals(exp1.get(i).getY(), position.getY());
            i++;
        }
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(0, 5), new Position(1, 5))));
        shapeController.moveShapeLeft();
        List<Position> exp2 = Arrays.asList(new Position(0, 5), new Position(1, 5));
        i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp2.get(i).getX(), position.getX());
            Assertions.assertEquals(exp2.get(i).getY(), position.getY());
            i++;
        }
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(18, 5), new Position(19, 5))));
        shapeController.moveShapeLeft();
        List<Position> exp3 = Arrays.asList(new Position(17,5), new Position(18, 5));
        i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp3.get(i).getX(), position.getX());
            Assertions.assertEquals(exp3.get(i).getY(), position.getY());
            i++;
        }
    }
    @Test
    public void moveShapeRightTest(){
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(5, 5), new Position(6, 5))));
        shapeController.moveShapeRight();
        List<Position> exp = Arrays.asList(new Position(6, 5), new Position(7, 5));
        int i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp.get(i).getX(), position.getX());
            Assertions.assertEquals(exp.get(i).getY(), position.getY());
            i++;
        }
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(10, 10), new Position(11, 10))));
        shapeController.moveShapeRight();
        List<Position> exp1 = Arrays.asList(new Position(11, 10), new Position(12, 10));
        i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp1.get(i).getX(), position.getX());
            Assertions.assertEquals(exp1.get(i).getY(), position.getY());
            i++;
        }
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(0, 5), new Position(1, 5))));
        shapeController.moveShapeRight();
        List<Position> exp2 = Arrays.asList(new Position(1, 5), new Position(2, 5));
        i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp2.get(i).getX(), position.getX());
            Assertions.assertEquals(exp2.get(i).getY(), position.getY());
            i++;
        }
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(19, 5), new Position(20, 5))));
        shapeController.moveShapeRight();
        List<Position> exp3 = Arrays.asList(new Position(19,5), new Position(20, 5));
        i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp3.get(i).getX(), position.getX());
            Assertions.assertEquals(exp3.get(i).getY(), position.getY());
            i++;
        }
    }

    @Test
    public void transformShapeToBlockTest(){
        layout.setShape(new ShapeToTest(Arrays.asList(new Position(5, -1), new Position(6, -1))));
        shapeController.transformShapeToBlock();
        List<Position> exp = Arrays.asList(new Position(5, -1), new Position(6, -1));
        int i = 0;
        for(Block block:layout.getBlocks()){
            Assertions.assertEquals(exp.get(i).getX(), block.getPosition().getX());
            Assertions.assertEquals(exp.get(i).getY(), block.getPosition().getY());
            i++;
        }
    }
    @Test
    public void newShapePosTest(){
        List<Position> exp = Arrays.asList(new Position(5,5),new Position(8,5));
        List<Position> res = shapeController.newShapePosTest(Arrays.asList(new Position(5,5),new Position(6,5)),2);
        int i = 0;
        for(Position position:res){
            Assertions.assertEquals(exp.get(i).getX(), position.getX());
            Assertions.assertEquals(exp.get(i).getY(), position.getY());
            i++;
        }
    }
    @Test
    public void canShapeRotateTest(){
        ShapeToTest shape =new ShapeToTest(Arrays.asList(new Position(5, 3), new Position(6, 3)));
        shape.setDirection(1);
        layout.setShape(shape);
        Assertions.assertEquals(true,shapeController.canShapeRotate(layout.getShape(),layout.getShape().getShapePos()));
        layout.setBlocks(Arrays.asList(new Block(5,4, GUI.COLOR.RED),new Block(6,4, GUI.COLOR.RED)));
        Assertions.assertEquals(false,shapeController.canShapeRotate(layout.getShape(),layout.getShape().getShapePos()));
        shape = new ShapeToTest(Arrays.asList(new Position(0, 3), new Position(1, 3)));
        shape.setDirection(3);
        Assertions.assertEquals(false,shapeController.canShapeRotate(layout.getShape(),layout.getShape().getShapePos()));
        shape = new ShapeToTest(Arrays.asList(new Position(3, 20), new Position(4, 20)));
        shape.setDirection(1);
        Assertions.assertEquals(false,shapeController.canShapeRotate(layout.getShape(),layout.getShape().getShapePos()));
        shape = new ShapeToTest(Arrays.asList(new Position(0, 0), new Position(0, 0)));
        shape.setDirection(1);
        Assertions.assertEquals(false,shapeController.canShapeRotate(layout.getShape(),layout.getShape().getShapePos()));
    }

    @Test
    public void tryRotateTest(){
        ShapeToTest shape =new ShapeToTest(Arrays.asList(new Position(5, 3), new Position(6, 3)));
        shape.setDirection(3);
        layout.setShape(shape);
        List<Position> exp = Arrays.asList(new Position(6, 3), new Position(6, 2));
        Assertions.assertEquals(true,shapeController.tryRotate(layout.getShape(),layout.getShape().getShapePos()));
        int i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp.get(i).getX(), position.getX());
            Assertions.assertEquals(exp.get(i).getY(), position.getY());
            i++;
        }
        shape = new ShapeToTest(Arrays.asList(new Position(10, 3), new Position(10, 4)));
        shape.setDirection(2);
        layout.setShape(shape);
        List<Position> exp1 = Arrays.asList(new Position(11, 3), new Position(10, 3));
        Assertions.assertEquals(true,shapeController.tryRotate(layout.getShape(),layout.getShape().getShapePos()));
        i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp1.get(i).getX(), position.getX());
            Assertions.assertEquals(exp1.get(i).getY(), position.getY());
            i++;
        }
        shape = new ShapeToTest(Arrays.asList(new Position(-1, 6), new Position(0, 7)));
        shape.setDirection(1);
        layout.setShape(shape);
        List<Position> exp2 = Arrays.asList(new Position(-1, 6), new Position(0, 7));
        Assertions.assertEquals(false,shapeController.tryRotate(layout.getShape(),layout.getShape().getShapePos()));
        i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp2.get(i).getX(), position.getX());
            Assertions.assertEquals(exp2.get(i).getY(), position.getY());
            i++;
        }

        shape = new ShapeToTest(Arrays.asList(new Position(19, 3), new Position(20, 4)));
        shape.setDirection(0);
        layout.setShape(shape);
        List<Position> exp3 = Arrays.asList(new Position(19, 3), new Position(20, 4));
        Assertions.assertEquals(false,shapeController.tryRotate(layout.getShape(),layout.getShape().getShapePos()));
        i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp3.get(i).getX(), position.getX());
            Assertions.assertEquals(exp3.get(i).getY(), position.getY());
            i++;
        }

    }
    @Test
    public void shapeRotateClockWiseTest(){
        ShapeToTest shape = new ShapeToTest(Arrays.asList(new Position(5, 6), new Position(6, 6)));
        layout.setShape(shape);
        shapeController.shapeRotateClockWise();
        List<Position> exp = Arrays.asList(new Position(6, 6), new Position(6, 7));
        Assertions.assertEquals(1,layout.getShape().getDirection());
        int i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp.get(i).getX(), position.getX());
            Assertions.assertEquals(exp.get(i).getY(), position.getY());
            i++;
        }
        shapeController.shapeRotateClockWise();
        List<Position> exp1 = Arrays.asList(new Position(7, 6), new Position(6, 6));
        Assertions.assertEquals(2,layout.getShape().getDirection());
        i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp1.get(i).getX(), position.getX());
            Assertions.assertEquals(exp1.get(i).getY(), position.getY());
            i++;
        }
        shapeController.shapeRotateClockWise();
        List<Position> exp2 = Arrays.asList(new Position(6, 6), new Position(6, 5));
        Assertions.assertEquals(3,layout.getShape().getDirection());
        i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp2.get(i).getX(), position.getX());
            Assertions.assertEquals(exp2.get(i).getY(), position.getY());
            i++;
        }
        shapeController.shapeRotateClockWise();
        List<Position> exp3 = Arrays.asList(new Position(5, 6), new Position(6, 6));
        Assertions.assertEquals(0,layout.getShape().getDirection());
        i = 0;
        for(Position position: layout.getShape().getShapePos()){
            Assertions.assertEquals(exp3.get(i).getX(), position.getX());
            Assertions.assertEquals(exp3.get(i).getY(), position.getY());
            i++;
        }
    }
    @Test
    public void shapeRotateAntiClockWiseTest(){

    }
    class ShapeToTest extends Shape {
        ShapeToTest(List<Position> positions) {
            super(positions, GUI.COLOR.WHITE);
        }

        @Override
        public List<Position> rotate(List<Position> positions1) {
            List<Position> positions = new ArrayList<>();
            int x = positions1.get(0).getX(); int y = positions1.get(0).getY();
            switch (getDirection()) {
                case 0 -> {
                    positions.add(new Position(x , y));
                    positions.add(new Position(x+1, y));
                }
                case 1 -> {
                    positions.add(new Position(x, y));
                    positions.add(new Position(x, y+1));
                }
                case 2 -> {
                    positions.add(new Position(x,y));
                    positions.add(new Position(x-1, y));
                }
                case 3 -> {
                    positions.add(new Position(x, y));
                    positions.add(new Position(x, y-1));
                }
            }
            return positions;
        }
    }
}

