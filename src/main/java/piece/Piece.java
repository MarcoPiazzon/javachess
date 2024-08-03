package piece;

import static utils.Constant.Color;
import static utils.Constant.Image;

public abstract class Piece {
    protected final Color _color;
    protected boolean _isEverMoved;
    protected Image _image;

    public Piece(Color color, Image image){
        this._color = color;
        this._isEverMoved = false;
        this._image = image;
    }

    public boolean getIsEverMoved(){
        return this._isEverMoved;
    }

    public void setPieceMoved(){
        this._isEverMoved = true;
    }
}
