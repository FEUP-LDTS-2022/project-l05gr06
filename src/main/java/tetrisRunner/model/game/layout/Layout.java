package tetrisRunner.model.game.layout;

import tetrisRunner.model.game.elements.Jacob;

public class Layout {
    private final int width;
    private final int height;
    private Jacob jacob;
    public Layout(int width,int height){
        this.width = width;
        this.height = height;
    }
    public Jacob getJacob(){
        return jacob;
    }

    public void setJacob(Jacob jacob) {
        this.jacob = jacob;
    }
}
