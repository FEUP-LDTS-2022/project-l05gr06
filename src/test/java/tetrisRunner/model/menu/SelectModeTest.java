package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SelectModeTest {
    SelectMode menu;

    @BeforeEach
    public void helper(){
        menu = new SelectMode();
    }

    @Test
    public void isSelectedClassicTest() {
        Assertions.assertTrue(menu.isSelectedClassic());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedClassic());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedClassic());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedClassic());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedClassic());
    }

    @Test
    public void isSelectedCoOpTest() {
        Assertions.assertFalse(menu.isSelectedCoOp());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedCoOp());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedCoOp());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedCoOp());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedCoOp());
    }

    @Test
    public void isSelected1v1Test() {
        Assertions.assertFalse(menu.isSelected1v1());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelected1v1());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelected1v1());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelected1v1());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelected1v1());
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
