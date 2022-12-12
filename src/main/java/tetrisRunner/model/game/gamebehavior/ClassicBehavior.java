package tetrisRunner.model.game.gamebehavior;

import tetrisRunner.controller.game.LayoutController;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClassicBehavior implements GameBehavior {
    private double score;
    @Override
    public boolean gameOverStatus(LayoutController layoutController) {
        return ((!layoutController.getJacobController().jacobIsAlive() &&
                !layoutController.getJacobController().isFalling())
                || layoutController.getModel().checkOver());
    }
    @Override
    public boolean gameOverWin(LayoutController layoutController){
        return gameOverStatus(layoutController);
    }
    @Override
    public boolean scoreOrTimer() {
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
    public boolean checkLeaderboardUpdate() {
        try(BufferedReader br = new BufferedReader(new FileReader("docs/leaderboard/classicLeaderboard.txt"))) {
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split("-");
                String leaderText = parts[1];
                leaderText = leaderText.trim();
                int leaderScore = Integer.parseInt(leaderText);
                if (score>=leaderScore) return true;
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }



}
