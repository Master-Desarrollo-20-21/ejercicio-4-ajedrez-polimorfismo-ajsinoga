class Coordinate {

    private int row;
    private int column;
    private static final Interval LIMITS = new Interval(1, Board.DIMENSION);

    public Coordinate() {
    }

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
        assert this.valid();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean equals(Coordinate coordinate) {
        assert coordinate != null;
        return row == coordinate.row && column == coordinate.column;
    }

    public void provide() {
        Console console = new Console();
        boolean error = false;
        do {
            console.out("\nType row "); 
            LIMITS.show();
            row = console.inInt();
            console.out("Type column: ");
            LIMITS.show();
            column = console.inInt();
            error = !this.valid();
            if (error) {
                console.out("Error!!! Values out of range.\n");
            }
        } while (error);
    }

    private boolean valid() {
        return LIMITS.include(row) && LIMITS.include(column);
    }

    public int direction(Coordinate coordinate) {
        if (this.row == coordinate.row){
            return 0;
        }
        if (this.column == coordinate.column){
            return 1;
        }
        if (this.row - this.column == 0 && coordinate.row - coordinate.column == 0){
            return 2;
        }
        if (this.row +  this.column == 9 && coordinate.row + coordinate.column == 9){
            return 3;
        }       
        return -1;
    }

	public int distance(Coordinate destination) {
		if (this.equals(destination)) {
            return 0;
        }
        if (this.row == destination.row) {
            return Math.abs(this.column - destination.column);
        }
        if (this.column == destination.column) {
            return Math.abs(this.row - destination.row);
        }
        return -1;
	}

}
