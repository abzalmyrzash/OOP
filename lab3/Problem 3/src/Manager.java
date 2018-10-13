import java.util.ArrayList;

public class Manager extends Employee {
    private ArrayList<Employee> team;
    private double bonus;

    public Manager(String n, double sal, int y, String insNum) {
        super(n, sal, y, insNum);
        team = new ArrayList<>();
        bonus = 0;
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
}
