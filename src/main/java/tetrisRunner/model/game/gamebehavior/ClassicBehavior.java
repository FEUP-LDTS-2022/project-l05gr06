package tetrisRunner.model.game.gamebehavior;

import tetrisRunner.controller.game.LayoutController;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClassicBehavior implements GameBehavior {
    private double score;
    private String file;

    public ClassicBehavior() {
        file = "docs/leaderboard/classicLeaderboard.txt";
        score = 0;
    }

    @Override
    public boolean gameOverStatus(LayoutController layoutController) {
        boolean jacobDied = !layoutController.getJacobController().jacobIsAlive() &&
                !layoutController.getJacobController().isFalling();
        boolean shapesOverLimit = layoutController.getModel().checkOver();
        return jacobDied || shapesOverLimit;
    }
    @Override
    public boolean gameOverWin(LayoutController layoutController){
        return gameOverStatus(layoutController);
    }
    @Override
    public boolean isClassic() {
        return true;
    }

    @Override
    public boolean isPvP() {
        return false;
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
    public String getScoreString() {
        return String.valueOf((int) score);
    }

    @Override
    public double getScoreNumber() {
        return this.score;
    }

    @Override
    public boolean checkLeaderboardUpdate() {
        int countLines = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                countLines++;
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
        if (countLines<8) return true;
        return false;
    }
    public void setFile(String file) {
        this.file = file;
    }
}
