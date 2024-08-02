package main;

import piece.King;
import piece.Knight;
import piece.Piece;
import utils.Move;

public class Board {
    private final Piece[] _chessboard;

    public Board(){
        this._chessboard = initChessBoard();
    }

    private Piece[] initChessBoard(){
        Piece[] res = new Piece[64];
        res[0] = new Knight();
        return res;
    }

    private boolean isMoveValid(Move move){
        return false;
    }

    public void printBoard(){

    }
}
