package piece;

/**
 * Represents a pawn chess piece.
 * Inherits from the Piece class and implements specific behavior for a pawn.
 */
public class Pawn extends Piece {

    /**
     * Constructs a new Pawn with the specified color.
     *
     * @param color the color of the pawn (white or black)
     */
    public Pawn(int color) {
        super(color); // Call the constructor of the superclass (Piece) to initialize color
    }

    /**
     * Calculates the possible moves for the pawn.
     */
    @Override
    public void calculatePossibleMoves() {
        // Implementation needed to calculate the knight's possible moves
        System.out.println("Must implement");
    }
}
