package tetrisRunner.model.game.layout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.controller.game.JacobController;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;
import tetrisRunner.model.game.shapes.RandomShapeFactory;
import tetrisRunner.model.game.shapes.ShapeFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchScoreTest {

    private MatchScore matchScore;

    @BeforeEach
    void setUp() {
        matchScore = new MatchScore();
    }


    @Test
    void jacobWonTest() {

        matchScore.jacobWon();
        assertEquals(matchScore.getJacobPoints(),1);
        assertEquals(matchScore.getShapesPoints(),0);

        matchScore.jacobWon();
        assertEquals(matchScore.getJacobPoints(),2);
        assertEquals(matchScore.getShapesPoints(),0);

        matchScore.jacobWon();
        assertEquals(matchScore.getJacobPoints(),3);
        assertEquals(matchScore.getShapesPoints(),0);

    }

    @Test
    void shapesWonTest() {

        matchScore.shapesWon();
        assertEquals(matchScore.getJacobPoints(),0);
        assertEquals(matchScore.getShapesPoints(),1);

        matchScore.shapesWon();
        assertEquals(matchScore.getJacobPoints(),0);
        assertEquals(matchScore.getShapesPoints(),2);

        matchScore.shapesWon();
        assertEquals(matchScore.getJacobPoints(),0);
        assertEquals(matchScore.getShapesPoints(),3);


    }


}
