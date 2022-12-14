package tetrisRunner.model.game.layout;

public class MatchScore {
    private int jacobPoints;
    private int shaperPoints;

    public void jacobWon() {this.jacobPoints = jacobPoints + 1;}
    public void shapesWon() {this.shaperPoints = shaperPoints + 1;}

    public int getJacobPoints() {
        return jacobPoints;
    }

    public int getShapesPoints() {
        return shaperPoints;
    }

}
