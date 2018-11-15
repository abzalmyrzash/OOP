package Problem4;

public class MovingObject implements Moveable{
    protected String direction = "East";
    protected int x = 0, y = 0, z = 0;

    int speed;

    public MovingObject(){}

    public MovingObject(int speed){
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public void go() {
        if(direction == "East") x += speed;
        else if(direction == "West") x -= speed;
        else if(direction == "North") z += speed;
        else if(direction == "South") z -= speed;
    }

    @Override
    public void turn(String dir){
        direction = dir;
    }
}
