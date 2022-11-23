package tetrisRunner.viewer.Game;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.elements.Jacob;

public class JacobViewer implements ElementViewer<Jacob>{
    public void draw(Jacob jacob, GUI gui){
        gui.drawJacob(jacob.getPosition());
    }
}
