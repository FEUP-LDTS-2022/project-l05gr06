package tetrisRunner.viewer.game;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.shapes.*;

public class ShapeViewer {
    public void draw(Shape shape, GUI gui){
        gui.drawShape(shape.getShapePos(), shape.getColor());
    }
}
