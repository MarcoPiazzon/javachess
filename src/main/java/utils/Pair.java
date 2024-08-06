package utils;

/**
 * Represents a pair of values.
 * This class is used to store and manipulate a pair of objects of potentially different types.
 *
 * @param <A> the type of the first value
 * @param <B> the type of the second value
 */
public class Pair<A, B> {
    private final A _col; // The first value of the pair
    private final B _row; // The second value of the pair

    /**
     * Constructs a new Pair with the specified values.
     *
     * @param col the first value of the pair
     * @param row the second value of the pair
     */
    public Pair(A col, B row) {
        this._col = col; // Initialize the first value
        this._row = row; // Initialize the second value
    }

    /**
     * Gets the first value of the pair.
     *
     * @return the first value
     */
    public A getFirst() {
        return this._col;
    }

    /**
     * Gets the second value of the pair.
     *
     * @return the second value
     */
    public B getSecond() {
        return this._row;
    }

    @Override
    public String toString() {
        return "Pair [_col=" + this._col + ", _row=" + this._row + "]";
    }
}
