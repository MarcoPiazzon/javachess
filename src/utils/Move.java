package utils;

public class Move {
    private final Pair<Character, Integer> _ca;
    private final Pair<Character, Integer> _cp;

    public Move(char ca1, int ca2, char cp1, int cp2){
        this._ca = new Pair<Character, Integer>(ca1, ca2);
        this._cp = new Pair<Character, Integer>(cp1, cp2);
    }

    public Pair<Character, Integer> get_ca(){
        return this._ca;
    }

    public Pair<Character, Integer> get_cp(){
        return this._cp;
    }

    @Override
    public String toString(){
        return "";
    }
}
