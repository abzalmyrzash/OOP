public class Board {
    private static Piece[][] board;

    public static int player;

    private static King King1 = new King(1);
    private static King King2 =  new King(2);

    public static boolean TwoPlayerPerspective;
    public Board(){
        player = 1;
        TwoPlayerPerspective = false;

        board = new Piece[8][8];

        for(int i = 0; i < 8; i++){
            board[1][i] = new Pawn(1);
            board[6][i] = new Pawn(2);
        }

        board[0][0] = board[0][7] = new Rook(1);
        board[7][0] = board[7][7] = new Rook(2);

        board[0][1] = board[0][6] = new Knight(1);
        board[7][1] = board[7][6] = new Knight(2);

        board[0][2] = board[0][5] = new Bishop(1);
        board[7][2] = board[7][5] = new Bishop(2);

        board[0][3] = new Queen(1);
        board[7][3] = new Queen(2);

        board[0][4] = King1;
        board[7][4] = King2;
    }

    public static Piece at(int x, int y){
        return board[y][x];
    }

    public static Piece at(Point p){
        return board[p.y][p.x];
    }

    public static King king(int team){
        if(team == 1) return King1;
        else return King2;
    }

    public static void draw(){
        System.out.println("    A   B   C   D   E   F   G   H");
        System.out.println("  +---+---+---+---+---+---+---+---+");

        for (int i = 7; i >= 0; i--) {
            System.out.print(i + 1 + " | ");
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                if(player == 2 && TwoPlayerPerspective) piece = board[7 - i][7 - j];
                System.out.print((piece == null ? ' ' : piece.symbol) + " | ");
            }
            System.out.println(i + 1);
            System.out.println("  +---+---+---+---+---+---+---+---+");
        }


        System.out.println("    A   B   C   D   E   F   G   H");
    }

    public static boolean move(Point a, Point b){
        if(at(a) == null){
            System.out.println("Error! There is no piece on these coordinates!");
            return false;
        }

        if(at(a).team != player){
            System.out.println("Error! It's player " + player + "'s turn!");
            return false;
        }

        if(at(a).isLegalMove(a, b)){
            if(at(a) instanceof King)
                ((King)at(a)).pos = b;

            Piece bPiece = board[b.y][b.x];
            board[b.y][b.x] = at(a);
            board[a.y][a.x] = null;

            if(king(at(b).team).isCheck(king(at(b).team).pos)){
                System.out.println("Your king is in check! Please move " +
                        "your pieces so that the king is no more in check!");
                board[a.y][a.x] = at(b);
                board[b.y][b.x] = bPiece;
                return false;
            }
            player = player == 1 ? 2 : 1;

            if(King1.isCheck(King1.pos))
                System.out.println("Player 1 is in check!");
            if(King2.isCheck(King2.pos))
                System.out.println("Player 2 is in check!");

            if(King1.isCheckMate(King1.pos))
                System.out.println("Player 1 lost!");
            if(King2.isCheckMate(King2.pos))
                System.out.println("Player 2 lost!");
            return true;
        }
        System.out.println("Illegal move!");

        return false;
    }
}

/*
    A   B   C   D   E   F   G   H
  +---+---+---+---+---+---+---+---+
8 | r | n | b | q | k | b | n | r | 8
  +---+---+---+---+---+---+---+---+
7 | p | p | p | p | p | p | p | p | 7
  +---+---+---+---+---+---+---+---+
6 |   |   |   |   |   |   |   |   | 6
  +---+---+---+---+---+---+---+---+
5 |   |   |   |   |   |   |   |   | 5
  +---+---+---+---+---+---+---+---+
4 |   |   |   |   |   |   |   |   | 4
  +---+---+---+---+---+---+---+---+
3 |   |   |   |   |   |   |   |   | 3
  +---+---+---+---+---+---+---+---+
2 | P | P | P | P | P | P | P | P | 2
  +---+---+---+---+---+---+---+---+
1 | R | N | B | Q | K | B | N | R | 1
  +---+---+---+---+---+---+---+---+
    A   B   C   D   E   F   G   H
 */