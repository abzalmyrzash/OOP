public class Sphere extends Shape{
    private double r;

    public Sphere(double r){
        this.r = r;
    }

    @Override
    public double findArea() {
        return 4 * Math.PI * r * r;
    }

    @Override
    public double findVolume() {
        return 4.0 / 3 * Math.PI * r * r * r;
    }
}
