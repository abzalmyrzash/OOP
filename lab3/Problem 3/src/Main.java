public class Main {

    public static void main(String[] args) {
        Person p = new Person("Vasya");
        Employee e = new Employee("Vlad", 500, 2015, "2432");
        Employee e2 = new Employee("Serega", 700, 2014, "23424");

        Manager m = new Manager("Boris", 1500, 2012, "123121");
        m.addEmployee(e);
        m.addEmployee(e2);
        System.out.println(p + "\n");
        System.out.println(e + "\n");
        System.out.println(e2 + "\n");
        System.out.println(m + "\n");

        Employee e3 = new Employee("Vlad", 600, 2015, "2432");
        System.out.println(e3.equals(e));
    }
}
