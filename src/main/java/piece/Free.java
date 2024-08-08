package piece;

import utils.Move;

import java.util.function.Predicate;

import static utils.Constant.Pieces.Symbol.BLANK_CELL;

/**
 * Represents a free cell.
 * Inherits from the Piece class and implements specific behavior for a bishop.
 */
public class Free extends Piece {

    /**
     * Constructs a new free cell with the specified color.
     *
     * @param color the color of the free cell (BLANK)
     */
    public Free(int color) {
        super(color); // Call the constructor of the superclass (Piece)
        _symbol = BLANK_CELL;
    }

    @Override
    public Predicate<Move> validMove() {
        return null;
    }


}
