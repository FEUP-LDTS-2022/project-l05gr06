package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.shapes.Shape;

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
        List<Position> newpos = new ArrayList<>();
        for(Shape shape:shapes){
            if (isFalling(shape)){
                for (Position pos: shape.getShapePos()) newpos.add(pos.fall());
                shape.setShapePos(new ArrayList<>(newpos));
                newpos.clear();
            }
        }
    }
    public void moveShapeLeft(){
        List<Shape> shapes = getModel().getShapes();
        List<Position> newpos = new ArrayList<>();
        Shape shape = shapes.get(shapes.size()-1);
        if(canMoveLeft(shape) && isFalling(shape)){
            for (Position pos: shape.getShapePos()) newpos.add(pos.getLeft());
            shape.setShapePos(new ArrayList<>(newpos));
            newpos.clear();
        }
    }
    public void moveShapeRight(){
        List<Shape> shapes = getModel().getShapes();
        List<Position> newpos = new ArrayList<>();
        Shape shape = shapes.get(shapes.size()-1);
        if(canMoveRight(shape) && isFalling(shape)){
            for (Position pos: shape.getShapePos()) newpos.add(pos.getRight());
            shape.setShapePos(new ArrayList<>(newpos));
            newpos.clear();
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


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time-lastMovementBlock>fallTimeBlock) {
            fallShape();
            lastMovementBlock = time;
        }
        switch (action){
            case SHAPE_RIGHT:
                moveShapeRight();
                break;
            case SHAPE_LEFT:
                moveShapeLeft();
                break;
        }
    }
}
