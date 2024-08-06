package main;

import piece.*;
import player.Human;
import player.Player;
import utils.FileHelper;
import utils.Move;

import static utils.Constant.Pieces.Color.*;

/**
 * Manages the game of chess, including player turns and game state.
 */
public class Game {
    private final Board _chessboard;
    private final Player _player1;
    private final Player _player2;
    private final FileHelper _fileHelper = new FileHelper("src/main/java/print/detailsgame.csv");
    private boolean _turn; // true if it's player1's turn, false if it's player2's turn
    private int _round;

    /**
     * Constructs a new Game with an initialized chessboard and two players.
     */
    public Game() {
        this._chessboard = new Board();
        _chessboard.printBoard();
        this._player1 = new Human("Player1");
        this._player2 = new Human("Player2");
        this._turn = true; // Start with player 1's turn
        this._round = 0;
    }

    public Piece getPiece(int row, int col) {
        return _chessboard.getPiece(row * 8 + col);
    }

    public char getPieceChar(int row, int col) {
        return _chessboard.getPieceChar(row * 8 + col);
    }

    /**
     * Starts the game by setting up any necessary initial state.
     */
    public void startGame() {
        // Implement game start logic here
    }

    /**
     * Checks if the current state of the game is checkmate.
     *
     * @return true if the game is in a checkmate state, false otherwise
     */
    private boolean isCheckMate() {
        // Implement logic to determine if the game is in checkmate
        return false;
    }

    public void saveDetailsGame() {
        StringBuilder details = new StringBuilder();
        details.append("------------------------");
        details.append("Turno numero ").append(this._round).append("\n");
        details.append(_chessboard.getPrintBoard());

        _fileHelper.saveToFile(details.toString());
    }


    public void getInputMove(Move move) {

    }

    /**
     * Validates the player's move input.
     *
     * @return true if the move input is valid, false otherwise
     */
    private boolean isInputMoveValid() {
        // Implement move validation logic here
        return false;
    }

    private static Piece getPieceFromPath(String path, int row){
        String[] parts = path.split("_");
        String utilPart = parts[1];
        return switch (utilPart){
            case "BISHOP" -> new Bishop(getColorFromPos(row));
            case "KING" -> new King(getColorFromPos(row));
            case "KNIGHT" -> new Knight(getColorFromPos(row));
            case "PAWN" -> new Pawn(getColorFromPos(row));
            case "QUEEN" -> new Queen(getColorFromPos(row));
            case "TOWER" -> new Tower(getColorFromPos(row));
            default -> throw new IllegalStateException("Unexpected value: " + utilPart);
        };
    }

    private static int getColorFromPos(int row){
        if (row < 3) return WHITE;
        else if (row > 6) return BLACK;
        return BLANK;
    }
}
