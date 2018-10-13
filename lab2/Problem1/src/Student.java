public class Student
{
    private String name, id;
    private int year;

    public Student(String name, String id)
    {
        this.name = name;
        this.id = id;
        year = 1;
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public int getYear()
    {
        return year;
    }

    public void nextYear()
    {
        year++;
    }
}
