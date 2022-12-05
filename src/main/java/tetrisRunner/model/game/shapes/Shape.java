package tetrisRunner.model.game.shapes;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.util.List;

public abstract class Shape {
    private List<Position> shapePos;

    private GUI.COLOR color;

    public Shape(List<Position> shapePos, GUI.COLOR color) {
        this.shapePos = shapePos;
        this.color=color;
    }

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

    public void setShapePos(List<Position> shapePos) {
        this.shapePos = shapePos;
    }

    public GUI.COLOR getColor() {
        return color;
    }


    public abstract void rotateClockwise();
    public abstract void rotateAntiClockwise();

}
