package com.alexhoward.tictactoe;
import java.util.List;
import java.util.ArrayList;

public class TicTacToeGame {
    int currentPlayer = 1;
    int[][] gameGrid = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
    };
    boolean gameOver = false;
    int winner = -1;
    List<int[]> lastWinningLine = null;

    public void makeMove(int row, int col){
        // Mark move in grid
        setPlayerMove(row, col);

        // Determine if is_won
        lastWinningLine = getWinningLine();

        if (lastWinningLine != null){
            gameOver = true;
            winner = currentPlayer;
        }

        // Determine if tie
        if (!gameOver) {
            checkTie();
        }

        // Change player to next
        changePlayer();

        if (gameOver) {
            if (winner > 0) {
                System.out.println("Winner is: " + winner);
            } else {
                System.out.println("Tie game");
            }
        }

        printCurrentGame();
    }

    public void changePlayer(){
        currentPlayer = currentPlayer == 1 ? 2 : 1;
    }

    public void setPlayerMove(int row, int col){
        gameGrid[row][col] = currentPlayer;
    }

    public List<int[]> getWinningLine() {
        List<int[]> winningLine = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (gameGrid[i][0] == currentPlayer && gameGrid[i][1] == currentPlayer && gameGrid[i][2] == currentPlayer) {
                winningLine.add(new int[] {i, 0});
                winningLine.add(new int[] {i, 1});
                winningLine.add(new int[] {i, 2});
                return winningLine;
            }

            if (gameGrid[0][i] == currentPlayer && gameGrid[1][i] == currentPlayer && gameGrid[2][i] == currentPlayer) {
                winningLine.add(new int[] {0, i});
                winningLine.add(new int[] {1, i});
                winningLine.add(new int[] {2, i});
                return winningLine;
            }
        }

        if (gameGrid[0][0] == currentPlayer && gameGrid[1][1] == currentPlayer && gameGrid[2][2] == currentPlayer) {
            winningLine.add(new int[] {0, 0});
            winningLine.add(new int[] {1, 1});
            winningLine.add(new int[] {2, 2});
            return winningLine;
        }

        if (gameGrid[0][2] == currentPlayer && gameGrid[1][1] == currentPlayer && gameGrid[2][0] == currentPlayer) {
            winningLine.add(new int[] {0, 2});
            winningLine.add(new int[] {1, 1});
            winningLine.add(new int[] {2, 0});
            return winningLine;
        }

        return null;
    }

    public void checkTie(){
        for (int[] row: gameGrid){
            for (int col: row){
                if(col == 0){
                    return;
                }
            }
        }

        gameOver = true;
        winner = 0;
    }

    public int getCurrentPlayer(){
        return currentPlayer;
    }

    public boolean getGameOver(){
        return gameOver;
    }

    public List<int[]> getLastWinningLine() {
        return lastWinningLine;
    }

    public void printCurrentGame(){
        for(int[] row: gameGrid){
            for(int col: row){
                System.out.print(col);
            }
            System.out.print("\n");
        }
    }
}
