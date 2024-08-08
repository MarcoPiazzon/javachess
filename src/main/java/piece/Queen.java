package piece;

import utils.Move;

import java.util.function.Predicate;

import static utils.Constant.Pieces.Symbol.QUEEN_SYMBOL;

/**
 * Represents a queen chess piece.
 * Inherits from the Piece class and implements specific behavior for a queen.
 */
public class Queen extends Piece {

    /**
     * Constructs a new Queen with the specified color.
     *
     * @param color the color of the queen (white or black)
     */
    public Queen(int color) {
        super(color); // Call the constructor of the superclass (Piece) to initialize color
        _symbol = QUEEN_SYMBOL;
    }

    @Override
    public Predicate<Move> validMove(int end) {
        return null;
    }

    /**
     * Calculates the possible moves for the queen.
     */
    @Override
    public void calculatePossibleMoves() {
        // Implementation needed to calculate the queen's possible moves
        System.out.println("Must implement");
    }

    @Override
    public boolean isValidMove(Move move) {
        return false;
    }
}
