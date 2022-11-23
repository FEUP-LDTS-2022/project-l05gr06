package tetrisRunner.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.model.Position;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class LanernaGUITest {
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
        gui.drawText(new Position(1,1),"Testing Text","#F0F0F0");
        Mockito.verify(tg,Mockito.times(1)).putString(1,1,"Testing Text");
    }

}
