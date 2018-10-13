public class Bishop extends Piece{
    public Bishop(int team){
        super('B', team);
    }

    @Override
    public boolean isLegalMove(Point a, Point b) {
        Piece piece = Board.at(b);
        if(piece != null)
            if(piece.team == team) return false;

        int change_x = Math.abs(a.x - b.x);
        int change_y = Math.abs(a.y - b.y);

        if(change_x == change_y){
            int dx = b.x > a.x ? 1 : -1;
            int dy = b.y > a.y ? 1 : -1;
            for(int i = 1; i < change_x; i++){
                if(Board.at(a.x + dx * i, a.y + dy * i) != null) return false;
            }
            return true;
        }
        return false;
    }
}
