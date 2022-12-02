package tetrisRunner.model.game.shapes;

import tetrisRunner.model.Position;

import java.util.List;

public abstract class Shape {
    private List<Position> shapePos;

    public void moveRight(){
        for (Position pos: shapePos){
            pos.getRight();
        }
    }
    public void moveLeft(){
        for (Position pos: shapePos){
            pos.getLeft();
        }
    }

    public List<Position> getShapePos() {
        return shapePos;
    }

    public abstract void rotateClockwise();
    public abstract void rotateAntiClockwise();

}
