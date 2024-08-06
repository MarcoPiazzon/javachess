package piece;

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
    }

    /**
     * Calculates the possible moves for the queen.
     */
    @Override
    public void calculatePossibleMoves() {
        // Implementation needed to calculate the queen's possible moves
        System.out.println("Must implement");
    }
}
