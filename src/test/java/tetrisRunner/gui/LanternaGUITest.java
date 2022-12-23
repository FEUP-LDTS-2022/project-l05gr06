package tetrisRunner.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.shapes.ShapeI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.googlecode.lanterna.Symbols.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternaGUITest {
    private LanternaGUI gui;
    private Screen screen;
    private TextGraphics tg;

    @BeforeEach
    public void helper() throws IOException, URISyntaxException, FontFormatException {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new LanternaGUI(screen);

    }

    @Test
    public void drawTextTest() {
        gui.drawText(new Position(1,1),"Testing Text","#F0F0F0", "#FFFFFF");
        Mockito.verify(tg,Mockito.times(1)).putString(1,1,"Testing Text");
    }

    @Test
    void drawJacob() {
        gui.drawJacob(new Position(10, 17));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(64,224,208));
        Mockito.verify(tg, Mockito.times(1)).putString(10, 18, "" + FACE_BLACK);
    }

    @Test
    void drawWall(){
        gui.drawWall(new Position(0,0));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(188,74,60));
        Mockito.verify(tg, Mockito.times(1)).putString(0, 1, " ");

    }

    @Test
    void drawBlock(){
        gui.drawBlock(new Position(10,17), GUI.COLOR.PINK);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(255,105,180));
        Mockito.verify(tg, Mockito.times(1)).putString(10, 18, "" + DIAMOND);

    }


    @Test
    void drawCoin(){
        gui.drawCoin(new Position(10,10));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 234, 0));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(64,224,208));
        Mockito.verify(tg, Mockito.times(1)).putString(10, 11, "" + WHITE_CIRCLE);
    }

    @Test
    void drawShape(){
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(10,5));
        positions.add(new Position(11,5));
        positions.add(new Position(12,5));
        positions.add(new Position(13,5));

        ShapeI shape = new ShapeI(positions);
        gui.drawShape(positions,shape.getColor());

        Mockito.verify(tg, Mockito.times(4)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(4)).setBackgroundColor(new TextColor.RGB(255,105,180));
        Mockito.verify(tg, Mockito.times(1)).putString(10, 6, "" + DIAMOND);
        Mockito.verify(tg, Mockito.times(1)).putString(11, 6, "" + DIAMOND);
        Mockito.verify(tg, Mockito.times(1)).putString(12, 6, "" + DIAMOND);
        Mockito.verify(tg, Mockito.times(1)).putString(13, 6, "" + DIAMOND);
    }

    @Test
    void clearTest(){
        gui.clear();
        Mockito.verify(screen, Mockito.times(1)).clear();
    }

    @Test
    void refreshTest() throws IOException{
        gui.refresh();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void closeTest() throws IOException{
        gui.close();
        Mockito.verify(screen, Mockito.times(1)).close();
    }

    @Test
    void getNextActionTest() throws IOException {
        List<String> letters = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m",
                "n","o","p","q","r","s","t","u","v","w","x","y","z",
                "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U",
                "V","W","X","Y","Z");
        List<GUI.ACTION> letterActions = Arrays.asList(GUI.ACTION.A, GUI.ACTION.B, GUI.ACTION.C, GUI.ACTION.D,
                GUI.ACTION.E, GUI.ACTION.F, GUI.ACTION.G, GUI.ACTION.H, GUI.ACTION.I, GUI.ACTION.J,
                GUI.ACTION.K, GUI.ACTION.L, GUI.ACTION.M, GUI.ACTION.N, GUI.ACTION.O, GUI.ACTION.P,
                GUI.ACTION.Q, GUI.ACTION.R, GUI.ACTION.S, GUI.ACTION.T, GUI.ACTION.U, GUI.ACTION.V,
                GUI.ACTION.W, GUI.ACTION.X, GUI.ACTION.Y, GUI.ACTION.Z);
        for (int i=0; i<26*2;i++){
            Mockito.when(screen.pollInput()).thenReturn(KeyStroke.fromString(letters.get(i)));
            Assertions.assertEquals(gui.getNextAction(), letterActions.get(i%26));
        }

        Mockito.when(screen.pollInput()).thenReturn(KeyStroke.fromString(" "));
        Assertions.assertEquals(gui.getNextAction(), GUI.ACTION.SPACE);

        List<KeyType> keyTypes = Arrays.asList(KeyType.Backspace, KeyType.EOF, KeyType.ArrowUp, KeyType.ArrowRight,
                KeyType.ArrowDown, KeyType.ArrowLeft, KeyType.Escape, KeyType.Enter);
        List<GUI.ACTION> keyTypeActions = Arrays.asList(GUI.ACTION.BACKSPACE, GUI.ACTION.QUIT, GUI.ACTION.ARROW_UP,
                GUI.ACTION.ARROW_RIGHT, GUI.ACTION.ARROW_DOWN, GUI.ACTION.ARROW_LEFT, GUI.ACTION.ESCAPE, GUI.ACTION.SELECT);
        for (int i=0; i<8; i++){
            Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(keyTypes.get(i)));
            Assertions.assertEquals(gui.getNextAction(), keyTypeActions.get(i));
        }
    }

    @Test
    void getColorTest(){
        List<GUI.COLOR> colors = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        colors.add(GUI.COLOR.RED); strings.add("#D22B2B");
        colors.add(GUI.COLOR.BLUE); strings.add("#0096FF");
        colors.add(GUI.COLOR.CYAN); strings.add("#40E0D0");
        colors.add(GUI.COLOR.BLACK); strings.add("#000000");
        colors.add(GUI.COLOR.PINK); strings.add("#FF69B4");
        colors.add(GUI.COLOR.BRICK); strings.add("#BC4A3C");
        colors.add(GUI.COLOR.GREEN); strings.add("#50C878");
        colors.add(GUI.COLOR.WHITE); strings.add("#FFFFFF");
        colors.add(GUI.COLOR.ORANGE); strings.add("#FFAC1C");
        colors.add(GUI.COLOR.PURPLE); strings.add("#BF40BF");
        colors.add(GUI.COLOR.YELLOW); strings.add("#FFEA00");

        for(int i=0;i<11;i++)
            assertEquals(gui.getStringColor(colors.get(i)),strings.get(i));
    }

    @Test
    void getMenuNameTest(){
        List<GUI.NAME_STATES> menus = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        menus.add(GUI.NAME_STATES.INSTRUCTION); strings.add("Instructions");
        menus.add(GUI.NAME_STATES.PAUSE); strings.add("Game Paused");
        menus.add(GUI.NAME_STATES.SETTINGS); strings.add("Settings");
        menus.add(GUI.NAME_STATES.START_MENU); strings.add("Menu");
        menus.add(GUI.NAME_STATES.SELECT_MODE); strings.add("Select Mode");
        menus.add(GUI.NAME_STATES.GAME_OVER); strings.add("GameOver");
        menus.add(GUI.NAME_STATES.SHAPES_WON); strings.add("Shapes WON!");
        menus.add(GUI.NAME_STATES.JACOB_WON); strings.add("Jacob WON!");
        menus.add(GUI.NAME_STATES.LEADERBOARD); strings.add("Leaderboard");
        menus.add(GUI.NAME_STATES.HIGH_SCORE); strings.add("HighScore!");


        for(int i=0;i<10;i++)
            assertEquals(gui.getMenuName(menus.get(i)),strings.get(i));
    }

}
