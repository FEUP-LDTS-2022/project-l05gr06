package tetrisRunner.model.game.gamebehavior;

import tetrisRunner.controller.game.LayoutController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClimbingBehavior implements GameBehavior {
    private double score;
    @Override
    public boolean gameOverStatus(LayoutController layoutController) {
        return ((!layoutController.getJacobController().jacobIsAlive() &&
                !layoutController.getJacobController().isFalling())
                || layoutController.getModel().checkOver());
    }
    @Override
    public boolean gameOverWin(LayoutController layoutController){
        return layoutController.getJacobController().hasReachedTop();
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
    public String getScoreString() {
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
    public double getScoreNumber() {
        return this.score;
    }

    @Override
    public boolean checkLeaderboardUpdate() {
        try(BufferedReader br = new BufferedReader(new FileReader("docs/leaderboard/climbingLeaderboard.txt"))) {
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split("-");
                String leaderText = parts[1];
                leaderText = leaderText.trim();
                String[] times = leaderText.split(":");
                int minutes = Integer.parseInt(times[0]);
                int seconds = Integer.parseInt(times[1]);
                if (score<=minutes*60+seconds) return true;
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }




}
