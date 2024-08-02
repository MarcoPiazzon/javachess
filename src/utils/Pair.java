package utils;

public class Pair <A,B>{
    private final A _col;
    private final B _row;

    public Pair(A col, B row){
        this._col = col;
        this._row = row;
    }

    public A getFirst(){
        return this._col;
    }

    public B getSecond(){
        return this._row;
    }
}
