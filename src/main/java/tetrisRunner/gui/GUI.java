package tetrisRunner.gui;

import tetrisRunner.model.Position;

import java.io.IOException;

public interface GUI {


    ACTION getNextAction() throws IOException;
    void drawText(Position position, String text, String color);
    void drawJacob(Position position);


    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}

}
