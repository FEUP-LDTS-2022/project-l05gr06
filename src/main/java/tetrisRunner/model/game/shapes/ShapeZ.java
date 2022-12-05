package tetrisRunner.model.game.shapes;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.util.List;

public class ShapeZ extends Shape{
    public ShapeZ(List<Position> pos) {
        super(pos,GUI.COLOR.RED);
    }
    @Override
    public void rotateClockwise() {

    }

    @Override
    public void rotateAntiClockwise() {

    }
}
