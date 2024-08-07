package piece;

import utils.Move;

import static utils.Constant.Pieces.Symbol.KNIGHT_SYMBOL;

/**
 * Represents a knight chess piece.
 * Inherits from the Piece class and implements specific behavior for a knight.
 */
public class Knight extends Piece {

    /**
     * Constructs a new Knight with the specified color.
     *
     * @param color the color of the knight (white or black)
     */
    public Knight(int color) {
        super(color); // Call the constructor of the superclass (Piece) to initialize color
        _symbol = KNIGHT_SYMBOL;
    }

    /**
     * Calculates the possible moves for the knight.
     */
    @Override
    public void calculatePossibleMoves() {
        // Implementation needed to calculate the knight's possible moves
        System.out.println("Must implement");
    }

    @Override
    public boolean isValidMove(Move move) {
        return false;
    }
}

