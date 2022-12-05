package tetrisRunner.model.game.shapes;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.util.List;

public class ShapeI extends Shape{


    public ShapeI(List<Position> pos) {
        super(pos, GUI.COLOR.PINK);

    }

    @Override
    public void rotateClockwise() {

    }

    @Override
    public void rotateAntiClockwise() {

    }
}
