package tetrisRunner.model.game.shapes;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.util.List;

public class ShapeO extends Shape{


    public ShapeO(List<Position> pos) {
        super(pos,GUI.COLOR.YELLOW);

    }
    @Override
    public void rotate(){

    }

}
