package Problem2;

import java.io.Serializable;
import java.util.Objects;

public class Instructor implements Serializable {
    private String firstName, lastName, department, email;

    public Instructor(){

    }

    public Instructor(String firstName, String lastName, String department, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public void setFullName(String fullName){
        String[] words = fullName.split(" ");
        firstName = words[0];
        lastName = words[1];
    }

    @Override
    public String toString() {
        return department + " department, " +
                firstName + " " + lastName + " (" + email + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(department, that.department) &&
                Objects.equals(email, that.email);
    }
}
