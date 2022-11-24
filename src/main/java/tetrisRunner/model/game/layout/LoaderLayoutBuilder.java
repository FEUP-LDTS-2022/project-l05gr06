package tetrisRunner.model.game.layout;

import tetrisRunner.model.game.elements.Jacob;

public class LoaderLayoutBuilder extends LayoutBuilder{

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
        return new Jacob(10,16);
    }

}
