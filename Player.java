

public class Player {

	private Color color;
	private Pawn[] prawns;

	public Player(Color color) {
		this.color = color;
		this.prawns = new Pawn[Board.DIMENSION];
	}

	public void move(Board board) {
		Coordinate origin = new Coordinate();
		Coordinate destination = new Coordinate();

		origin.provide();
		destination.provide();

		if (prawns[1].move(board.getSquare(origin), board.getSquare(destination))) {
			board.removePiece(origin);
			board.putPiece(destination, prawns[1]);
		}	

	}

}
