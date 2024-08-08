package piece;

import utils.Move;

import java.util.function.Predicate;

import static utils.Constant.Pieces.Symbol.BISHOP_SYMBOL;

/**
 * Represents a bishop chess piece.
 * Inherits from the Piece class and implements specific behavior for a bishop.
 */
public class Bishop extends Piece {

    /**
     * Constructs a new Bishop with the specified color.
     *
     * @param color the color of the bishop (white or black)
     */
    public Bishop(int color) {
        super(color); // Call the constructor of the superclass (Piece)
        _symbol = BISHOP_SYMBOL;
    }

    @Override
    public Predicate<Move> validMove() {
        return null;
    }

}

