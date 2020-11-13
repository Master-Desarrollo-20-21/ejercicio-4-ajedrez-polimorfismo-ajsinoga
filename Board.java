
class Board {
    public static final int DIMENSION = 8;
    private Square[][] squares;
    private Console console;
    private boolean kingDefeated;

    public Board() {
        this.squares = new Square[DIMENSION][DIMENSION];
        this.kingDefeated = false;
        console = new Console();
    }

	public void show() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                console.out(squares[i][j]);
            }
        }
	}

	public boolean isKingDefeated() {
		return this.kingDefeated;
	}

}
