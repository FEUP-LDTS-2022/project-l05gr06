package tetrisRunner.model;

import org.junit.jupiter.api.BeforeEach;

public class PositionTest {
    private Position position1;
    private Position position2;
    private Position position3;
    private Position position4;
    @BeforeEach
    public void helper(){
        int x1 = 4,x2 = 3,x3 = -11,x4 = -74; int y1 = -12,y2 = 3,y3 = -12, y4 = 32;
        position1 = new Position(x1,y1);
        position2 = new Position(x2,y2);
        position3 = new Position(x3,y3);
        position4 = new Position(x4,y4);
    }
}
