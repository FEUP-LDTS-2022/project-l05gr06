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
    private long maneuvering;

    static final long fallTimeBlock = 400;
    static final long maneuverTime = 700;

    final int ground;

    public ShapeController(Layout model) {
        super(model);
        this.lastMovementBlock = 0;
        this.maneuvering = 0;
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

    public void maneuverLeft(){
        List<Shape> shapes = getModel().getShapes();
        Shape shape = shapes.get(shapes.size()-1);
        if(canMoveLeft(shape)){
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

    public void maneuverRight(){
        List<Shape> shapes = getModel().getShapes();
        Shape shape = shapes.get(shapes.size()-1);
        if(canMoveLeft(shape)){
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
    public boolean canShapeRotateClockWise(Shape shape){
        for (Position pos: shape.rotate()) {
            if(!getModel().isEmpty(pos) && !shape.getShapePos().contains(pos))
                return  false;
        }
        return true;
    }
    public boolean canShapeRotateAntiClockWise(Shape shape){
        for (Position pos: shape.rotate()) {
            if(!getModel().isEmpty(pos) && !shape.getShapePos().contains(pos))
                return  false;
        }
        return true;
    }



    public void shapeRotateClockWise(){
        List<Shape> shapes = getModel().getShapes();
        Shape shape = shapes.get(shapes.size()-1);
        shape.rotateClockwise();
        if(canShapeRotateClockWise(shape)) {
            shape.setShapePos(shape.rotate());
        }
        else{
            shapeRotateAntiClockWise();
        }
    }

    public void shapeRotateAntiClockWise(){
        List<Shape> shapes = getModel().getShapes();
        Shape shape = shapes.get(shapes.size()-1);
        shape.rotateAntiClockwise();
        if(canShapeRotateAntiClockWise(shape)){
            shape.setShapePos(shape.rotate());
        }
        else{
            shapeRotateClockWise();
        }
    }
    private void createShapes(List<Shape> shapes){
        if (!isFalling(shapes.get(shapes.size()-1))) {
            ShapeFactory factory = new RandomShapeFactory();
            getModel().getShapes().add(factory.createShape());
        }
    }
    private void startManeuver(Shape shape, long time) {
        if (shape.isImpact())
            this.maneuvering = time;
        shape.setImpact(false);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        Shape shape = getModel().getShapes().get(getModel().getShapes().size()-1);
        if (!isFalling(shape))
            startManeuver(shape, time);
        else shape.setImpact(true);
        if (time-maneuvering<=maneuverTime){
            switch (action) {
                case SHAPE_RIGHT -> maneuverRight();
                case SHAPE_LEFT -> maneuverLeft();
            }
        }
        else {
            switch (action) {
                case SHAPE_RIGHT -> moveShapeRight();
                case SHAPE_LEFT -> moveShapeLeft();
                case SHAPE_ROTATE_ANTI_CLOCK_WISE -> shapeRotateAntiClockWise();
                case SHAPE_ROTATE_CLOCK_WISE -> shapeRotateClockWise();
            }
            createShapes(getModel().getShapes());
            if (time - lastMovementBlock > fallTimeBlock) {
                fallShape();
                lastMovementBlock = time;
            }
        }
    }
}
