package pack;

import java.util.Scanner;

public class Person {
    String name;

    public Person(String n){
        name = n;
    }

    public boolean tame(Animal a){
        if(!a.isWild) {
            System.out.printf("%s the %s is already tamed by %s!\n",
                    a.name, a.type, a.owner.name);
            return true;
        }
        double x = Math.random();
        if(x <= a.tameChance){
            a.isWild = false;
            a.owner = this;
            System.out.printf("%s tamed a wild %s successfully!\n",
                                    name, a.type);

            Scanner sc = new Scanner(System.in);

            System.out.printf("Name your %s: ", a.type);
            a.name = sc.next();
        }
        else{
            System.out.printf("%s couldn't tame a wild %s!\n", name, a.type);
        }

        return !a.isWild;
    }
}
