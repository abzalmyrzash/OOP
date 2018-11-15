package Problem3;

import java.util.Date;
import java.util.Objects;

public class Employee extends Person implements Comparable, Cloneable {
    protected double salary;
    protected Date hiredDate;
    protected String insuranceNumber;

    public Employee(){
        hiredDate = new Date(0);
    }

    public Employee(String n, double sal, Date hiredDate, String insNum) {
        super(n);
        salary = sal;
        this.hiredDate = hiredDate;
        insuranceNumber = insNum;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHiredDate(Date date) {
        this.hiredDate = hiredDate;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(hiredDate, employee.hiredDate) &&
                Objects.equals(insuranceNumber, employee.insuranceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, hiredDate, insuranceNumber);
    }

    @Override
    public String toString() {
        return "Employee " + name + " {\n" +
                "  salary = " + salary + "\n" +
                "  date = " + hiredDate + "\n" +
                "  insuranceNumber = " + insuranceNumber + "\n}";
    }

    @Override
    public int compareTo(Object o) {
        Employee e = (Employee)o;
        if(salary > e.salary) return 1;
        if(salary == e.salary) return 0;
        return -1;
    }

    public Object deepClone(){
        String name2 = new String(name);
        double salary2 = salary;
        Date hiredDate2 = new Date(getHiredDate().getTime());
        String insuranceNumber2 = new String(insuranceNumber);
        return new Employee(name2, salary2, hiredDate2, insuranceNumber2);
    }
}
