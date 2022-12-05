package tetrisRunner.model.game.shapes;

import tetrisRunner.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomShapeFactory extends ShapeFactory{
    private int generateRandomInt(){
        Random rand = new Random();
        int numShapes = 7;
        return rand.nextInt(numShapes);
    }
    @Override
    public Shape createShape() {
        List<Position> positions = new ArrayList<>();
        int randomInt = generateRandomInt();
        switch (randomInt) {
            case 0 -> {
                positions.add(new Position(8, 0));
                positions.add(new Position(9, 0));
                positions.add(new Position(10, 0));
                positions.add(new Position(11, 0));
                return new ShapeI(new ArrayList<>(positions));
            }
            case 1 -> {
                positions.add(new Position(9, 0));
                positions.add(new Position(10, 0));
                positions.add(new Position(11, 0));
                positions.add(new Position(9, -1));
                return new ShapeJ(new ArrayList<>(positions));
            }
            case 2 -> {
                positions.add(new Position(9, 0));
                positions.add(new Position(10, 0));
                positions.add(new Position(11, 0));
                positions.add(new Position(11, -1));
                return new ShapeL(new ArrayList<>(positions));
            }
            case 3 -> {
                positions.add(new Position(9, 0));
                positions.add(new Position(10, 0));
                positions.add(new Position(9, -1));
                positions.add(new Position(10, -1));
                return new ShapeO(new ArrayList<>(positions));
            }
            case 4 -> {
                positions.add(new Position(9, 0));
                positions.add(new Position(10, 0));
                positions.add(new Position(11, -1));
                positions.add(new Position(10, -1));
                return new ShapeS(new ArrayList<>(positions));
            }
            case 5 -> {
                positions.add(new Position(9, 0));
                positions.add(new Position(10, 0));
                positions.add(new Position(11, 0));
                positions.add(new Position(10, -1));
                return new ShapeT(new ArrayList<>(positions));
            }
            case 6 -> {
                positions.add(new Position(9, -1));
                positions.add(new Position(10, 0));
                positions.add(new Position(11, 0));
                positions.add(new Position(10, -1));
                return new ShapeZ(new ArrayList<>(positions));
            }
        }
        return null;
    }
}
