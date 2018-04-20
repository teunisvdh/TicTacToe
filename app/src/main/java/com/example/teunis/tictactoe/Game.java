package com.example.teunis.tictactoe;

import android.util.Log;

import java.io.Serializable;

public class Game implements Serializable {

    // declare board of size 3x3
    final private int BOARD_SIZE = 3;
    private Tile[][] board;

    private Boolean playerOneTurn;
    private int movesPlayed = 0;

    // used winOrLose() instead
    private Boolean gameOver;

    public Game() {
        // all tiles blank, player one's turn
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;
        playerOneTurn = true;
        gameOver = false;
    }

    public Tile draw(int row, int column) {

        // if tile is blank...
        if (board[row][column] == Tile.BLANK) {
            movesPlayed += movesPlayed;

            // player one's turn: place cross
            if (playerOneTurn) {
                playerOneTurn = false;
                board[row][column] = Tile.CROSS;
                return Tile.CROSS;
            }

            // if player two: place circle
            else {
                playerOneTurn = true;
                board[row][column] = Tile.CIRCLE;
                return Tile.CIRCLE;
            }
        }
        // tile is filled: invalid move, take other tile
        else {
            return Tile.INVALID;
        }
    }

    // returns true if 3 in a row (horizontally, vertically or diagonally
    public boolean winOrLose() {

        // horizontal
        if (board[0][0] != Tile.BLANK && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            return true;
        }
        else if (board[1][0] != Tile.BLANK && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
            return true;
        }
        else if (board[2][0] != Tile.BLANK && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
            return true;
        }

        // vertical
        else if (board[0][0] != Tile.BLANK && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            return true;
        }
        else if (board[0][1] != Tile.BLANK && board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
            return true;
        }
        else if (board[0][2] != Tile.BLANK && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
            return true;
        }

        // diagonal
        else if (board[0][0] != Tile.BLANK && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        else if (board[0][2] != Tile.BLANK && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        // not 3 in a row? return false
        else {
            return false;
        }
    }
}
