package tetrisRunner.model.game.layout;

import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;
import tetrisRunner.model.game.shapes.Shape;
import tetrisRunner.model.game.shapes.*;

import java.util.ArrayList;
import java.util.List;

public class LoaderLayoutBuilder extends LayoutBuilder{
    private final int startPosX;
    private final int startPosY;

    public LoaderLayoutBuilder() {
        this.startPosX = getWidth()/2;
        this.startPosY = getHeight()-3;
    }

    @Override
    protected int getWidth(){
        return 20;
    }
    @Override
    protected int getHeight(){
        return 20;
    }
    @Override
    protected Jacob createJacob(){
        return new Jacob(startPosX,startPosY);
    }
    @Override
    protected List<Shape> createShapes(){
        List<Shape> shapes = new ArrayList<>();
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(15,getHeight()-3));
        positions.add(new Position(16,getHeight()-3));
        positions.add(new Position(16,getHeight()-4));
        positions.add(new Position(15,getHeight()-4));
        shapes.add(new ShapeO(new ArrayList<>(positions))); positions.clear();
        positions.add(new Position(9,0));
        positions.add(new Position(10,0));
        positions.add(new Position(11,0));
        positions.add(new Position(8,0));
        shapes.add(new ShapeI(new ArrayList<>(positions))); positions.clear();
        return shapes;
    }
    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < getWidth(); c++) {
            walls.add(new Wall(c, getHeight()-2));
        }
        for (int r = 0; r < getHeight() - 1 ; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(getWidth() - 1, r));
        }
        return walls;
    }
}
