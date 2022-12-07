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

        return terminalFactory.createTerminal();
    }
    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/crs.otf");
        assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'a' || keyStroke.getCharacter() == 'A' )) return ACTION.SHAPE_LEFT;
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'd' || keyStroke.getCharacter() == 'D' )) return ACTION.SHAPE_RIGHT;
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'w' || keyStroke.getCharacter() == 'W' )) return ACTION.SHAPE_ROTATE_CLOCK_WISE;
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 's' || keyStroke.getCharacter() == 'S' )) return ACTION.SHAPE_ROTATE_ANTI_CLOCK_WISE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.JACOB_RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.JACOB_LEFT;
        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.ESCAPE;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }
    @Override
    public String getStringColor(COLOR color){
        switch (color){
            case RED -> {
                return "#D22B2B";
            }
            case BLUE -> {
                return "#0096FF";
            }
            case CYAN -> {
                return "#40E0D0";
            }
            case BLACK -> {
                return "#000000";
            }
            case PINK -> {
                return "#FF69B4";
            }
            case BRICK -> {
                return "#BC4A3C";
            }
            case GREEN -> {
                return "#50C878";
            }
            case WHITE -> {
                return "#FFFFFF";
            }
            case ORANGE -> {
                return "#FFAC1C";
            }
            case PURPLE -> {
                return "#BF40BF";
            }
            case YELLOW -> {
                return "#FFEA00";
            }
        }

        return "";
    }
    @Override
    public String getMenuName(NAME_STATES state){
        switch (state){
            case INSTRUCTION ->{
                return "Instruction";
            }
            case PAUSE -> {
                return "Game Paused";
            }
            case SETTINGS -> {
                return "Settings";
            }
            case START_MENU -> {
                return "Menu";
            }
            case SELECT_MODE -> {
                return "Select Mode";
            }
            case GAME_OVER -> {
                return "GameOver";
            }
            default -> {
                return "";
            }
        }
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
            drawCharacter(pos.getX(), pos.getY(), DIAMOND, COLOR.WHITE, color);


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
