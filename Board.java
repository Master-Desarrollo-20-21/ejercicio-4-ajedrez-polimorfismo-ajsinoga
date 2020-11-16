
class Board {
    public static final int DIMENSION = 8;
    private static final int[] NOMANSLANDROWS = new int[]{2, 5};
    private Square[][] squares;
    private Console console;
    private boolean kingDefeated;

    public Board() {
        this.squares = new Square[DIMENSION][DIMENSION];
        this.initialize();
        this.kingDefeated = false;
        console = new Console();
    }

 	private void initialize() {
         this.placePawns();
         this.placeRooks();
         this.placeKnights();
         this.placeBishops();
         this.placeQueen();
         this.placeKing();
         this.placeEmptys();
    }

    private void placePawns() {
        int initialRow;
        for (Color color : Color.values()) {
            if (color == Color.WHITE) {
                initialRow = 6;
            }
            else {
                initialRow = 1;
            }
            for (int j = 0; j < DIMENSION; j++) {
                this.squares[initialRow][j] = new Square(new Coordinate(initialRow, j), new Pawn(color, "P"+(j+1)));
            }            
        }
    }

    private void placeRooks() {
        int initialRow;
        int[] rookInitialColumns = new int[]{0,7};
        for (Color color : Color.values()) {
            if (color == Color.WHITE) {
                initialRow = 7;
            }
            else {
                initialRow = 0;
            }
            int side = 1;
            for (int j : rookInitialColumns) {
                this.squares[initialRow][j] = new Square(new Coordinate(initialRow, j), new Rook(color, "R"+side));
                side++;
            }                                             
        }
    }

    private void placeKnights() {
        int initialRow;
        int[] knightInitialColumns = new int[]{1,6};
        for (Color color : Color.values()) {
            if (color == Color.WHITE) {
                initialRow = 7;
            }
            else {
                initialRow = 0;
            }
            int side = 1;
            for (int j : knightInitialColumns) {
                this.squares[initialRow][j] = new Square(new Coordinate(initialRow, j), new Knight(color, "H"+side));
                side++;
            }                                             
        }
    }

    private void placeBishops() {
        int initialRow;
        int[] bishopsInitialColumns = new int[]{2,5};
        for (Color color : Color.values()) {
            if (color == Color.WHITE) {
                initialRow = 7;
            }
            else {
                initialRow = 0;
            }
            int side = 1;
            for (int j : bishopsInitialColumns) {
                this.squares[initialRow][j] = new Square(new Coordinate(initialRow, j), new Bishop(color, "B"+side));
                side++;
            }                                             
        }
    }

    private void placeQueen() {
        int initialRow;
        int queenInitialColumns = 3;
        for (Color color : Color.values()) {
            if (color == Color.WHITE) {
                initialRow = 7;
            }
            else {
                initialRow = 0;
            }
            this.squares[initialRow][queenInitialColumns] = new Square(new Coordinate(initialRow, queenInitialColumns), new Queen(color, " Q"));                                        
        }
    }

    private void placeKing() {
        int initialRow;
        int kingInitialColumns = 4;
        for (Color color : Color.values()) {
            if (color == Color.WHITE) {
                initialRow = 7;
            }
            else {
                initialRow = 0;
            }
            this.squares[initialRow][kingInitialColumns] = new Square(new Coordinate(initialRow, kingInitialColumns), new King(color, " K"));                                        
        }
    }

    private void placeEmptys() {
        for (int i = NOMANSLANDROWS[0]; i <= NOMANSLANDROWS[1]; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                this.squares[i][j] = new Square(new Coordinate(i, j));
            }
        }
    }

    public void show() {
        this.printNumberOfColumns();
        int j = 0;
        for (int i = 0; i < DIMENSION; i++) {
            this.printNumberOfRow(i);            
            for (Square square : this.squares[j]) {
                if (!square.empty()) {
                    console.out("   " + square.nameOfPiece() + "  ");
                }
            }
            j++;
            
            console.out("\n\n");
        }
    }

    private void printNumberOfColumns() {
        console.out("    1      2      3      4      5      6      7      8\n\n");
    }
    
    private void printNumberOfRow(int i) {
        console.out(i + 1);
    }
    
    public Square getSquare(Coordinate coordinate) {
        return this.squares[coordinate.getRow()][coordinate.getColumn()];
    }

	public boolean isKingDefeated() {
		return this.kingDefeated;
	}

	public void removePiece(Coordinate origin) {
        this.squares[origin.getRow()][origin.getColumn()].clear();
	}

	public void putPiece(Coordinate destination, Piece piece) {
        this.squares[destination.getRow()][destination.getColumn()].place(piece);
	}

}
