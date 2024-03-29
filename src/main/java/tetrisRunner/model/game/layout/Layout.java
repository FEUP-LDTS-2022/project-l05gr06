package tetrisRunner.model.game.layout;

import tetrisRunner.controller.game.LayoutController;
import tetrisRunner.model.Position;
import tetrisRunner.model.game.elements.Block;
import tetrisRunner.model.game.elements.Coin;
import tetrisRunner.model.game.elements.Jacob;
import tetrisRunner.model.game.elements.Wall;
import tetrisRunner.model.game.gamebehavior.GameBehavior;
import tetrisRunner.model.game.shapes.Shape;

import java.util.List;

public class Layout {
    private final int width;
    private final int height;

    private int jacobPoints;
    private int shaperPoints;

    private GameBehavior gameBehavior;
    private Jacob jacob;

    private List<Wall> walls;
    private Shape fallingShape;
    private List<Coin> coins;
    private List<Block> blocks;
    public Layout(int width,int height){
        this.width = width;
        this.height = height;
    }
    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Coin> getCoins() {
        return coins;
    }
    public Jacob getJacob(){
        return jacob;
    }
    public void setJacob(Jacob jacob) {
        this.jacob = jacob;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public Shape getShape() {
        return fallingShape;
    }

    public void setShape(Shape fallingShape) {
        this.fallingShape = fallingShape;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
    }
    public void removeBlocks(List<Block> blocksList) {
        for(Block block : blocksList){blocks.remove(block);}
    }

    public String getScoreString() {
        return this.gameBehavior.getScoreString();
    }

    public double getScoreNumber(){
        return this.gameBehavior.getScoreNumber();
    }
    public void incrementScore(double num) {
        this.gameBehavior.incrementScore(num);
    }

    public void setJacobPoints(int jacobPoints) {
        this.jacobPoints = jacobPoints;
    }
    public void setShaperPoints(int shaperPoints) {
        this.shaperPoints = shaperPoints;
    }
    public String getScoreMatch(){
        StringBuilder stringBuilder = new StringBuilder();

        if(shaperPoints < 10) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(shaperPoints);
        stringBuilder.append("-");

        stringBuilder.append(jacobPoints);

        return stringBuilder.toString();
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        for (Block block : blocks)
            if (block.getPosition().equals(position))
                return false;
        for (Position pos : fallingShape.getShapePos())
            if(pos.equals(position))
                return false;

        if(position.getX()>=width || position.getX()<0) return false;

        return true;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public boolean isLineComplete(int y){
        boolean isBlock;
        Position position;

        for(int xi=1; xi<width-1;xi++){
            position = new Position(xi,y);

            isBlock = false;
            for (Block block : blocks){
                if (block.getPosition().equals(position))
                    isBlock = true;}

            if(!isBlock) return false;
        }
        return true;
    }

    public boolean instaDropAvailable(){
       return gameBehavior.instaDropAvailable();
    }

    public boolean checkOver() {
        for(Block block : blocks){
            if(block.getPosition().getY()<0){
                return true;
            }
        }
        return false;
    }

    public void setGameOverBehavior(GameBehavior gameBehavior) {
        this.gameBehavior = gameBehavior;
    }

    public boolean gameOverStatus(LayoutController layoutController){
        return this.gameBehavior.gameOverStatus(layoutController);
    }
    public boolean gameOverWin(LayoutController layoutController){
        return this.gameBehavior.gameOverWin(layoutController);
    }

    public boolean isClassic(){
        return this.gameBehavior.isClassic();
    }

    public boolean isPvP(){
        return this.gameBehavior.isPvP();
    }
    public boolean checkLeaderboardUpdate(){
        return this.gameBehavior.checkLeaderboardUpdate();
    }
}
