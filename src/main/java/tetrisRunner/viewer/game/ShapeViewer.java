package tetrisRunner.viewer.game;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.shapes.*;

public class ShapeViewer {
    public void draw(Shape shape, GUI gui){
        if (shape instanceof ShapeI) gui.drawShape(shape.getShapePos(), GUI.COLOR.PINK);
        if (shape instanceof ShapeJ) gui.drawShape(shape.getShapePos(), GUI.COLOR.BLUE);
        if (shape instanceof ShapeL) gui.drawShape(shape.getShapePos(), GUI.COLOR.ORANGE);
        if (shape instanceof ShapeO) gui.drawShape(shape.getShapePos(), GUI.COLOR.YELLOW);
        if (shape instanceof ShapeS) gui.drawShape(shape.getShapePos(), GUI.COLOR.GREEN);
        if (shape instanceof ShapeT) gui.drawShape(shape.getShapePos(), GUI.COLOR.PURPLE);
        if (shape instanceof ShapeZ) gui.drawShape(shape.getShapePos(), GUI.COLOR.RED);
    }
}
