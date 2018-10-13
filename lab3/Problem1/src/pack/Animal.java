package pack;

public class Animal {
    private int id;
    private static int nextId = 0;
    protected String name;
    protected boolean isWild;
    protected double tameChance; //from 0 to 1
    public String type;

    protected Person owner;

    private void assignId(){
        id = nextId;
        nextId++;
    }

    public Animal(){
        assignId();
        isWild = true;
    }

    public Animal(boolean isW){
        assignId();
        isWild = isW;
    }

    protected void sound(){
        System.out.println("blah blah blah");
    }

    void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        String s = "Animal info:\n";
        s += "ID: " + id + "\n";
        s += "type: " + type + "\n";
        if(isWild) s += "wild";
        else{
            s += "tamed; name: " + name + " owner: " + owner.name;
        }
        return s;
    }
}
