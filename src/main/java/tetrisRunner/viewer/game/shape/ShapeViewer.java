package tetrisRunner.viewer.game.shape;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.shapes.Shape;

public interface ShapeViewer<T extends Shape>{
    void draw(T shape, GUI gui);
}
