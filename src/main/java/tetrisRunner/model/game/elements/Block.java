package tetrisRunner.model.game.elements;

import tetrisRunner.gui.GUI;

public class Block extends Element {
    private GUI.COLOR color;

    public GUI.COLOR getColor() {
        return color;
    }

    public Block(int x, int y, GUI.COLOR color) {
        super(x, y); this.color = color;
    }


}