package tetrisRunner.model.game.gamebehavior;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.controller.game.LayoutController;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.layout.LoaderLayoutBuilder;

import java.io.File;
import java.io.IOException;

public class ClassicBehaviorTest {
    private ClassicBehavior classicBehavior;
    private Layout layout;
    private LayoutController layoutController;
    private File file;

    @BeforeEach
    public void helper() throws IOException {
        classicBehavior = new ClassicBehavior();
        file = File.createTempFile("testClassic",".txt");
        String path = file.getAbsolutePath();
        classicBehavior.setFile(path);
        layout = new Layout(20,20);
        layoutController = new LayoutController(layout);
    }

    @Test
    public void gameOverStatusTest(){

    }
}
