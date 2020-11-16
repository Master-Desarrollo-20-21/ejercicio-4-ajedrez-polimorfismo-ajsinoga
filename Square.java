
class Square {

    private Coordinate coordinate;
    private Piece piece;
    private boolean occupied;

    public Square(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.piece = null;
        this.occupied = false;
    }

    public Square(Coordinate coordinate, Piece piece) {
        this.coordinate = coordinate;
        this.piece = piece;
        this.occupied = true;
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

    public boolean empty() {
        return this.piece == null;
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

	public String nameOfPiece() {
		return piece.getName();
	}
}
