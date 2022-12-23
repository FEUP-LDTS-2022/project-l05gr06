package tetrisRunner.model.menu;

import java.util.Arrays;

public class Instruction extends Menu{
   private int menu;

    public int getMenu() {
        return this.menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public Instruction() {
        this.menu = 0;
        super.entries = Arrays.asList("Jacob","Shape","Game Modes","Return");
    }
    public void changeInstruction(){
        if(menu == 0){
            super.entries = Arrays.asList("Jacob","Shape","Game Modes","Return");
        }
        if (menu != 0 && menu != 3){
            super.entries = Arrays.asList("Return");
        }

        if (menu == 3){
            super.entries = Arrays.asList("Classic","Climbing","PvP","Return");
        }
        resetCurrentEntry();
    }
    public boolean isSelectedJacob(){
        if(menu==0)
            return isSelected(0);
        return false;
    }
    public boolean isSelectedShape(){
        if(menu==0)
            return isSelected(1);
        return false;
    }
    public boolean isSelectedGameModes(){
        if(menu==0)
            return isSelected(2);
        return false;
    }
    public boolean isSelectedClassic(){
        if(menu == 3)
            return isSelected(0);
        return false;
    }
    public boolean isSelectedClimbing(){
        if(menu == 3)
            return isSelected(1);
        return false;
    }
    public boolean isSelectedPvP(){
        if(menu == 3)
            return isSelected(2);
        return false;
    }
    public boolean isSelectedReturn() {
        if(menu == 0 || menu == 3) return isSelected(3);
        else return isSelected(0);
    }
}
