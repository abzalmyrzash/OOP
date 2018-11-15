package Problem3;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException{
        Person p = new Person("Vasya");
        Employee e = new Employee("Vlad", 500, new Date(2015, 11, 5), "2432");
        Employee e2 = new Employee("Serega", 700, new Date(2014, 6, 15), "23424");

        Manager m = new Manager("Boris", 1500, new Date(2012, 7, 19), "123121");
        Manager m2 = new Manager("Gena", 1500, new Date(2013, 12, 9), "3223");


        m.setBonus(200//        Manager m4 = (Manager)m.deepClone();
        );
        m2.setBonus(100);
        System.out.println(e.compareTo(e2));
        System.out.println(m.compareTo(m2));

        Manager m3 = (Manager)m.clone();
        Manager m4 = (Manager)m.deepClone();

        m.addEmployee(e);
        System.out.println("Shallow clone: " + m3.getTeam().size());
        System.out.println("Deep clone: " + m4.getTeam().size());
    }
}
