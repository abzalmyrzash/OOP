public class Knight extends Piece{
    public Knight(int team){
        super('N', team);
    }

    @Override
    public boolean isLegalMove(Point a, Point b) {
        Piece piece = Board.at(b);
        if(piece != null)
            if(piece.team == team) return false;

        int change_x = Math.abs(a.x - b.x);
        int change_y = Math.abs(a.y - b.y);

        return (change_x == 2 && change_y == 1) || (change_x == 1 && change_y == 2);
    }
}
