package tetrisRunner.model.game.shapes;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.util.ArrayList;
import java.util.List;

public class ShapeT extends Shape{
    public ShapeT(List<Position> pos) {
        super(pos,GUI.COLOR.PURPLE);

    }
    @Override
    public List<Position> rotate(){
        List<Position> positions = new ArrayList<>();
        return positions;
    }

}
