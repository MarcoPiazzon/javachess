package main;

import player.Human;
import player.Player;
import utils.Move;

public class Game {
    private final Board _chessboard;
    private final Player _player1;
    private final Player _player2;
    private boolean _turn;

    public Game(){
        this._chessboard = new Board();
        this._player1 = new Human();
        this._player2 = new Human();
        this._turn = true;
    }

    public void startGame(){

    }

    private boolean isCheckMate(){
        return false;
    }

    private void printDetailsGame(){

    }

    private Move getInputMove(){
        return new Move('0',0,'0',0);
    }

    private boolean isInputMoveValid(){
        return false;
    }

}


