package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InstructionTest {
    private Instruction menu;

    @BeforeEach
    public void helper(){
        menu = new Instruction();
    }

    @Test
    public void isSelectedReturnTest(){
        Assertions.assertTrue(menu.isSelectedReturn());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedReturn());
    }
}