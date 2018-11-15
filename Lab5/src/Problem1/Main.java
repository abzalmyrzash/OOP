package Problem1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Abzal\\Documents\\Programming\\OOP\\Lab5\\src\\Problem1\\scores.txt"));

            TreeSet<Student> list = new TreeSet();
            String line = in.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                Student s = new Student(words[0] + " " + words[1],
                        Integer.parseInt(words[2]));
                list.add(s);
                line = in.readLine();
            }
            in.close();

            Student.bestScore = list.last().score;

            BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Abzal\\Documents\\Programming\\OOP\\Lab5\\src\\Problem1\\grades.txt"));
            int i = 1;
            for (Student s : list) {
                s.calculateScore();
                out.write(String.format("%d) %s - \"%c\"", i, s.name, s.grade));
                out.newLine();
                i++;
            }
            out.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
