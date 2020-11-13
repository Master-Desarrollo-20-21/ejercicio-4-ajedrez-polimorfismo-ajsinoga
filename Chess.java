class Chess {
	private Board board;
	private Player[] players;
	private Turn turn;
	private int totalMovements;
		
	public Chess() {
		this.board = new Board();		
		this.players = new Player[2];
		for (int i = 0; i < this.players.length; i++) {
			this.players[i] = new Player(Color.values()[i]);
		}
		this.totalMovements = 0;
		this.turn = new Turn(this.totalMovements);		
	}

    public void play() {
		do {
			this.board.show();
			this.players[this.turn.whoPlay()].move();
			this.totalMovements++;
			this.turn.change(this.totalMovements);
		} while (!this.board.isKingDefeated());
	}

	private boolean isResumed() {
        String answer;
        Console console = new Console();
        do {
            answer = console.readString("RESUME? (y/n): ");
        } while (!answer.equals("y") && !answer.equals("n"));

        return answer.equals("y");
    }	

	static public void main(String[] args) {	
		Chess game;
        do {            
            game = new Chess();
            game.play();
        } while (game.isResumed());
	}
}