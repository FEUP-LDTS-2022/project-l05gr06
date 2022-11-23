package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class MenuTest {
    TestMenuAbstract menuTest;

    @BeforeEach
    public void helper(){
        menuTest = new TestMenuAbstract();
    }

    @Test
    public void getEntryTest(){

        Assertions.assertEquals(menuTest.getEntry(0),"Test1");
        Assertions.assertNotEquals(menuTest.getEntry(1),"2teste");
        Assertions.assertEquals(menuTest.getEntry(1),"Test2");
        Assertions.assertEquals(menuTest.getEntry(2),"Test3");
    }

    @Test
    public void nextEntryTest(){
        Assertions.assertTrue(menuTest.isSelected(0));
        menuTest.nextEntry();
        menuTest.nextEntry();
        Assertions.assertTrue(menuTest.isSelected(2));
        menuTest.nextEntry();
        Assertions.assertFalse(menuTest.isSelected(3));
        Assertions.assertTrue(menuTest.isSelected(0));
    }

    @Test
    public void previousEntryTest(){
        Assertions.assertTrue(menuTest.isSelected(0));
        menuTest.previousEntry();
        Assertions.assertFalse(menuTest.isSelected(-1));
        Assertions.assertTrue(menuTest.isSelected(2));
        menuTest.previousEntry();
        Assertions.assertTrue(menuTest.isSelected(1));
    }

    class TestMenuAbstract extends Menu{
        TestMenuAbstract(){
            super.entries = Arrays.asList("Test1", "Test2", "Test3");
        }
    }
}
