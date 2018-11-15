package Problem1;

public class Student implements Comparable{
    public String name;
    public int score;
    public char grade;
    public static int bestScore;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public void calculateScore(){
        if(score >= bestScore - 10) grade = 'A';
        else if(score >= bestScore - 20) grade = 'B';
        else if(score >= bestScore - 30) grade = 'C';
        else if(score >= bestScore - 40) grade = 'D';
        else grade = 'F';
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student)o;
        if(score > s.score) return 1;
        if(score == s.score) return 0;
        return -1;
    }
}
