package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.shapes.RandomShapeFactory;
import tetrisRunner.model.game.shapes.Shape;
import tetrisRunner.model.game.shapes.ShapeFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShapeController extends GameController{
    private long lastMovementBlock;
    static final long fallTimeBlock = 700;
    final int ground;

    public ShapeController(Layout model) {
        super(model);
        this.lastMovementBlock = 0;
        this.ground  = getModel().getHeight()-2;
    }

    //TODO ALTERAR IF PARA PARAR CASO BATA EM ALGUMA COISA
    public void fallShape(){
        List<Shape> shapes = getModel().getShapes();
        Shape shape = shapes.get(shapes.size()-1);
        if (isFalling(shape)){
            shape.fall();
        }
    }

    public void moveShapeLeft(){
        List<Shape> shapes = getModel().getShapes();
        Shape shape = shapes.get(shapes.size()-1);
        if(canMoveLeft(shape) && isFalling(shape)){
            shape.moveLeft();
        }
    }
    public void moveShapeRight(){
        List<Shape> shapes = getModel().getShapes();
        Shape shape = shapes.get(shapes.size()-1);
        if(canMoveRight(shape) && isFalling(shape)){
          shape.moveRight();
        }
    }
    public boolean canMoveRight(Shape shape){
        for (Position pos: shape.getShapePos()) {
            if(!getModel().isEmpty(pos.getRight()) && !shape.getShapePos().contains(pos.getRight()))
                return  false;
        }
        return true;
    }
    public boolean canMoveLeft(Shape shape){
        for (Position pos: shape.getShapePos()) {
            if(!getModel().isEmpty(pos.getLeft()) && !shape.getShapePos().contains(pos.getLeft()))
                return  false;
        }
        return true;
    }
    public boolean isFalling(Shape shape){
        for (Position pos: shape.getShapePos()) {
            if(!getModel().isEmpty(pos.fall()) && !shape.getShapePos().contains(pos.fall()))
                 return false;
        }
        return true;
    }
    /*
    public boolean canShapeRotateClockWise(Shape shape){
        for (Position pos: shape.getShapePos()) {
            if(!getModel().isEmpty(pos.getRight()) && !shape.getShapePos().contains(pos.getRight()))
                return  false;
        }
        return true;
    }
    public boolean canShapeAntiRotateClockWise(){

    }
    */

    public void shapeRotateClockWise(){
        List<Shape> shapes = getModel().getShapes();
        Shape shape = shapes.get(shapes.size()-1);
        shape.rotateClockwise();
        shape.rotate();
    }

    public void shapeRotateAntiClockWise(){
        List<Shape> shapes = getModel().getShapes();
        Shape shape = shapes.get(shapes.size()-1);
        shape.rotateAntiClockwise();
        shape.rotate();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        List<Shape> shapes = getModel().getShapes();
        if (time-lastMovementBlock>fallTimeBlock) {
            fallShape();
            lastMovementBlock = time;
        }
        if (!isFalling(shapes.get(shapes.size()-1))) {
            ShapeFactory factory = new RandomShapeFactory();
            getModel().getShapes().add(factory.createShape());
        }
        switch (action){
            case SHAPE_RIGHT:
                moveShapeRight();
                break;
            case SHAPE_LEFT:
                moveShapeLeft();
                break;
            case SHAPE_ROTATE_ANTI_CLOCK_WISE:
                shapeRotateAntiClockWise();
                break;
            case SHAPE_ROTATE_CLOCK_WISE:
                shapeRotateClockWise();
                break;

        }
    }
}
