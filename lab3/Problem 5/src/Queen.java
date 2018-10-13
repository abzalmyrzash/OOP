public class Queen extends Piece{
    public Queen(int team){
        super('Q', team);
    }

    @Override
    public boolean isLegalMove(Point a, Point b) {
        Piece piece = Board.at(b);
        if(piece != null)
            if(piece.team == team) return false;

        int change_x = Math.abs(a.x - b.x);
        int change_y = Math.abs(a.y - b.y);

        if(change_x == change_y || a.x == b.x || a.y == b.y){
            int dx = Integer.compare(b.x, a.x);
            int dy = Integer.compare(b.y, a.y);
            for(int i = 1; i < Math.max(change_x, change_y); i++){
                if(Board.at(a.x + dx * i, a.y + dy * i) != null) return false;
            }
            return true;
        }
        return false;
    }
}
