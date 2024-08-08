package piece;

import utils.Move;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Abstract class representing a chess piece.
 * Provides basic properties and methods common to all chess pieces.
 */
public abstract class Piece {
    protected final int _color; // Color of the piece
    protected boolean _isEverMoved; // Indicates if the piece has ever been moved
    protected ArrayList<Move> _possibleMoves; // List of possible moves for the piece
    protected char _symbol;

    /**
     * Constructs a new Piece with the specified color.
     *
     * @param color the color of the piece
     */
    public Piece(int color) {
        this._color = color;
        this._isEverMoved = false; // Initially, the piece has not been moved
    }

    public char getSymbol() {
        return _symbol;
    }

    /**
     * @return true if the piece has been moved, false otherwise
     */
    public boolean getIsEverMoved() {
        return this._isEverMoved;
    }

    /**
     * Marks the piece as having been moved.
     */
    public void setPieceMoved() {
        this._isEverMoved = true;
    }

    /**
     * Gets the list of possible moves for the piece.
     *
     * @return an ArrayList of Move objects representing the possible moves
     */
    public ArrayList<Move> getPossibleMoves() {
        return _possibleMoves;
    }

    public abstract Predicate<Move> validMove(int end);

    /**
     * Calculates the possible moves for the piece.
     * This method should be implemented by subclasses to define the specific movement logic for each type of piece.
     */
    public abstract void calculatePossibleMoves();

    public abstract boolean isValidMove(Move move);

    @Override
    public String toString() {
        return "Pezzo " + _symbol;
    }
}
