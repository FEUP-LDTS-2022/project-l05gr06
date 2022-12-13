package tetrisRunner.model.game.gamebehavior;

import tetrisRunner.controller.game.LayoutController;

public class PvPBehavior implements GameBehavior {
    private double score;
    private double gameOverTime = 60;

    @Override
    public boolean gameOverStatus(LayoutController layoutController) {
        return ((!layoutController.getJacobController().jacobIsAlive() &&
                !layoutController.getJacobController().isFalling())
                || layoutController.getModel().checkOver());
    }
    @Override
    public boolean gameOverWin(LayoutController layoutController){
        return score>gameOverTime;
    }
    @Override
    public boolean isClassic() {
        return false;
    }

    @Override
    public void incrementScore(double num) {
        this.score = this.score + num;
    }

    @Override
    public boolean instaDropAvailable() {
        return false;
    }
    
    @Override
    public String getScoreString() {
        StringBuilder stringBuilder = new StringBuilder();
        int minutes = (int) (gameOverTime-score)/60;
        int seconds = (int) (gameOverTime-score)%60;

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
    public boolean checkLeaderboardUpdate() {
        return false;
    }

    @Override
    public double getScoreNumber() {
        return this.score;
    }
}
