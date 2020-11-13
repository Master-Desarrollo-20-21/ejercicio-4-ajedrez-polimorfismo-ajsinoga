

abstract class Piece {

    protected Color color;
    protected String name;

    public Piece(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return this.color;
    }

    public String show() {
        return this.name;
    }

    public boolean amIaKing() {
        return false;
    }

    public abstract boolean move(Square origin, Square destination);

}
