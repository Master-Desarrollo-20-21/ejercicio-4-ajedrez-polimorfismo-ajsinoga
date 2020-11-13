class Pawn extends Piece {

    private boolean firstMovement;

    public Pawn(Color color, String name) {
        super(color, name);       
        firstMovement = true; 
    }

    @Override
    public boolean move(Square origin, Square destination) {
        if (this.horizontalMovementAllow(origin, destination)) {
            return true;
        }
        if (this.verticalMovementAllow(origin, destination)) {
            return true;
        }
        if (this.diagonalMovementAllow(origin, destination)) {
            return true;
        }                        
        return false;
    }

    private boolean horizontalMovementAllow(Square origin, Square destination) {
        if (origin.direction(destination) == 0 && origin.distance(destination) == 1) {
            return true;
        }        
        return false;
    }

    private boolean verticalMovementAllow(Square origin, Square destination) {
        if (origin.direction(destination) == 1 && (origin.distance(destination) == 1
                                                   || (origin.distance(destination) == 2 && this.firstMovement))) {
            this.firstMovement = false;
            return true;
        }
        return false;
    }

    private boolean diagonalMovementAllow(Square origin, Square destination) {
        if (origin.direction(destination) == 2 || origin.direction(destination) == 3) {
            if (!destination.occupied(this.color)) {
                return true;
            }
        }
        return false;
    }
}