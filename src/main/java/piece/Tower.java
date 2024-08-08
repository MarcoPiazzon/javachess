package piece;

import utils.Move;

import java.util.function.Predicate;

import static utils.Constant.Pieces.Symbol.TOWER_SYMBOL;

/**
 * Represents a tower chess piece.
 * Inherits from the Piece class and implements specific behavior for a rook.
 */
public class Tower extends Piece {

    /**
     * Constructs a new Rook with the specified color.
     *
     * @param color the color of the rook (white or black)
     */
    public Tower(int color) {
        super(color); // Call the constructor of the superclass (Piece) to initialize color
        _symbol = TOWER_SYMBOL;
    }

    @Override
    public Predicate<Move> validMove() {
        return null;
    }

}

