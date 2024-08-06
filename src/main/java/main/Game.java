package main;

import piece.*;
import player.Human;
import player.Player;
import utils.Move;

import static utils.Constant.Color.*;

/**
 * Manages the game of chess, including player turns and game state.
 */
public class Game {
    private final Board _chessboard;
    private final Player _player1;
    private final Player _player2;
    private boolean _turn; // true if it's player1's turn, false if it's player2's turn

    /**
     * Constructs a new Game with an initialized chessboard and two players.
     */
    public Game() {
        this._chessboard = new Board();
        this._player1 = new Human();
        this._player2 = new Human();
        this._turn = true; // Start with player 1's turn
    }

    /**
     * Starts the game by setting up any necessary initial state.
     */
    public void startGame() {
        // Implement game start logic here
    }

    /**
     * Checks if the current state of the game is checkmate.
     *
     * @return true if the game is in a checkmate state, false otherwise
     */
    private boolean isCheckMate() {
        // Implement logic to determine if the game is in checkmate
        return false;
    }

    /**
     * Prints details about the current game state to the console.
     */
    private void printDetailsGame() {
        // Implement logic to print game details
    }


    public void getInputMove(Move move) {

    }

    /**
     * Validates the player's move input.
     *
     * @return true if the move input is valid, false otherwise
     */
    private boolean isInputMoveValid() {
        // Implement move validation logic here
        return false;
    }

    private static Piece getPieceFromPath(String path, int row){
        String[] parts = path.split("_");
        String utilPart = parts[1];
        return switch (utilPart){
            case "BISHOP" -> new Bishop(getColorFromPos(row));
            case "KING" -> new King(getColorFromPos(row));
            case "KNIGHT" -> new Knight(getColorFromPos(row));
            case "PAWN" -> new Pawn(getColorFromPos(row));
            case "QUEEN" -> new Queen(getColorFromPos(row));
            case "TOWER" -> new Tower(getColorFromPos(row));
            default -> throw new IllegalStateException("Unexpected value: " + utilPart);
        };
    }

    private static int getColorFromPos(int row){
        if (row < 3) return WHITE;
        else if (row > 6) return BLACK;
        return BLANK;
    }
}
