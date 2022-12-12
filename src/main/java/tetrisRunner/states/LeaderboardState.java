package tetrisRunner.states;

import tetrisRunner.controller.Controller;
import tetrisRunner.controller.menu.LeaderboardController;
import tetrisRunner.model.menu.Leaderboard;
import tetrisRunner.viewer.Viewer;
import tetrisRunner.viewer.menu.LeaderboardViewer;

public class LeaderboardState extends State<Leaderboard> {

    public LeaderboardState(Leaderboard model) {
        super(model);
    }

    @Override
    protected Viewer<Leaderboard> getViewer() {
        return new LeaderboardViewer(getModel());
    }

    @Override
    protected Controller<Leaderboard> getController() {
        return new LeaderboardController(getModel());
    }
}
