package tetrisRunner.model.game.shapes;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.util.List;

public class ShapeJ extends Shape{


    public ShapeJ(List<Position> pos) {

        super(pos,GUI.COLOR.BLUE);

    }
    @Override
    public void rotateClockwise() {

    }

    @Override
    public void rotateAntiClockwise() {

    }
}
