package main;

import utils.*;
import piece.*;

import java.util.ArrayList;

import static utils.Constant.Pieces.Color.*;

/**
 * Represents a chessboard with methods to initialize and manage the board state.
 */
public class Board {
    private final Piece[][] _chessboard = new Piece[8][8];

    /**
     * Constructs a new Board and initializes the chessboard.
     */
    public Board() {
        initChessBoard();
    }

    public Piece getPiece(int row, int col) {
        return _chessboard[row][col];
    }

    public char getPieceChar(int row, int col) {
        // System.out.println(_chessboard[index].getSymbol());
        return _chessboard[row][col].getSymbol();
    }

    /**
     * Initializes the chessboard with the starting positions of the chess pieces.
     */
    private void initChessBoard() {
        // WHITE Pieces
        _chessboard[0][0] = new Tower(BLACK);
        _chessboard[0][1] = new Knight(BLACK);
        _chessboard[0][2] = new Bishop(BLACK);
        _chessboard[0][3] = new Queen(BLACK);
        _chessboard[0][4] = new King(BLACK);
        _chessboard[0][5] = new Bishop(BLACK);
        _chessboard[0][6] =  new Knight(BLACK);
        _chessboard[0][7] = new Tower(BLACK);

        // BLACK Pieces
        _chessboard[7][0] = new Tower(WHITE);
        _chessboard[7][1] = new Knight(WHITE);
        _chessboard[7][2] = new Bishop(WHITE);
        _chessboard[7][3] = new Queen(WHITE);
        _chessboard[7][4] = new King(WHITE);
        _chessboard[7][5] = new Bishop(WHITE);
        _chessboard[7][6] =  new Knight(WHITE);
        _chessboard[7][7] = new Tower(WHITE);

        for (int i = 0; i < 8; i++) {
            _chessboard[1][i] = new Pawn(BLACK);
            _chessboard[6][i] = new Pawn(WHITE);
        }

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                _chessboard[i][j] = new Free(BLANK);
            }
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

    public void movePiece(Move move){
        /*
        IMPLEMENTARE IL MANGIARE UN PEZZO
         */

        // Valori di partenza CP e valori di arrivo CA
        int rowCP = move.getStartPosition().getSecond();
        int colCP = move.getStartPosition().getFirst() - 'a';
        int rowCA = move.getEndPosition().getSecond();
        int colCA = move.getEndPosition().getFirst() - 'a';

        _chessboard[rowCA][colCA] = _chessboard[rowCP][colCP];
        _chessboard[rowCP][colCP] = new Free(BLANK);
    }

    public void undoLastMove(Move move, Piece pieceCA) {
        // Cancella l ultima mossa
    }

    /**
     * Prints the current state of the chessboard to the console.
     */
    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(_chessboard[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
    }
}

