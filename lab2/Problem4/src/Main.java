import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Time t = new Time(0, 0, 0);
        System.out.println("Time in Almaty:\n" +
                t.toUniversal() + "\n" +
                t.toStandard() + "\n");

        Time t2 = t.add(new Time(-3, 0, 0));

        System.out.println("Time in Moscow:\n" +
                t2.toUniversal() + "\n" +
                t2.toStandard());
    }
}