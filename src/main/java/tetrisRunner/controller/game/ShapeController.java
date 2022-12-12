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
import java.util.ArrayList;
import java.util.List;

public class ShapeController extends GameController{
    private long lastMovementBlock;
    private long maneuvering;

    private long fallTimeBlock = 400;
    private long maneuverTime = 700;

    final int ground;

    public ShapeController(Layout model) {
        super(model);
        this.lastMovementBlock = 0;
        this.maneuvering = 0;
        this.ground  = getModel().getHeight()-2;
    }

    public void instaDrop(){

        long temp = fallTimeBlock;

        while (isFalling(getModel().getShape())){fallTimeBlock=1; getModel().getShape().fall();}

        fallTimeBlock=temp;
    }

    public void goFaster(){

        if(fallTimeBlock>100) {
            this.fallTimeBlock = fallTimeBlock - 25;
            this.maneuverTime = maneuverTime - 25;
        }


    }
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
    public boolean canShapeRotateClockWise(Shape shape,List<Position> positions){
        for (Position pos: shape.rotate(positions)) {
            if(!getModel().isEmpty(pos) && !positions.contains(pos))
                return  false;
        }
        return true;
    }
    public boolean canShapeRotateAntiClockWise(Shape shape,List<Position> positions){
        for (Position pos: shape.rotate(positions)) {
            if(!getModel().isEmpty(pos) && !positions.contains(pos))
                return  false;
        }
        return true;
    }

    public void shapeRotateClockWise(){
        Shape shape = getModel().getShape();
        shape.rotateClockwise(); boolean rotate;
        rotate = tryRotateClockWise(shape,shape.getShapePos());
        if(!rotate){
            for(int i = 1; i < 4;i++){
                List<Position> positionsTest = newShapePosTest(shape.getShapePos(),i);
                rotate = tryRotateClockWise(shape,positionsTest);
                if(rotate) break;
                List<Position> positionsTest1 = newShapePosTest(shape.getShapePos(),-i);
                rotate = tryRotateClockWise(shape,positionsTest1);
                if(rotate) break;
            }
        }
        if(!rotate){
            shapeRotateAntiClockWise();
        }
    }
    public List<Position> newShapePosTest(List<Position> positions, int i){
        List<Position> retPos = new ArrayList<>();
        retPos.add(positions.get(0));
        retPos.add(new Position(positions.get(1).getX()+i,positions.get(1).getY()));
        retPos.add(positions.get(2));
        retPos.add(positions.get(3));
        return retPos;
    }
    public boolean tryRotateAntiClockWise(Shape shape,List<Position> positions){
        if(canShapeRotateAntiClockWise(shape,positions)){
            int x = shape.getShapePos().get(1).getX();
            shape.setShapePos(shape.rotate(positions));
            while(shape.getShapePos().get(1).getX() > x && canMoveLeft(shape)){
                shape.moveLeft();
            }
            while(shape.getShapePos().get(1).getX() < x && canMoveRight(shape)){
                shape.moveRight();
            }
            return true;
        }
        return false;
    }
    public boolean tryRotateClockWise(Shape shape,List<Position> positions){
        if(canShapeRotateClockWise(shape,positions)){
            int x = shape.getShapePos().get(1).getX();
            shape.setShapePos(shape.rotate(positions));
            while(shape.getShapePos().get(1).getX() > x && canMoveLeft(shape)){
                shape.moveLeft();
            }
            while(shape.getShapePos().get(1).getX() < x && canMoveRight(shape)){
                shape.moveRight();
            }
            return true;
        }
        return false;
    }
    public void shapeRotateAntiClockWise(){
        Shape shape = getModel().getShape();
        shape.rotateAntiClockwise(); boolean rotate;
        rotate = tryRotateAntiClockWise(shape,shape.getShapePos());
        if(!rotate){
            for(int i = 1; i < 4;i++){
                List<Position> positionsTest = newShapePosTest(shape.getShapePos(),i);
                rotate = tryRotateAntiClockWise(shape,positionsTest);
                if(rotate) break;
                List<Position> positionsTest1 = newShapePosTest(shape.getShapePos(),-i);
                rotate = tryRotateAntiClockWise(shape,positionsTest1);
                if(rotate) break;
            }
        }
        if(!rotate){
            shapeRotateClockWise();
        }
    }
    public void transformShapeToBlock(){
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
            case SPACE -> {if(getModel().instaDropAvailable()) instaDrop();}
            }

        if (time-maneuvering>maneuverTime){

            transformShapeToBlock();
            createShape(getModel().getShape());
            if (time - lastMovementBlock > fallTimeBlock) {
                fallShape();
                lastMovementBlock = time;
            }
        }
    }
}
