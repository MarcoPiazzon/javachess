package piece;

import utils.Constant;

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
    public Bishop(Constant.Color color) {
        super(color); // Call the constructor of the superclass (Piece)
    }

    /**
     * Calculates the possible moves for the bishop.
     */
    @Override
    public void calculatePossibleMoves() {
        // Implementation needed for calculating the bishop's moves
        System.out.println("Must implement");
    }
}

