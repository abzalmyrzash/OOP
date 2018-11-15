package Problem1;

public class Sphere extends Shape3Dclass implements Shape3D {
    double radius;

    public Sphere(double r){
        radius = r;
    }

    public double volume(){
        return 4/3 * Math.PI * radius * radius * radius;
    }

    public double surfaceArea(){
        return 4 * Math.PI * radius * radius;
    }
}
