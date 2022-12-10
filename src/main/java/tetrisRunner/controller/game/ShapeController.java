package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.shapes.RandomShapeFactory;
import tetrisRunner.model.game.shapes.Shape;
import tetrisRunner.model.game.shapes.ShapeFactory;

import java.io.IOException;
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
        Shape shape = getModel().getShape();
        if (isFalling(shape)){
            shape.fall();
        }
    }

    public void moveShapeLeft(){
        Shape shape = getModel().getShape();
        if(canMoveLeft(shape)){
            shape.moveLeft();
        }
    }

    public void moveShapeRight(){
        Shape shape = getModel().getShape();
        if(canMoveRight(shape)){
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
        Shape shape = getModel().getShape();
        shape.rotateClockwise();
        if(canShapeRotateClockWise(shape)) {
            shape.setShapePos(shape.rotate());
        }
        else{
            shapeRotateAntiClockWise();
        }
    }

    public void shapeRotateAntiClockWise(){
        Shape shape = getModel().getShape();
        shape.rotateAntiClockwise();
        if(canShapeRotateAntiClockWise(shape)){
            shape.setShapePos(shape.rotate());
        }
        else{
            shapeRotateClockWise();
        }
    }
    public void transformShapetoBlock(){
        Shape shape = getModel().getShape();
        if(!isFalling(shape)){
            for (Position position : shape.getShapePos()){
                getModel().addBlock(new Block(position.getX(), position.getY(), shape.getColor()));
            }
        }
    }
    private void createShape(Shape shape){
        if (!isFalling(shape)) {
            ShapeFactory factory = new RandomShapeFactory();
            getModel().setShape(factory.createShape());
        }
    }
    private void startManeuver(Shape shape, long time) {
        if (shape.isImpact())
            this.maneuvering = time;
        shape.setImpact(false);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        Shape shape = getModel().getShape();
        if (!isFalling(shape))
            startManeuver(shape, time);
        else shape.setImpact(true);

        switch (action) {
            case SHAPE_RIGHT -> moveShapeRight();
            case SHAPE_LEFT -> moveShapeLeft();
            case SHAPE_ROTATE_ANTI_CLOCK_WISE -> shapeRotateAntiClockWise();
            case SHAPE_ROTATE_CLOCK_WISE -> shapeRotateClockWise();
            }

        if (time-maneuvering>maneuverTime){

            transformShapetoBlock();
            createShape(getModel().getShape());
            if (time - lastMovementBlock > fallTimeBlock) {
                fallShape();
                lastMovementBlock = time;
            }
        }
    }
}
