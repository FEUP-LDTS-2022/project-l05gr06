package tetrisRunner.model.game.elements;

public abstract class ElementFactory<T extends Element> {
    public abstract T createElement();
}
