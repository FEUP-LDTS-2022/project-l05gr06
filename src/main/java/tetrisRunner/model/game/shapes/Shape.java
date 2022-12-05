package tetrisRunner.model.game.shapes;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
    private List<Position> shapePos;
    private int direction = 0;
    private GUI.COLOR color;
    private boolean impact;

    public Shape(List<Position> shapePos, GUI.COLOR color) {
        this.shapePos = shapePos;
        this.color=color;
        this.impact = true;
    }

    public void moveRight(){
        List<Position> temp = new ArrayList<>();
        for (Position pos: shapePos){
            temp.add(pos.getRight());
        }
        setShapePos(temp);
    }
    public void moveLeft(){
        List<Position> temp = new ArrayList<>();
        for (Position pos: shapePos){
            temp.add(pos.getLeft());
        }
        setShapePos(temp);
    }
    public void fall(){
        List<Position> temp = new ArrayList<>();
        for (Position pos: shapePos){
            temp.add(pos.fall());
        }
        setShapePos(temp);
    }

    public List<Position> getShapePos() {
        return shapePos;
    }

    public void setShapePos(List<Position> shapePos) {
        this.shapePos = shapePos;
    }

    public int getDirection() {
        return direction;
    }

    public GUI.COLOR getColor() {
        return color;
    }


    public abstract List<Position> rotate();
    public void rotateClockwise(){
        direction = (direction+1) % 4;
    }
    public void rotateAntiClockwise(){
        direction = (direction+3) % 4;
    }

    public void setImpact(boolean flag){
        this.impact = flag;
    }
    public boolean isImpact() {
        return impact;
    }
}
