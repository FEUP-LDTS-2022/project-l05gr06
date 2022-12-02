package tetrisRunner.model.game.shapes;

import tetrisRunner.model.Position;

import java.util.List;

public class ShapeS extends Shape{
    public ShapeS(List<Position> pos) {
        super.shapePos = pos;
    }
    @Override
    public void rotateClockwise() {

    }

    @Override
    public void rotateAntiClockwise() {

    }
}
