package Problem1;

import jdk.nashorn.api.tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Main2 {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Abzal\\Documents\\Programming\\OOP\\Lab5\\src\\Problem1\\scores.txt"));

            ArrayList<Integer> list = new ArrayList<>();
            String line = in.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                list.add(Integer.parseInt(words[2]));
                line = in.readLine();
            }
            in.close();

            FileWriter out = new FileWriter("C:\\Users\\Abzal\\Documents\\Programming\\OOP\\Lab5\\src\\Problem1\\grades.txt", true);

            double sum = 0;
            for (int x : list) {
                sum += x;
            }

            out.write("Average - " + sum / list.size() + "\n" +
                         "Maximum - " + Collections.max(list) + "\n" +
                         "Minimum - " + Collections.min(list) + "\n");
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
