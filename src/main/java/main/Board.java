package main;

import utils.*;
import piece.*;

import static utils.Constant.Pieces.Color.*;

/**
 * Represents a chessboard with methods to initialize and manage the board state.
 */
public class Board {
    private Piece[] _chessboard = new Piece[64];

    /**
     * Constructs a new Board and initializes the chessboard.
     */
    public Board() {
        initChessBoard();
    }

    public Piece getPiece(int index) {
        return _chessboard[index];
    }

    public char getPieceChar(int index) {
        // System.out.println(_chessboard[index].getSymbol());
        return _chessboard[index].getSymbol();
    }

    /**
     * Initializes the chessboard with the starting positions of the chess pieces.
     */
    private void initChessBoard() {
        // White Pieces
        _chessboard[0] = new Tower(WHITE);
        _chessboard[1] = new Knight(WHITE);
        _chessboard[2] = new Bishop(WHITE);
        _chessboard[3] = new Queen(WHITE);
        _chessboard[4] = new King(WHITE);
        _chessboard[5] = new Bishop(WHITE);
        _chessboard[6] = new Knight(WHITE);
        _chessboard[7] = new Tower(WHITE);

        for (int i = 8; i < 16; i++) {
            _chessboard[i] = new Pawn(WHITE);
        }

        // Black Pieces
        _chessboard[56] = new Tower(BLACK);
        _chessboard[57] = new Knight(BLACK);
        _chessboard[58] = new Bishop(BLACK);
        _chessboard[59] = new Queen(BLACK);
        _chessboard[60] = new King(BLACK);
        _chessboard[61] = new Bishop(BLACK);
        _chessboard[62] = new Knight(BLACK);
        _chessboard[63] = new Tower(BLACK);

        for (int i = 48; i < 56; i++) {
            _chessboard[i] = new Pawn(BLACK);
        }

        // Blank cell
        for (int i = 16; i < 48; i++) {
            _chessboard[i] = new Free(BLANK);
        }
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(_chessboard[i * 8 + j].getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public StringBuilder getPrintBoard() {
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                print.append(_chessboard[i * 8 + j].getSymbol()).append(" ");
            }
            print.append("\n");
        }

        return print;
    }
}

