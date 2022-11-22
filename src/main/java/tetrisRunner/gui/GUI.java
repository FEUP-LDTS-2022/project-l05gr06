package tetrisRunner.gui;

import tetrisRunner.model.Position;

import java.io.IOException;

public interface GUI {




    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

}
