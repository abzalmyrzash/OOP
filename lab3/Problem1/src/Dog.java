import pack.Animal;
import pack.Person;

public class Dog extends Animal {
    public Dog(){
        super();
        tameChance = 0.33;
        type = "dog";
    }

    public Dog(String name, Person owner){
        super(false);
        this.name = name;
        this.owner = owner;
    }

    @Override
    protected void sound() {
        System.out.println("Woof!");
    }

    protected void sound(boolean isAngry){
        if(!isAngry) sound();
        else System.out.println("Uuurgh! Woof! Woof!");
    }
}
