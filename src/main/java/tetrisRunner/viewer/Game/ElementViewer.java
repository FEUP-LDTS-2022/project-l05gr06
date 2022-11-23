package tetrisRunner.viewer.Game;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.elements.Element;

public interface ElementViewer<T extends Element>{
    void draw(T element, GUI gui);
}
