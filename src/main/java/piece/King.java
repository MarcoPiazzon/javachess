package piece;

import utils.Move;

import static utils.Constant.Pieces.Symbol.KING_SYMBOL;

/**
 * Represents a king chess piece.
 * Inherits from the Piece class and implements specific behavior for a king.
 */
public class King extends Piece {

    /**
     * Constructs a new King with the specified color.
     *
     * @param color the color of the king (white or black)
     */
    public King(int color) {
        super(color); // Call the constructor of the superclass (Piece)
        _symbol = KING_SYMBOL;
    }

    /**
     * Calculates the possible moves for the king.
     */
    @Override
    public void calculatePossibleMoves() {
        // Implementation needed for calculating the bishop's moves
        System.out.println("Must implement");
    }

    @Override
    public boolean isValidMove(Move move) {
        return false;
    }
}
