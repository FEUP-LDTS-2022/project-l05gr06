package tetrisRunner.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    int x1 = 4, x2 = 3, x3 = -11, x4 = -74;
    int y1 = -12, y2 = 3, y3 = -12, y4 = 32;
    private Position position1;
    private Position position2;
    private Position position3;
    private Position position4;

    @BeforeEach
    public void helper() {
        position1 = new Position(x1, y1);
        position2 = new Position(x2, y2);
        position3 = new Position(x3, y3);
        position4 = new Position(x4, y4);
    }

    @Test
    public void getRight() {
        assertEquals(x1 + 1, position1.getRight().getX());
        assertEquals(y1, position1.getY());
        assertEquals(x2 + 1, position2.getRight().getX());
        assertEquals(y2, position2.getY());
        assertEquals(x3 + 1, position3.getRight().getX());
        assertEquals(y3, position3.getY());
        assertEquals(x4 + 1, position4.getRight().getX());
        assertEquals(y4, position4.getY());
    }
    @Test
    public void getLeft(){
        assertEquals(x1 - 1, position1.getLeft().getX());
        assertEquals(y1, position1.getY());
        assertEquals(x2 - 1, position2.getLeft().getX());
        assertEquals(y2, position2.getY());
        assertEquals(x3 - 1, position3.getLeft().getX());
        assertEquals(y3, position3.getY());
        assertEquals(x4 - 1, position4.getLeft().getX());
        assertEquals(y4, position4.getY());
    }

    @Test
    public void jump(){
        assertEquals(x1, position1.getX());
        assertEquals(y1-1, position1.jump().getY());
        assertEquals(x2, position2.getX());
        assertEquals(y2-1, position2.jump().getY());
        assertEquals(x3, position3.getX());
        assertEquals(y3-1, position3.jump().getY());
        assertEquals(x4, position4.getX());
        assertEquals(y4-1, position4.jump().getY());
    }

    @Test
    public void fall(){
        assertEquals(x1, position1.getX());
        assertEquals(y1+1, position1.fall().getY());
        assertEquals(x2, position2.getX());
        assertEquals(y2+1, position2.fall().getY());
        assertEquals(x3, position3.getX());
        assertEquals(y3+1, position3.fall().getY());
        assertEquals(x4, position4.getX());
        assertEquals(y4+1, position4.fall().getY());
    }
}

