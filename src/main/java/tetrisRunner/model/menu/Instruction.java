package tetrisRunner.model.menu;

import java.util.Arrays;

public class Instruction extends Menu{
    public Instruction() {
        super.entries = Arrays.asList("Return");
    }
    public boolean isSelectedReturn() {
        return isSelected(0);
    }
}
