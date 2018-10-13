public class Cylinder extends Shape {
    private double r, h;

    public Cylinder(double r, double h){
        this.r = r;
        this.h = h;
    }

    @Override
    public double findArea() {
        return 2 * Math.PI * r * (h + r);
    }

    @Override
    public double findVolume() {
        return h * Math.PI * r * r;
    }
}
