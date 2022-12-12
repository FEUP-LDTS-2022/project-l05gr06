package tetrisRunner.model.game.gamebehavior;

import tetrisRunner.controller.game.LayoutController;

public class ClassicBehavior implements GameBehavior {
    private double score;
    @Override
    public boolean gameOverStatus(LayoutController layoutController, long time) {

        return ((!layoutController.getJacobController().jacobIsAlive() &&
                !layoutController.getJacobController().isFalling())

                || layoutController.getModel().checkOver());
    }

    @Override
    public boolean scoreOrTimer() {
        return true;
    }

    @Override
    public boolean instaDropAvailable() {
        return true;
    }

    @Override
    public void incrementScore(double num) {
        this.score = this.score + num;
    }

    @Override
    public String getScore() {
        return String.valueOf((int) score);
    }

    @Override
    public void leaderboardUpdate() {

    }



}
