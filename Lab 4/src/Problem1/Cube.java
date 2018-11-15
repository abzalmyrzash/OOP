package Problem1;

public class Cube extends Shape3Dclass implements Shape3D {
    double side;

    public Cube(double side){
        this.side = side;
    }

    public double volume(){
        return side * side * side;
    }

    public double surfaceArea(){
        return 6 * side * side;
    }
}
