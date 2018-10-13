public abstract class Piece{
    public char symbol;
    protected int team;


    public Piece(char c, int t) {
        if(t == 1) symbol = c;
        else if(t == 2) symbol = (char)(c + 32);
        team = t;
    }

    public abstract boolean isLegalMove(Point a, Point b);
}
