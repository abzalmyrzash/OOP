import pack.Person;

public class Main {

    public static void main(String[] args) {
        Person p = new Person("Vasya");
        Dog d = new Dog();
        d.sound(true);
        while(!p.tame(d));
        d.sound();
    }
}
