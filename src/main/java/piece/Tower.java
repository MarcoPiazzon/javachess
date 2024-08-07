package piece;

import utils.Move;

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

    /**
     * Calculates the possible moves for the tower.
     */
    @Override
    public void calculatePossibleMoves() {
        // Implementation needed to calculate the rook's possible moves
        System.out.println("Must implement");
    }

    @Override
    public boolean isValidMove(Move move) {
        return false;
    }
}

