public class Student extends Person {
    public Student(String s){
        name = s;
    }

    public String getName(){
        System.out.println("Student name: " + name);
        return name;
    }
}
