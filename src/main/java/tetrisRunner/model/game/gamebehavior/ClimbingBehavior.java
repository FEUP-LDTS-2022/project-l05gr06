package tetrisRunner.model.game.gamebehavior;

import tetrisRunner.controller.game.LayoutController;

public class ClimbingBehavior implements GameBehavior {
    private double score;
    @Override
    public boolean gameOverStatus(LayoutController layoutController, long time) {
        return ((!layoutController.getJacobController().jacobIsAlive() &&
                !layoutController.getJacobController().isFalling())

                || layoutController.getModel().checkOver()
                || layoutController.getJacobController().hasReachedTop());
    }

    @Override
    public boolean scoreOrTimer() {
        return false;
    }

    @Override
    public void incrementScore(double num) {
        this.score = this.score + num;
    }

    @Override
    public String getScore() {
        StringBuilder stringBuilder = new StringBuilder();
        int minutes = (int) score/60;
        int seconds = (int) score%60;

        if(minutes < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(minutes);
        stringBuilder.append(":");

        if(seconds < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(seconds);
        return stringBuilder.toString();
    }

    @Override
    public void leaderboardUpdate() {

    }




}