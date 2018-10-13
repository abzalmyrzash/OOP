import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Board();
        Board.draw();
        while(true){
            System.out.printf("Player %d:\\>", Board.player);
            String cmd = sc.next();

            if(cmd.equals("move")) {
                String coord1 = sc.next();
                int x1 = coord1.toLowerCase().charAt(0) - 97;
                int y1 = Integer.parseInt(coord1.substring(1)) - 1;

                String coord2 = sc.next();
                int x2 = coord2.toLowerCase().charAt(0) - 97;
                int y2 = Integer.parseInt(coord2.substring(1)) - 1;

                if(Board.player == 2 && Board.TwoPlayerPerspective){
                    x1 = 7 - x1;
                    y1 = 7 - y1;

                    x2 = 7 - x2;
                    y2 = 7 - y2;
                }

                if(Board.move(new Point(x1, y1), new Point(x2, y2)))
                    Board.draw();
            }
            else if(cmd.equals("2PlayerPerspective")){
                Board.TwoPlayerPerspective = sc.nextBoolean();
                Board.draw();
            }
            else if(cmd.equals("exit")) break;
            else if(cmd.equals("restart")){
                new Board();
                Board.draw();
            }
            else System.out.println("Invalid command!");
        }
    }
}
