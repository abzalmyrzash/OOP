public class King extends Piece{
    public Point pos;
    public King(int team){
        super('K', team);
        if(team == 1) pos = new Point(4, 0);
        else if(team == 2) pos = new Point(4, 7);
    }

    @Override
    public boolean isLegalMove(Point a, Point b) {
        Piece piece = Board.at(b);
        if(piece != null)
            if(piece.team == team) return false;
        if(isCheck(b)) return false;
        return Math.abs(a.x - b.x) <= 1 && Math.abs(a.y - b.y) <= 1;
    }

    public boolean isCheck(Point a){
        int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};


        char queen = 'q', bishop = 'b', knight = 'n', rook = 'r', pawn = 'p';
        if (team == 2) {
            queen = 'Q';
            bishop = 'B';
            knight = 'N';
            rook = 'R';
            pawn = 'P';
        }

        int x = a.x + 1, y = a.y + team == 1 ? 1: -1;
        if(x >= 0 && x < 8 && y >= 0 && y < 8) {
            if(Board.at(x,y) != null)
                if (Board.at(x, y).symbol == pawn) return true;
        }

        x = a.x - 1;
        if(x >= 0 && x < 8 && y >= 0 && y < 8) {
            if(Board.at(x,y) != null)
                if(Board.at(x, y).symbol == pawn) return true;
        }

        for(int i = 0; i < 8; i++) {
            x = a.x + dx[i]; y = a.y + dy[i];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {

                Piece piece = Board.at(x, y);
                if (piece != null) {
                    if(piece.team != team) {
                        if (piece.symbol == queen) return true;
                        if (i >= 4 && piece.symbol == bishop) return true;
                        if (i < 4 && piece.symbol == rook) return true;
                    }
                    else break;
                }
                x += dx[i];
                y += dy[i];
            }
        }

        dx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        dy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};

        for(int i = 0; i < 8; i++){
            x = a.x + dx[i];
            y = a.y + dy[i];

            if(x >= 0 && x < 8 && y >= 0 && y < 8){
                if(Board.at(x, y) != null)
                    if(Board.at(x, y).symbol == knight) return true;
            }
        }
        return false;
    }

    public boolean isCheckMate(Point a){
        if(isCheck(a)){
            if(a.y > 0) {
                if(isLegalMove(a, new Point(a.x, a.y - 1)))
                    return false;
            }
            if(a.y < 7){
                if(isLegalMove(a, new Point(a.x, a.y + 1)))
                    return false;
            }

            if(a.x > 0) {
                if(isLegalMove(a, new Point(a.x - 1, a.y)))
                    return false;
                if(a.y > 0) {
                    if(isLegalMove(a, new Point(a.x - 1, a.y - 1)))
                        return false;
                }
                if(a.y < 7){
                    if(isLegalMove(a, new Point(a.x - 1, a.y + 1)))
                        return false;
                }
            }

            if(a.x < 7){
                if(isLegalMove(a, new Point(a.x + 1, a.y)))
                    if (!isCheck(new Point(a.x + 1, a.y))) return false;
                if(a.y > 0) {
                    if(isLegalMove(a, new Point(a.x + 1, a.y - 1)))
                        return false;
                }
                if(a.y < 7){
                    if(isLegalMove(a, new Point(a.x + 1, a.y + 1)))
                        return false;
                }
            }

            return true;
        }
        return false;
    }
}
