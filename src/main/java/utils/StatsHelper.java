package utils;

import java.util.ArrayList;

public class StatsHelper {
    private final ArrayList<Move> _movesPlayer1;
    private final ArrayList<Move> _movesPlayer2;

    private int _roundNumber;

    private final FileHelper _fileHelper = new FileHelper("src/main/java/print/detailsgame.csv");

    public StatsHelper() {
        _movesPlayer1 = new ArrayList<>();
        _movesPlayer2 = new ArrayList<>();
        _roundNumber = 1;
    }

    /**
     *
     * @param move
     * @param round true if it's player1's turn, false if it's player2's turn
     */
    public void addMove(Move move, boolean round) {
        if (round) {
            _movesPlayer1.add(move);
        } else {
            _movesPlayer2.add(move);
        }
    }

}
