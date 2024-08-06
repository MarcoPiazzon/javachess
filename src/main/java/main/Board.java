package main;

import piece.Piece;
import utils.Move;

/**
 * Represents a chessboard with methods to initialize and manage the board state.
 */
public class Board {
    private Piece[] _chessboard;

    /**
     * Constructs a new Board and initializes the chessboard.
     */
    public Board() {
        this._chessboard = initChessBoard();
    }

    /**
     * Initializes the chessboard with the starting positions of the chess pieces.
     *
     * @return an array of Piece objects representing the chessboard
     */
    private Piece[] initChessBoard() {
        Piece[] res = new Piece[64];
        // Initialize the chessboard with pieces at their starting positions
        for (int i = 0; i < 64; i++) {
            res[i] = null;
        }
        return res;
    }

    /**
     * Checks if a move is valid according to the rules of chess.
     *
     * @param move the Move object representing the move to be validated
     * @return true if the move is valid, false otherwise
     */
    private boolean isMoveValid(Move move) {
        // Implement the logic to check if a move is valid
        return false;
    }

    /**
     * Prints the current state of the chessboard to the console.
     */
    public void printBoard() {
        System.out.println("printo la chessboard");
    }
}

