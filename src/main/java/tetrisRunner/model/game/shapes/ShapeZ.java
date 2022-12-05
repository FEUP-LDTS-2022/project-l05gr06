package tetrisRunner.model.game.shapes;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.util.ArrayList;
import java.util.List;

public class ShapeZ extends Shape{
    public ShapeZ(List<Position> pos) {
        super(pos,GUI.COLOR.RED);
    }

    @Override
    public List<Position> rotate(){
        List<Position> positions = new ArrayList<>();
        return positions;
    }


}
