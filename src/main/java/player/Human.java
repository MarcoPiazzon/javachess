package player;

public class Human extends Player{

    private final String _name;

    public Human(String playerName) {
        this._name = playerName;
    }

    public String getName() {
        return _name;
    }
}
