package tetrisRunner.model.game.shapes;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.util.ArrayList;
import java.util.List;

public class ShapeJ extends Shape{


    public ShapeJ(List<Position> pos) {

        super(pos,GUI.COLOR.BLUE);

    }
    @Override
    public List<Position> rotate(){
        List<Position> positions = new ArrayList<>();
        return positions;
    }

}
