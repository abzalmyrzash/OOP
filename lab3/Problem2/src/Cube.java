public class Cube extends Shape {
    private double a;

    public Cube(double a){
        this.a = a;
    }

    @Override
    public double findArea() {
        return 6 * a * a;
    }

    @Override
    public double findVolume() {
        return a * a * a;
    }
}
