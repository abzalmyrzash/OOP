package Problem3;

public class Person implements Cloneable {
    protected String name;
    public Person(){

    }
    public Person(String n){
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MovingObject " + name + "{ }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Person p = (Person) o;
        return name.equals(p.name);
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
