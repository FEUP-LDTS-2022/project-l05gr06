package tetrisRunner.model.game.shapes;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.util.ArrayList;
import java.util.List;

public class ShapeI extends Shape{


    public ShapeI(List<Position> pos) {
        super(pos, GUI.COLOR.PINK);

    }
    @Override
    public List<Position> rotate(List<Position> positions1) {
        List<Position> positions = new ArrayList<>();
        int x = positions1.get(1).getX(); int y = positions1.get(1).getY();

        switch (getDirection()) {
            case 0 -> {
                positions.add(new Position(x - 1, y));
                positions.add(new Position(x, y));
                positions.add(new Position(x + 1, y));
                positions.add(new Position(x + 2, y));
            }
            case 1 -> {
                positions.add(new Position(x, y - 1));
                positions.add(new Position(x, y));
                positions.add(new Position(x, y + 1));
                positions.add(new Position(x, y + 2));
            }
            case 2 -> {
                positions.add(new Position(x + 1, y));
                positions.add(new Position(x, y));
                positions.add(new Position(x - 1, y));
                positions.add(new Position(x - 2, y));
            }
            case 3 -> {
                positions.add(new Position(x, y + 1));
                positions.add(new Position(x, y));
                positions.add(new Position(x, y - 1));
                positions.add(new Position(x, y - 2));
            }
        }
        return positions;
    }


}
