package tetrisRunner.model.game.layout;

import tetrisRunner.model.game.elements.Jacob;

public abstract class LayoutBuilder {

    public Layout createLayout(){
        Layout layout = new Layout(getWidth(),getHeight());
        layout.setJacob(createJacob());
        return layout;
    }
    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract Jacob createJacob();

}
