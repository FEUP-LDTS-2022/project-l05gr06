package tetrisRunner.gui;

import com.googlecode.lanterna.TextColor;
import tetrisRunner.model.Position;

import java.io.IOException;

public interface GUI {


    ACTION getNextAction() throws IOException;
    void drawText(Position position, String text, String color);

    void paintBackground(TextColor color, int width, int height);
    void drawJacob(Position position);
    void drawWall(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
    void drawBlock(Position position);

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, ESCAPE}

}
