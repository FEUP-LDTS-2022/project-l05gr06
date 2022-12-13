package tetrisRunner.viewer.game;

import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Element;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.game.shapes.Shape;
import tetrisRunner.viewer.Viewer;
import tetrisRunner.viewer.game.element.*;

import java.util.List;

public class GameViewer extends Viewer<Layout> {

    public GameViewer(Layout model) {
        super(model);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.paintBackground(GUI.COLOR.CYAN, getModel().getWidth(), getModel().getHeight());
        drawElement(gui,getModel().getJacob(), new JacobViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElements(gui, getModel().getBlocks(), new BlockViewer());

        gui.drawText(
                new Position(1, getModel().getHeight()-1),
                getModel().getScoreString(),
                gui.getStringColor(GUI.COLOR.WHITE),
                gui.getStringColor(GUI.COLOR.BRICK));

        if(getModel().isPvP())
            gui.drawText(
                    new Position(getModel().getWidth()-5, getModel().getHeight()-1),
                    getModel().getScoreMatch(),
                    gui.getStringColor(GUI.COLOR.WHITE),
                    gui.getStringColor(GUI.COLOR.BRICK));



        drawShape(gui,getModel().getShape(),new ShapeViewer());
    }
    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }
    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
    private <T extends Shape> void drawShape(GUI gui, T shape, ShapeViewer viewer) {
        viewer.draw(shape, gui);
    }
}
