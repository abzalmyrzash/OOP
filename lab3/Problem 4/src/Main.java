public class Main {

    public static void printInformation( Person p ){
        p.getName();
    }

    public static void main(String[] args) {
        //1
        //----------------------------------------------------
        System.out.println("1)");
        Student s1 = new Student("Almas");
        Employee e1 = new Employee("Bolat");

        Person ref = s1;

        String temp = ref.getName();
        System.out.println(temp);

        ref = e1;

        temp = ref.getName();
        System.out.println(temp);

        //2
        //----------------------------------------------------
        System.out.println("2)");
        Student s2 = new Student("Alibek");
        Employee e2 = new Employee("Samal");

        printInformation(s2);
        printInformation(e2);
    }
}
