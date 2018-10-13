public class Employee extends Person {
    public Employee(String s){
        name = s;
    }

    public String getName(){
        System.out.println("Employee name: " + name);
        return name;
    }
}
