package tetrisRunner.controller.game;

import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Coin;
import tetrisRunner.model.game.elements.CoinFactory;
import tetrisRunner.model.game.elements.ElementFactory;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.model.menu.HighScore;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.states.GameOverState;
import tetrisRunner.states.HighScoreState;
import tetrisRunner.states.PauseState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LayoutController extends GameController{
    private final JacobController jacobController;
    private final ShapeController shapeController;
    public LayoutController(Layout model) {
        super(model);
        jacobController = new JacobController(model);
        shapeController = new ShapeController(model);
    }

    public void clearLine(int y){
        List<Block> blocksToGo = new ArrayList<>();
        for (Block block : getModel().getBlocks()){
            if(block.getPosition().getY() == y) {
                blocksToGo.add(block);
            }
            else if (block.getPosition().getY() < y) block.setPosition(block.getPosition().fall());
        }
        getModel().removeBlocks(blocksToGo);
        jacobController.fallJacob();
        if(getModel().isClassic()) shapeController.goFaster();

    }

    public JacobController getJacobController() {
        return jacobController;
    }

    public int transform(){
        int count = 0;
        for (int yi = 1; yi< getModel().getHeight()-2;yi++)
        if(getModel().isLineComplete(yi)){
            clearLine(yi);
            count++;
        }
        return count;
    }
    public List<Coin> manageCoins(){
        List<Coin> coins = new ArrayList<>();
        ElementFactory<Coin> factory = new CoinFactory();
        for (Coin coin: getModel().getCoins()){
            if ((getModel().getJacob().getPosition().getX() == coin.getPosition().getX())
            && (getModel().getJacob().getPosition().getY() == coin.getPosition().getY())){
                getModel().incrementScore(125);
            }
            else if(!coinUnderBlock(coin)) coins.add(coin);
        }
        for (int i=0; i<3-coins.size();i++){
            coins.add(factory.createElement());
        }
        return coins;
    }
    public boolean coinUnderBlock(Coin coin){
        for (Block block: getModel().getBlocks()){
            if (block.getPosition().getX() == coin.getPosition().getX()
            && block.getPosition().getY() ==coin.getPosition().getY()) return true;
        }
        return false;
    }
    public void updateScore(int linesCompleted){

        switch(linesCompleted){
            case 0:
                break;
            case 1:
                getModel().incrementScore(100);
                break;
            case 2:
                getModel().incrementScore(300);
                break;
            case 3:
                getModel().incrementScore(500);
                break;
            case 4:
                getModel().incrementScore(800);
                break;

        }

    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        getModel().setJacobPoints(game.getMatchScore().getJacobPoints());
        getModel().setShaperPoints(game.getMatchScore().getShapesPoints());

        if (action == GUI.ACTION.ESCAPE) {
            game.setState(new PauseState(new Pause(game.getState())));
        }
        else if (getModel().gameOverWin(this)){
            if(getModel().checkLeaderboardUpdate())
                game.setState(new HighScoreState(new HighScore(getModel().isClassic(), getModel().getScoreNumber())));
            else if (!getModel().isPvP()) game.setState(new GameOverState(new GameOver(GUI.NAME_STATES.GAME_OVER)));
            else {game.getMatchScore().jacobWon(); game.setState(new GameOverState(new GameOver(GUI.NAME_STATES.JACOB_WON)));}
        }
        else if (!getModel().isPvP() && getModel().gameOverStatus(this))
            game.setState(new GameOverState(new GameOver(GUI.NAME_STATES.GAME_OVER)));
        else if (getModel().gameOverStatus(this)){
            game.getMatchScore().shapesWon();game.setState(new GameOverState(new GameOver(GUI.NAME_STATES.SHAPES_WON)));}


        int linesCompleted = transform();
        if(getModel().isClassic()){
            updateScore(linesCompleted);
            getModel().setCoins(manageCoins());
        }
        else getModel().incrementScore(1.0/game.getFPS());


        jacobController.step(game, action, time);
        shapeController.step(game, action, time);
    }

}
