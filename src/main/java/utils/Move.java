package utils;

/**
 * Represents a move in a chess game.
 * Stores the starting and ending positions of a move.
 */
public class Move {
    private final Pair<Character, Integer> _ca; // Starting position (column and row)
    private final Pair<Character, Integer> _cp; // Ending position (column and row)

    /**
     * Constructs a new Move with the specified start and end positions.
     *
     * @param ca1 the starting column ('a' through 'h')
     * @param ca2 the starting row (1 through 8)
     * @param cp1 the ending column ('a' through 'h')
     * @param cp2 the ending row (1 through 8)
     */
    public Move(char ca1, int ca2, char cp1, int cp2) {
        this._ca = new Pair<>(ca1, ca2); // Initialize starting position
        this._cp = new Pair<>(cp1, cp2); // Initialize ending position
    }

    /**
     * Gets the starting position of the move.
     *
     * @return a Pair representing the starting column and row
     */
    public Pair<Character, Integer> getStartPosition() {
        return this._ca;
    }

    /**
     * Gets the ending position of the move.
     *
     * @return a Pair representing the ending column and row
     */
    public Pair<Character, Integer> getEndPosition() {
        return this._cp;
    }

    /**
     * Provides a string representation of the move.
     *
     * @return a string representation of the move
     */
    @Override
    public String toString() {
        // Implementation needed to return a meaningful string representation of the move
        return this._ca.toString() + " " + this._cp.toString();
    }


}

