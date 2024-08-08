package main;

import utils.*;
import piece.*;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static utils.Constant.Pieces.Color.*;

/**
 * Represents a chessboard with methods to initialize and manage the board state.
 */
public class Board {
    private final ArrayList<Piece> _chessboard = new ArrayList<>();

    /**
     * Constructs a new Board and initializes the chessboard.
     */
    public Board() {
        initChessBoard();
    }

    public Piece getPiece(int index) {
        return _chessboard.get(index);
    }

    public char getPieceChar(int index) {
        // System.out.println(_chessboard[index].getSymbol());
        return _chessboard.get(index).getSymbol();
    }

    /**
     * Initializes the chessboard with the starting positions of the chess pieces.
     */
    private void initChessBoard() {
        // White Pieces
        _chessboard.add(new Tower(WHITE));
        _chessboard.add(new Knight(WHITE));
        _chessboard.add(new Bishop(WHITE));
        _chessboard.add( new Queen(WHITE));
        _chessboard.add(new King(WHITE));
        _chessboard.add( new Bishop(WHITE));
        _chessboard.add(new Knight(WHITE));
        _chessboard.add(new Tower(WHITE));

        for (int i = 8; i < 16; i++) {
            _chessboard.add(new Pawn(WHITE));
        }

        // Blank cell
        for (int i = 16; i < 48; i++) {
            _chessboard.add(new Free(BLANK));
        }
        for (int i = 48; i < 56; i++) {
            _chessboard.add(new Pawn(BLACK));
        }
        // Black Pieces
        _chessboard.add( new Tower(BLACK));
        _chessboard.add( new Knight(BLACK));
        _chessboard.add( new Bishop(BLACK));
        _chessboard.add( new Queen(BLACK));
        _chessboard.add( new King(BLACK));
        _chessboard.add( new Bishop(BLACK));
        _chessboard.add( new Knight(BLACK));
        _chessboard.add( new Tower(BLACK));





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
        int rowCP = move.getStartPosition().getSecond() - 1;
        int colCP = move.getStartPosition().getFirst() - 'a';
        int rowCA = move.getEndPosition().getSecond() - 1;
        int colCA = move.getEndPosition().getFirst() - 'a';
        System.out.println(rowCP + " " + colCP + " " + rowCA + " " + colCA);
        _chessboard.set(rowCA * 8 + colCA, _chessboard.get(rowCP * 8 + colCP));
        _chessboard.set(rowCP * 8 + colCP, new Free(BLANK));
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
                System.out.print(_chessboard.get(i * 8 + j).getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public StringBuilder getPrintBoard() {
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                print.append(_chessboard.get(i * 8 + j).getSymbol()).append(" ");
            }
            print.append("\n");
        }

        return print;
    }
}

