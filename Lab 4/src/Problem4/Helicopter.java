package Problem4;

public class Helicopter extends MovingObject implements Flying{
    int ySpeed;
    public Helicopter(int speed, int ySpeed){
        super(speed);
        this.ySpeed = ySpeed;
    }

    @Override
    public void goUp() {
        y += ySpeed;
    }

    @Override
    public void goDown() {
        y -= ySpeed;
    }
}
