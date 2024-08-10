package utils;

/**
 * Contains constant values used throughout the chess application.
 */
public class Constant {

    /**
     * Defines constants related to chess pieces.
     */
    public static class Pieces{

        /**
         * Defines color constants used in the application.
         */
        public static class Color{
            public static final int WHITE = 1;
            public static final int BLACK = -1;
            public static final int BLANK = 0;
        }


        public static class Symbol{
            public static final char BISHOP_SYMBOL = '♝';
            public static final char KING_SYMBOL = '♚';
            public static final char KNIGHT_SYMBOL = '♞';
            public static final char PAWN_SYMBOL = '♟';
            public static final char QUEEN_SYMBOL = '♛';
            public static final char TOWER_SYMBOL = '♜';
            public static final char BLANK_CELL = ' ';
        }

        /**
         * Provides paths to image files for chess pieces and initializes the chessboard.
         */
        public static class Path{
            public static final String WHITE_BISHOP_IMG = "/images/pieces/w/wb.png";
            public static final String BLACK_BISHOP_IMG = "/images/pieces/b/bb.png";
            public static final String WHITE_KING_IMG = "/images/pieces/w/wk.png";
            public static final String BLACK_KING_IMG = "/images/pieces/b/bk.png";
            public static final String WHITE_KNIGHT_IMG = "/images/pieces/w/wn.png";
            public static final String BLACK_KNIGHT_IMG = "/images/pieces/b/bn.png";
            public static final String WHITE_PAWN_IMG = "/images/pieces/w/wp.png";
            public static final String BLACK_PAWN_IMG = "/images/pieces/b/bp.png";
            public static final String WHITE_QUEEN_IMG = "/images/pieces/w/wq.png";
            public static final String BLACK_QUEEN_IMG = "/images/pieces/b/bq.png";
            public static final String WHITE_TOWER_IMG = "/images/pieces/w/wr.png";
            public static final String BLACK_TOWER_IMG = "/images/pieces/b/br.png";

            /**
             * Initial chessboard configuration with piece image paths.
             * O1 take information
             * @see #correspondingMatchPath(int, int)
             */
            private static final String[][] INITIAL_BOARD = {
                    {BLACK_TOWER_IMG, BLACK_KNIGHT_IMG, BLACK_BISHOP_IMG, BLACK_QUEEN_IMG, BLACK_KING_IMG, BLACK_BISHOP_IMG, BLACK_KNIGHT_IMG, BLACK_TOWER_IMG},
                    {BLACK_PAWN_IMG, BLACK_PAWN_IMG, BLACK_PAWN_IMG, BLACK_PAWN_IMG, BLACK_PAWN_IMG, BLACK_PAWN_IMG, BLACK_PAWN_IMG, BLACK_PAWN_IMG},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {WHITE_PAWN_IMG, WHITE_PAWN_IMG, WHITE_PAWN_IMG, WHITE_PAWN_IMG, WHITE_PAWN_IMG, WHITE_PAWN_IMG, WHITE_PAWN_IMG, WHITE_PAWN_IMG},
                    {WHITE_TOWER_IMG, WHITE_KNIGHT_IMG, WHITE_BISHOP_IMG, WHITE_QUEEN_IMG, WHITE_KING_IMG, WHITE_BISHOP_IMG, WHITE_KNIGHT_IMG, WHITE_TOWER_IMG}
            };

            /**
             * Returns the image path for a chess piece at the specified row and column.
             * @param r the row index (0 to 7)
             * @param c the column index (0 to 7)
             * @return the path to the image file for the piece at (r, c), or null if there is no piece
             * @throws IllegalArgumentException if the row or column is out of bounds
             */
            public static String correspondingMatchPath(int r, int c) {
                if (r < 0 || r > 7 || c < 0 || c > 7) {
                    throw new IllegalArgumentException("Invalid row or column");
                }
                return INITIAL_BOARD[r][c];
            }
        }

        /**
         * Defines dimensions for chess pieces.
         */
        public static class Dimensions{
            public static final int PIECE_WIDTH = 75;
            public static final int PIECE_HEIGHT = 75;
        }
    }
}
