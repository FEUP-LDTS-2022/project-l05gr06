package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.shapes.RandomShapeFactory;
import tetrisRunner.model.game.shapes.Shape;
import tetrisRunner.model.game.shapes.ShapeFactory;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.states.GameOverState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShapeController extends GameController{
    private long lastMovementBlock;
    private long maneuvering;

    private long fallTimeBlock = 400;
    private long maneuverTime = 700;

    final int ground;

    public long getFallTimeBlock() {
        return fallTimeBlock;
    }

    public void setFallTimeBlock(long fallTimeBlock) {
        this.fallTimeBlock = fallTimeBlock;
    }
    public ShapeController(Layout model) {
        super(model);
        this.lastMovementBlock = 0;
        this.maneuvering = 0;
        this.ground  = getModel().getHeight()-2;
    }

    public void instaDrop(){
        if (getModel().instaDropAvailable()) {
            while (isFalling(getModel().getShape())) {
                if(getModel().isClassic()) getModel().incrementScore(2);
                getModel().getShape().fall();
            }
        }
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
            jacobPush("left");
            shape.moveLeft();
        }
    }

    public void moveShapeRight(){
        Shape shape = getModel().getShape();
        if(canMoveRight(shape)){
            jacobPush("right");
            shape.moveRight();
        }
    }

    public void jacobPush(String direction){
        Position jacobPos = getModel().getJacob().getPosition();
        Shape shape = getModel().getShape();

        if(direction == "right"){
                if(shape.getShapePos().contains(jacobPos.getLeft()))
                    getModel().getJacob().setPosition(getModel().getJacob().getPosition().getRight());
        }

        if(direction == "left") {
            if (shape.getShapePos().contains(jacobPos.getRight()))
                getModel().getJacob().setPosition(getModel().getJacob().getPosition().getLeft());

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
    public boolean canShapeRotate(Shape shape,List<Position> positions){
        for (Position pos: shape.rotate(positions)) {
            if(!getModel().isEmpty(pos) && !positions.contains(pos))
                return  false;
        }
        return true;
    }


    public void shapeRotateClockWise(){
        Shape shape = getModel().getShape();
        shape.rotateClockwise(); boolean rotate;
        rotate = tryRotate(shape,shape.getShapePos());
        if(!rotate){
            for(int i = 1; i < 4;i++){
                List<Position> positionsTest = newShapePosTest(shape.getShapePos(),i);
                rotate = tryRotate(shape,positionsTest);
                if(rotate) break;
                List<Position> positionsTest1 = newShapePosTest(shape.getShapePos(),-i);
                rotate = tryRotate(shape,positionsTest1);
                if(rotate) break;
            }
        }
        if(!rotate){
            shapeRotateAntiClockWise();
        }
    }
    public List<Position> newShapePosTest(List<Position> positions, int i){
        List<Position> retPos = new ArrayList<>();
        for(int h = 0; h < positions.size();h++){
            if(h == 1){
                retPos.add(new Position(positions.get(h).getX()+i,positions.get(h).getY()));
            }
            else{
                retPos.add(positions.get(h));
            }
        }
        return retPos;
    }
    public boolean tryRotate(Shape shape,List<Position> positions){
        if(canShapeRotate(shape,positions)){
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
        rotate = tryRotate(shape,shape.getShapePos());
        if(!rotate){
            for(int i = 1; i < 4;i++){
                List<Position> positionsTest = newShapePosTest(shape.getShapePos(),i);
                rotate = tryRotate(shape,positionsTest);
                if(rotate) break;
                List<Position> positionsTest1 = newShapePosTest(shape.getShapePos(),-i);
                rotate = tryRotate(shape,positionsTest1);
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

    private void resign1v1(Game game){
        if (getModel().isPvP()) {
            game.getMatchScore().jacobWon();
            game.setState(new GameOverState(new GameOver(GUI.NAME_STATES.JACOB_WON)));
        }
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {


        Shape shape = getModel().getShape();

        if (!isFalling(shape))
            startManeuver(shape, time);
        else shape.setImpact(true);

        switch (action) {
            case D -> moveShapeRight();
            case A -> moveShapeLeft();
            case S -> shapeRotateAntiClockWise();
            case W -> shapeRotateClockWise();
            case SPACE -> instaDrop();
            case R -> resign1v1(game);
            }
            if (time - maneuvering > maneuverTime) {

                transformShapeToBlock();
                createShape(getModel().getShape());
                if (time - lastMovementBlock > fallTimeBlock) {
                    fallShape();
                    lastMovementBlock = time;

                }
            }
        }
    }
