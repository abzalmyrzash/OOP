package Problem3;

import java.util.ArrayList;
import java.util.Date;

public class Manager extends Employee implements Comparable, Cloneable {
    private ArrayList<Employee> team;
    private double bonus;

    public Manager(String n, double sal, Date date, String insNum) {
        super(n, sal, date, insNum);
        team = new ArrayList<>();
        bonus = 0;
    }

    public Manager(String n, double sal, Date date, String insNum, ArrayList<Employee> team, double bonus) {
        super(n, sal, date, insNum);
        this.team = team;
        this.bonus = bonus;
    }

    public Manager(Manager m){
        this(m.name, m.salary, m.hiredDate, m.insuranceNumber, m.team, m.bonus);
    }

    public ArrayList<Employee> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Employee> team) {
        this.team = team;
        bonus = team.size() * 100;
    }

    public void addEmployee(Employee e){
        if(!team.contains(e)){
            team.add(e);
            bonus += 100;
        }
    }

    public void fireEmployee(Employee e){
        if(team.contains(e)) {
            team.remove(e);
            bonus -= 100;
        }
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary(){
        return salary + bonus;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        String s = "Manager " + name + " {\n" +
        "  salary = " + getSalary() + "\n  team:\n";
        for(int i = 0; i < team.size(); i++){
            s += "    " + team.get(i).name + " " + team.get(i).insuranceNumber + "\n";
        }
        s += "}";
        return s;
    }

    @Override
    public int compareTo(Object o) {
        int res = super.compareTo(o);
        if(res == 0){
            Manager m = (Manager)o;
            if(bonus > m.bonus) return 1;
            if(bonus == m.bonus) return 0;
            return -1;
        }
        return res;
    }



    public Object deepClone(){
        String name2 = new String(name);
        double salary2 = salary;
        Date hiredDate2 = new Date(getHiredDate().getTime());
        String insuranceNumber2 = new String(insuranceNumber);
        ArrayList<Employee> team2 = new ArrayList<>(team);
        double bonus2 = bonus;
        return new Manager(name2, salary2, hiredDate2, insuranceNumber2, team2, bonus2);
    }
}
