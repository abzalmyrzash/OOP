package Problem1;

public class Point extends Shape3Dclass implements Shape3D {
    double x, y, z;

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double volume(){
        return 0;
    }

    public double surfaceArea(){
        return 0;
    }
}
