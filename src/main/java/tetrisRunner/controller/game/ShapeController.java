package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.shapes.Shape;

import java.io.IOException;
import java.util.List;

public class ShapeController extends GameController{
    private long lastMovementBlock;
    static final long fallTimeBlock = 700;
    final int ground;

    public ShapeController(Layout model) {
        super(model);
        this.lastMovementBlock = 0;
        this.ground  = getModel().getHeight()-2;
    }

    //TODO ALTERAR IF PARA PARAR CASO BATA EM ALGUMA COISA
    public void fallShape(){
        List<Shape> shapes = getModel().getShapes();
        for(Shape shape:shapes){
            for (Position pos: shape.getShapePos())
                if(getModel().isEmpty(pos))
                    pos.fall();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time-lastMovementBlock>fallTimeBlock) {
            fallShape();
            lastMovementBlock = time;
        }
    }
}
