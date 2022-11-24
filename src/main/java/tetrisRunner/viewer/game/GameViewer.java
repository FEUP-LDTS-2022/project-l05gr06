package tetrisRunner.viewer.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.elements.Element;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.viewer.Viewer;
import tetrisRunner.viewer.game.element.ElementViewer;
import tetrisRunner.viewer.game.element.JacobViewer;

import java.util.List;

public class GameViewer extends Viewer<Layout> {

    public GameViewer(Layout model) {
        super(model);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.paintBackground(TextColor.Factory.fromString("#95C8D8"), getModel().getWidth(), getModel().getHeight());
        drawElement(gui,getModel().getJacob(), new JacobViewer());
    }
    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }
    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
