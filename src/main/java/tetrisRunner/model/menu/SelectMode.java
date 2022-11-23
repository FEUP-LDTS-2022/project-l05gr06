package tetrisRunner.model.menu;

import java.util.Arrays;

public class SelectMode extends Menu{
    public SelectMode() {
        super.entries = Arrays.asList("Classic", "Co-op", "1v1", "Return");
    }

    public boolean isSelectedClassic() {
        return isSelected(0);
    }

    public boolean isSelectedCoOp() {
        return isSelected(1);
    }

    public boolean isSelected1v1() {
        return isSelected(2);
    }

    public boolean isSelectedReturn() {
        return isSelected(3);
    }
}

