package tetrisRunner.model.game.shapes;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.util.List;

public class ShapeS extends Shape{
    public ShapeS(List<Position> pos) {
        super(pos,GUI.COLOR.GREEN);

    }
    @Override
    public void rotateClockwise() {

    }

    @Override
    public void rotateAntiClockwise() {

    }
}
