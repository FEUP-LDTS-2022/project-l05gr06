package tetrisRunner.gui;


import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import tetrisRunner.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import static com.googlecode.lanterna.Symbols.*;

import static com.googlecode.lanterna.Symbols.FACE_BLACK;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary(); // resize screen if necessary
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);

        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }
    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/crs.otf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.ESCAPE;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    public String getStringColor(COLOR color){
        if (color == COLOR.BLACK) return "#000000";
        if(color == COLOR.RED) return "#D22B2B";
        if(color == COLOR.YELLOW) return "#FFEA00";
        if(color == COLOR.BLUE) return "#0096FF";
        if(color == COLOR.PURPLE) return "#BF40BF";
        if(color == COLOR.ORANGE) return "#FFAC1C";
        if(color == COLOR.GREEN) return "#50C878";
        if(color == COLOR.PINK) return "#FF69B4";
        if(color == COLOR.CYAN) return "#40E0D0";
        if(color == COLOR.BRICK) return "#BC4A3C";
        if(color == COLOR.WHITE) return "#FFFFFF";
        return "";
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void paintBackground(COLOR color, int width, int height){
        TextGraphics tg = screen.newTextGraphics();
        TextColor c = TextColor.Factory.fromString(getStringColor(color));
        tg.setBackgroundColor(c);
        tg.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    }
    @Override
    public void drawJacob(Position position){
        drawCharacter(position.getX(), position.getY(), FACE_BLACK, COLOR.WHITE,COLOR.CYAN);
    }
    @Override
    public void drawShape(List<Position> positions, COLOR color){
        for (Position pos:positions)
            drawCharacter(pos.getX(), pos.getY(), DIAMOND, color, COLOR.CYAN);


    }
    @Override
    public void drawWall(Position position){
        drawCharacter(position.getX(), position.getY(), ' ', COLOR.WHITE,COLOR.BRICK);
    }
    void drawCharacter(int x, int y, char c, COLOR color,COLOR background) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(getStringColor(color)));
        //Paint Background Character
        tg.setBackgroundColor(TextColor.Factory.fromString(getStringColor(background)));
        tg.putString(x, y + 1, "" + c);
    }
    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }


}
