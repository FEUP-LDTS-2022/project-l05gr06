package tetrisRunner.model.menu;

import java.util.Arrays;

public class Instruction extends Menu{
   private int Menu;

    public int getMenu() {
        return Menu;
    }

    public void setMenu(int menu) {
        Menu = menu;
    }

    public Instruction() {
        super.entries = Arrays.asList("Jacob","Shape","Game Modes","Return");
        this.Menu = 0;

    }
    public void changeInstruction(){
        if (Menu != 0 && Menu != 3){
            super.entries=  Arrays.asList("Return");
        }

        if (Menu == 3){
            super.entries.set(0, "Classic");
            super.entries.set(1, "Climbing");
            super.entries.set(2, "PvP");
            super.entries.set(3, "Return");
        }

        resetCurrentEntry();

    }
    public boolean isSelectedShape(){
        return isSelected(1);
    }
    public boolean isSelectedPvP(){
        if(Menu == 3)
            return isSelected(2);
        return false;
    }
    public boolean isSelectedClimbing(){
        if(Menu == 3)
            return isSelected(1);
        return false;
    }
    public boolean isSelectedClassic(){
        if(Menu == 3)
            return isSelected(0);
        return false;
    }
    public boolean isSelectedJacob(){
        return isSelected(0);
    }
    public boolean isSelectedGameModes(){ return isSelected(2);}
    public boolean isSelectedReturn() {
        if(Menu == 0 || Menu == 3) return isSelected(3);
        else return isSelected(0);
    }
}
