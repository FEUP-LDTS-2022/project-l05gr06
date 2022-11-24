package tetrisRunner.model.game.elements;

import tetrisRunner.model.Position;

public abstract class Element {
    private Position position;
    Element(int x, int y){
        this.position = new Position(x,y);
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}
