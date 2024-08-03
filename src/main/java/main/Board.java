package main;

import piece.Piece;
import utils.Constant.*;
import utils.Move;

public class Board {
    private final Piece[] _chessboard;

    public Board(){
        this._chessboard = initChessBoard();
    }

    private Piece[] initChessBoard(){
        Piece[] res = new Piece[64];
        //res[0] = new Knight(Color.WHITE, "");
        return res;
    }

    private boolean isMoveValid(Move move){
        return false;
    }

    public void printBoard(){

    }
}
