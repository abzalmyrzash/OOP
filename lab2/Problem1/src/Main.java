public class Main {

    public static void main(String[] args) {
        Student s = new Student("Bob", "17BD1234");
        s.nextYear();
        System.out.println("Name: " + s.getName() +
                "\nID: " + s.getId() + "\nYear: " + s.getYear());

    }
}
