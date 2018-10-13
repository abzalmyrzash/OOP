public class Main {

    public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.print("Enter width of the triangle: ");
        int w = s.nextInt();
        StarTriangle triangle = new StarTriangle(w);
        System.out.print(triangle.toString());
    }
}
