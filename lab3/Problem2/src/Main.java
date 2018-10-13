public class Main {

    public static void main(String[] args) {
        Cylinder o1 = new Cylinder(3, 5);
        Sphere o2 = new Sphere(4);
        Cube o3 = new Cube(2);

        System.out.println(o1.findArea());
        System.out.println(o1.findVolume());

        System.out.println(o2.findArea());
        System.out.println(o2.findVolume());

        System.out.println(o3.findArea());
        System.out.println(o3.findVolume());
    }
}
