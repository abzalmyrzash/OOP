public class Pawn extends Piece{
    public Pawn(int team){
        super('P', team);
    }

    @Override
    public boolean isLegalMove(Point a, Point b) {
        Piece piece = Board.at(b);
        if(piece != null)
            if(piece.team == team) return false;

        if(team == 1) if(b.x < a.x) return false;
        if(team == 2) if(b.x > a.x) return false;

        int change_x = Math.abs(a.x - b.x);
        int change_y = Math.abs(a.y - b.y);

        if(change_y == 2 && change_x == 0) {
            if (team == 1 && a.y == 1) {
                return Board.at(a.x, a.y + 1) == null;
            }
            else if(team == 2 && a.y == 6){
                return Board.at(a.x, a.y - 1) == null;
            }
            return false;
        }

        if(change_y == 1 && change_x == 1){
            if(Board.at(b) == null) return false;
            if(Board.at(b).team == team) return false;
            return true;
        }

        return change_y == 1 && change_x == 0;
    }
}
