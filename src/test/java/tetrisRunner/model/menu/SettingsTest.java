package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SettingsTest {
    Settings menu;

    @BeforeEach
    public void helper(){
        menu = new Settings();
    }

    @Test
    public void isSelectedMuteTest() {
        Assertions.assertTrue(menu.isSelectedMute());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedMute());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedMute());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedMute());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedMute());
    }

    @Test
    public void isSelectedUpTest() {
        Assertions.assertFalse(menu.isSelectedUp());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedUp());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedUp());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedUp());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedUp());
    }

    @Test
    public void isSelectedDownTest() {
        Assertions.assertFalse(menu.isSelectedDown());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedDown());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedDown());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedDown());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedDown());
    }

    @Test
    public void isSelectedReturnTest() {
        Assertions.assertFalse(menu.isSelectedReturn());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedReturn());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedReturn());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedReturn());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedReturn());
    }
}
