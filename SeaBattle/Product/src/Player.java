import java.util.Scanner;

public class Player {
    private int boardSize;
    private String name;
    PlayerFunction playerFunction = new PlayerFunction();
    private char[][] myBoard = new char[20][20];
    private int theNumberOfSquaresShot = 0;
    private int theNumberOfBoatsHit = 0;
    private int theNumberOfMyRemainingBoats = 5;
    public int getBoardSize() {
        return boardSize;
    }
    public void setBoardSize(int boardSize){
        this.boardSize = boardSize;
    }
    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public int getTheNumberOfSquaresShot () {
        return theNumberOfSquaresShot;
    }
    public void setTheNumberOfSquaresShot (int theNumberOfSquaresShot) {
        this.theNumberOfSquaresShot = theNumberOfSquaresShot;
    }
    public int getTheNumberOfBoatsHit () {
        return theNumberOfBoatsHit;
    }
    public void setTheNumberOfBoatsHit (int theNumberOfBoatsHit) {
        this.theNumberOfBoatsHit = theNumberOfBoatsHit;
    }
    public int getTheNumberOfMyRemainingBoats () {
        return theNumberOfMyRemainingBoats;
    }
    public void setTheNumberOfMyRemainingBoats (int theNumberOfMyRemainingBoats) {
        this.theNumberOfMyRemainingBoats = theNumberOfMyRemainingBoats;
    }
    public char[][] getMyBoard () {
        return myBoard;
    }
    public void setMyBoard() {
        for (int i = 0; i < 20; ++i) {
            for (int j = 0; j < 20; ++j) {
                this.myBoard[i][j] = '0';
            }
        }
    }
    public void setUpBoats (Scanner sc) {
        playerFunction.playerSetsUpTheBoat(sc, this);
    }
    public boolean openFireAndCheck (Scanner sc, Player enemy) {
        return playerFunction.playerOpensFireAndCheck(sc, this, enemy);
    }
}