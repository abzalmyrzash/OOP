import java.util.Objects;

public class Employee extends Person {
    protected double salary;
    protected int year;
    protected String insuranceNumber;

    public Employee(){

    }

    public Employee(String n, double sal, int y, String insNum) {
        super(n);
        salary = sal;
        year = y;
        insuranceNumber = insNum;
    }

    public double getSalary() {
        return salary;
    }

    public int getYear() {
        return year;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Employee e = (Employee) o;
        return insuranceNumber.equals(e.insuranceNumber) && year == e.year;
    }

    @Override
    public String toString() {
        return "Employee " + name + " {\n" +
                "  salary = " + salary + "\n" +
                "  year = " + year + "\n" +
                "  insuranceNumber = " + insuranceNumber + "\n}";
    }
}
