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


    public abstract Predicate<Move> validMove();


    @Override
    public String toString() {
        return "Pezzo " + _symbol;
    }
}
