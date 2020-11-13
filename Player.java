

public class Player {

	private Color color;
	private Pawn[] prawns;

	public Player(Color color) {
		this.color = color;
		this.prawns = new Pawn[Board.DIMENSION];
	}

	public void move() {
		Coordinate origin = new Coordinate();
		Coordinate destination = new Coordinate();

		origin.provide();
		destination.provide();

		prawns[1].move(new Square(origin), new Square(destination));	

	}

}
