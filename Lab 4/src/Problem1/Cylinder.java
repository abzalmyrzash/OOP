package Problem1;

public class Cylinder  extends Shape3Dclass implements Shape3D {
    double radius, height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double volume(){
        return Math.PI * radius * radius * height;
    }

    public double surfaceArea(){
        return 2 * Math.PI * radius * (radius + height);
    }
}
