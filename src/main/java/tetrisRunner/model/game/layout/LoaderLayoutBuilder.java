package tetrisRunner.model.game.layout;

import tetrisRunner.model.game.elements.Jacob;

public class LoaderLayoutBuilder extends LayoutBuilder{
    private final int startPosX;
    private final int startPosY;

    public LoaderLayoutBuilder() {
        this.startPosX = getWidth()/2;
        this.startPosY = getHeight()-3;
    }

    @Override
    protected int getWidth(){
        return 20;
    }
    @Override
    protected int getHeight(){
        return 20;
    }
    @Override
    protected Jacob createJacob(){
        return new Jacob(startPosX,startPosY);
    }
}
