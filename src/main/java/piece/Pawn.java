package piece;

import utils.Move;

import java.util.function.Predicate;

import static utils.Constant.Pieces.Symbol.PAWN_SYMBOL;

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
        _symbol = PAWN_SYMBOL;
    }

    @Override
    public Predicate<Move> validMove() {
        return this::checkSingleMove;
    }

    private boolean checkSingleMove(Move m){
        //check distance
        int diff_y = m.getStartPosition().getSecond() - m.getEndPosition().getSecond();
        int diff_x = m.getStartPosition().getFirst() - m.getEndPosition().getFirst();
        if(Math.abs(diff_y) > 2 || Math.abs(diff_x) > 1)
            return false;

        //check move by Color
        return (diff_y == _color || (diff_y == 2*_color && !_isEverMoved));
    }

}
