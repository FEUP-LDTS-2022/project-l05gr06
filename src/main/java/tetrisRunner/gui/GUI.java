package tetrisRunner.gui;

import com.googlecode.lanterna.TextColor;
import tetrisRunner.model.Position;

import java.io.IOException;
import java.util.List;

public interface GUI {


    ACTION getNextAction() throws IOException;
    void drawText(Position position, String text, String color);
    String getStringColor(COLOR color);
    void paintBackground(COLOR color, int width, int height);
    void drawJacob(Position position);
    void drawWall(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
    void drawShape(List<Position> positions, COLOR color);

    enum ACTION {UP, JACOB_RIGHT, DOWN, JACOB_LEFT, NONE, QUIT, SELECT, ESCAPE, SHAPE_LEFT, SHAPE_RIGHT, SHAPE_ROTATE_CLOCK_WISE,SHAPE_ROTATE_ANTI_CLOCK_WISE}
    enum COLOR {RED, YELLOW, BLUE, PURPLE, ORANGE, GREEN, PINK, CYAN, BRICK, WHITE, BLACK}
}
