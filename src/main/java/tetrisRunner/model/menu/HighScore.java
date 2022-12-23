package tetrisRunner.model.menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HighScore extends Menu{
    String name;
    double score;
    boolean isClassic;
    public HighScore(boolean isClassic, double score) {
        super.entries = Arrays.asList("Name:", "Next");
        this.isClassic = isClassic;
        this.score = score;
        name = "";
    }
    public boolean isSelectedName() {
        return isSelected(0);
    }
    public boolean isSelectedNext() {
        return isSelected(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean isClassic(){
        return this.isClassic;
    }
    public void updateLeaderboardClassic(String file) throws IOException {
        int counter = 0;
        boolean changed = false;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        List<String> newLeaderboard = new ArrayList<>();
        while (line != null) {
            String[] parts = line.split("-");
            String leaderText = parts[1];
            leaderText = leaderText.trim();
            int leaderScore = Integer.parseInt(leaderText);
            if (score >= leaderScore && !changed) {
                newLeaderboard.add(this.name + " - " + (int) this.score);
                counter++;
                changed = true;
            }
            if (counter<8)
                newLeaderboard.add(line);
            counter++;
            line = br.readLine();
        }
        br.close();
        if (!changed) newLeaderboard.add(this.name + " - " + (int) this.score);
        PrintWriter writer = new PrintWriter(file);
        for (String leader: newLeaderboard){
            writer.println(leader);
        }
        writer.close();
    }
    public void updateLeaderboardClimbing(String file) throws IOException {
        int counter = 0;
        boolean changed = false;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        List<String> newLeaderboard = new ArrayList<>();
        while (line != null) {
            String[] parts = line.split("-");
            String leaderText = parts[1];
            leaderText = leaderText.trim();
            String[] times = leaderText.split(":");
            int minutes = Integer.parseInt(times[0]);
            int seconds = Integer.parseInt(times[1]);
            if (score<=minutes*60+seconds && !changed) {
                newLeaderboard.add(this.name + " - " + (int) this.score/60 + ":" + (int) this.score%60);
                counter++;
                changed = true;
            }
            if (counter<8)
                newLeaderboard.add(line);
            counter++;
            line = br.readLine();
        }
        br.close();
        if (!changed) newLeaderboard.add(this.name + " - " + (int) this.score/60 + ":" + (int) this.score%60);
        PrintWriter writer = new PrintWriter(file);
        for (String leader: newLeaderboard){
            writer.println(leader);
        }
        writer.close();
    }
}
