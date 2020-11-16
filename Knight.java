

class Knight extends Piece {

    public Knight(Color color, String name) {
        super(color, name);
    }

    @Override
    public boolean move(Square origin, Square destination) {
        if (this.horizontalMovementAllow(origin, destination)) {
            return true;
        }
        if (this.verticalMovementAllow(origin, destination)) {
            return true;
        }                      
        return false;
    }

    private boolean horizontalMovementAllow(Square origin, Square destination) {
        if (origin.direction(destination) == 0) {
            return true;
        }        
        return false;
    }

    private boolean verticalMovementAllow(Square origin, Square destination) {
        if (origin.direction(destination) == 1) {
            return true;
        }
        return false;
    }
}
