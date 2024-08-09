package piece;

import utils.Move;

import java.util.function.Predicate;

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

    @Override
    public Predicate<Move> validMove() {
        return this::checkSingleMove;
    }

    private boolean checkSingleMove(Move m){
        return true;
    }

}
