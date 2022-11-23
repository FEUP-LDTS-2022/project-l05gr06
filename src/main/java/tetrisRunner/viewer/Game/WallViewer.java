package tetrisRunner.viewer.Game;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall>{
    public void draw(Wall wall, GUI gui){
       gui.drawWall(wall.getPosition());
    }
}
