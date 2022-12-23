package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InstructionTest {
    private Instruction menu;

    @BeforeEach
    public void helper(){
        menu = new Instruction();
    }

    @Test
    public void changeInstructionTest(){
        menu.changeInstruction();
        Assertions.assertEquals(Arrays.asList("Jacob","Shape","Game Modes","Return"),menu.entries);
        Assertions.assertTrue(menu.isSelected(0));
        menu.setMenu(3);
        menu.changeInstruction();
        Assertions.assertEquals(Arrays.asList("Classic","Climbing","PvP","Return"),menu.entries);
        Assertions.assertTrue(menu.isSelected(0));
        int[] otherInts = {1,2,4,5,6};
        for (int i:otherInts){
            menu.setMenu(i);
            menu.changeInstruction();
            Assertions.assertEquals(Arrays.asList("Return"),menu.entries);
        }
    }
    @Test
    public void isSelectedJacobTest(){
        Assertions.assertTrue(menu.isSelectedJacob());
        for (int i=0; i<3;i++){
            menu.nextEntry();
            Assertions.assertFalse(menu.isSelectedJacob());
        }
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedJacob());
        for (int i=1; i<7;i++){
            menu.setMenu(i);
            for (int j=0; j<4;j++) Assertions.assertFalse(menu.isSelectedJacob());
        }
    }
    @Test
    public void isSelectedShapeTest(){
        Assertions.assertFalse(menu.isSelectedShape());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedShape());
        for (int i=0; i<3;i++){
            menu.nextEntry();
            Assertions.assertFalse(menu.isSelectedShape());
        }
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedShape());
        for (int i=1; i<7;i++){
            menu.setMenu(i);
            for (int j=0; j<4;j++) Assertions.assertFalse(menu.isSelectedShape());
        }
    }
    @Test
    public void isSelectedGameModesTest(){
        Assertions.assertFalse(menu.isSelectedGameModes());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedGameModes());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedGameModes());
        for (int i=0; i<3;i++){
            menu.nextEntry();
            Assertions.assertFalse(menu.isSelectedGameModes());
        }
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedGameModes());
        for (int i=1; i<7;i++){
            menu.setMenu(i);
            for (int j=0; j<4;j++) Assertions.assertFalse(menu.isSelectedGameModes());
        }
    }
    @Test
    public void isSelectedClassicTest(){
        menu.setMenu(3);
        Assertions.assertTrue(menu.isSelectedClassic());
        for (int i=0; i<3;i++){
            menu.nextEntry();
            Assertions.assertFalse(menu.isSelectedClassic());
        }
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedClassic());
        for (int i: new int[]{0, 1, 2, 4, 5, 6}){
            menu.setMenu(i);
            for (int j=0; j<4;j++) Assertions.assertFalse(menu.isSelectedClassic());
        }
    }
    @Test
    public void isSelectedClimbingTest(){
        menu.setMenu(3);
        Assertions.assertFalse(menu.isSelectedClimbing());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedClimbing());
        for (int i=0; i<3;i++){
            menu.nextEntry();
            Assertions.assertFalse(menu.isSelectedClimbing());
        }
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedClimbing());
        for (int i: new int[]{0, 1, 2, 4, 5, 6}){
            menu.setMenu(i);
            for (int j=0; j<4;j++) Assertions.assertFalse(menu.isSelectedClimbing());
        }
    }
    @Test
    public void isSelectedPvPTest(){
        menu.setMenu(3);
        Assertions.assertFalse(menu.isSelectedPvP());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedPvP());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedPvP());
        for (int i=0; i<3;i++){
            menu.nextEntry();
            Assertions.assertFalse(menu.isSelectedPvP());
        }
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedPvP());
        for (int i: new int[]{0, 1, 2, 4, 5, 6}){
            menu.setMenu(i);
            for (int j=0; j<4;j++) Assertions.assertFalse(menu.isSelectedPvP());
        }
    }
    @Test
    public void isSelectedReturnTest() {
        for (int i: new int[]{1, 2, 4, 5, 6}){
            menu.setMenu(i);
            for (int j=0; j<4;j++) Assertions.assertTrue(menu.isSelectedReturn());
        }
        for (int i: new int[]{0,3}){
            menu.setMenu(i);
            for (int j=0; j<3; j++){
                Assertions.assertFalse(menu.isSelectedReturn());
                menu.nextEntry();
            }
            Assertions.assertTrue(menu.isSelectedReturn());
            menu.nextEntry();
        }
    }
}
