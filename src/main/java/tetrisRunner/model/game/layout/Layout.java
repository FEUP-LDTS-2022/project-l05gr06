package tetrisRunner.model.game.layout;

import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;
import tetrisRunner.model.game.shapes.Shape;

import java.util.List;

public class Layout {
    private final int width;
    private final int height;
    private Jacob jacob;

    private List<Wall> walls;
    private List<Shape> shapes;
    public Layout(int width,int height){
        this.width = width;
        this.height = height;
    }
    public Jacob getJacob(){
        return jacob;
    }

    public void setJacob(Jacob jacob) {
        this.jacob = jacob;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        for (Shape shape : shapes)
            for (Position pos: shape.getShapePos())
                if (pos.equals(position))
                    return false;
        return true;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
