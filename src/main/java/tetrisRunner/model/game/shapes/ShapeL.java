package tetrisRunner.model.game.shapes;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.util.List;

public class ShapeL extends Shape{



    public ShapeL(List<Position> pos) {
        super(pos,GUI.COLOR.ORANGE);

    }
    @Override
    public void rotateClockwise() {

    }

    @Override
    public void rotateAntiClockwise() {

    }
}
