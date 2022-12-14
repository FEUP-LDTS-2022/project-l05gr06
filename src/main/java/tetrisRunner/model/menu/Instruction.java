package tetrisRunner.model.menu;

import java.util.Arrays;

public class Instruction extends Menu{
   private int menu;

    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public Instruction() {
        super.entries = Arrays.asList("Jacob","Shape","Game Modes","Return");
        this.menu = 0;

    }
    public void changeInstruction(){
        if(menu == 0){
            super.entries = Arrays.asList("Jacob","Shape","Game Modes","Return");
        }
        if (menu != 0 && menu != 3){
            super.entries=  Arrays.asList("Return");
        }

        if (menu == 3){
            super.entries = Arrays.asList("Classic","Climbing","PvP","Return");
        }

        resetCurrentEntry();

    }
    public boolean isSelectedShape(){
        return isSelected(1);
    }
    public boolean isSelectedPvP(){
        if(menu == 3)
            return isSelected(2);
        return false;
    }
    public boolean isSelectedClimbing(){
        if(menu == 3)
            return isSelected(1);
        return false;
    }
    public boolean isSelectedClassic(){
        if(menu == 3)
            return isSelected(0);
        return false;
    }
    public boolean isSelectedJacob(){
        return isSelected(0);
    }
    public boolean isSelectedGameModes(){ return isSelected(2);}
    public boolean isSelectedReturn() {
        if(menu == 0 || menu == 3) return isSelected(3);
        else return isSelected(0);
    }
}
