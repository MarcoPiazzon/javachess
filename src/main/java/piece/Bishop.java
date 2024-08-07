package piece;

import utils.Move;

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

    /**
     * Calculates the possible moves for the bishop.
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

