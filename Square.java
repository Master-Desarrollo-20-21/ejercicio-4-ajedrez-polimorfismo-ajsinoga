
class Square {

    private Coordinate coordinate;
    private Piece piece;
    private boolean occupied;

    public Square(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.piece = null;
        this.occupied = false;
    }

	public int direction(Square destination) {
		return this.coordinate.direction(destination.coordinate);
	}

	public int distance(Square destination) {
		return this.coordinate.distance(destination.coordinate);
	}

	public boolean occupied(Color color) {
        if (this.occupied) {
            return this.sameColor(color);
        }
		return false;
    }
    
    private boolean sameColor(Color color) {
        return this.piece.getColor() == color;
    }

	public void clear() {
        this.piece = null;
        this.occupied = false;
	}

	public void place(Piece piece) {
        this.piece = piece;
        this.occupied = true;
	}
}
