package piece;

import static utils.Constant.Color;

public abstract class Piece {
    protected final Color _color;
    protected boolean _isEverMoved;

    public Piece(Color color){
        this._color = color;
        this._isEverMoved = false;
    }

    public boolean getIsEverMoved(){
        return this._isEverMoved;
    }

    public void setPieceMoved(){
        this._isEverMoved = true;
    }
}
