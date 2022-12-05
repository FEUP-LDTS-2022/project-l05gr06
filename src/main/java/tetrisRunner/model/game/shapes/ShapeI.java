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
    public void rotate() {
        List<Position> positions1 = getShapePos();
        List<Position> positions = new ArrayList<>();
        int x = positions1.get(0).getX(); int y = positions1.get(0).getY();

        switch (getDirection()) {
            case 0:
                positions.add(new Position(x,y));
                positions.add(new Position(x+1,y));
                positions.add(new Position(x+2,y));
                positions.add(new Position(x+3,y));
                setShapePos(positions);
                break;

            case 1:
                positions.add(new Position(x,y));
                positions.add(new Position(x,y+1));
                positions.add(new Position(x,y+2));
                positions.add(new Position(x,y+3));
                setShapePos(positions);
                break;
            case 2:
                positions.add(new Position(x,y));
                positions.add(new Position(x-1,y));
                positions.add(new Position(x-2,y));
                positions.add(new Position(x-3,y));
                setShapePos(positions);
                break;
            case 3:
                positions.add(new Position(x,y));
                positions.add(new Position(x,y-1));
                positions.add(new Position(x,y-2));
                positions.add(new Position(x,y-3));
                setShapePos(positions);
                break;
        }
    }


}
