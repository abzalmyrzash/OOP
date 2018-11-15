package Problem4;

public class Main {
    public static void main(String[] args){
        Helicopter hel = new Helicopter(5, 2);
        hel.go();
        hel.go();
        hel.goUp();
        hel.turn("South");
        hel.go();

        System.out.printf("Coordinates: %d %d %d\n", hel.getX(), hel.getY(), hel.getZ());
    }

}
