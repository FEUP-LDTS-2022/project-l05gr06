package tetrisRunner.model.game.shapes;

import tetrisRunner.model.Position;

import java.util.List;

public class ShapeO extends Shape{
    public ShapeO(List<Position> pos) {
        super.shapePos = pos;
    }
    @Override
    public void rotateClockwise() {

    }

    @Override
    public void rotateAntiClockwise() {

    }
}
