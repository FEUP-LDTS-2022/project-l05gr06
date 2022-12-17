package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HighScoreTest {
    private HighScore highScore;
    @BeforeEach
    public void helper(){
        highScore = new HighScore(true,1000);
    }
    @Test
    public void isSelectedNameTest() {
        Assertions.assertTrue(highScore.isSelectedName());
        highScore.nextEntry();
        Assertions.assertFalse(highScore.isSelectedName());
    }
    @Test
    public void isSelectedNextTest() {
        Assertions.assertFalse(highScore.isSelectedNext());
        highScore.nextEntry();
        Assertions.assertTrue(highScore.isSelectedNext());
    }
}
