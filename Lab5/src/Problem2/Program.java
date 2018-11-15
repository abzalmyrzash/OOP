package Problem2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    private static ArrayList<Course> courses;
    private static ArrayList<Instructor> instructors;
    private static ArrayList<Textbook> textbooks;

    private enum Mode {USER, ADMIN};
    private static Mode mode;

    private static Scanner scanner = new Scanner(System.in);

    private static String trueUsername, truePassword;

    private static String path = "C:\\Users\\Abzal\\Documents\\Programming\\OOP\\Lab5\\src\\Problem2\\";
    private static SimpleDateFormat format =
            new SimpleDateFormat("dd.MM.yyyy HH:mm");

    public static void initialSerialization() {
        try {
            Textbook t1 = new Textbook("99-92-8894", "Calculus", "Thomas");
            Textbook t2 = new Textbook("90-76-3914", "C++ Programming", "B. Stroustrup");
            Textbook t3 = new Textbook("87-19-6813",
                    "First-order differential equations", "A. Filipov");

            Instructor i1 = new Instructor("Fuad", "Gadzhiev",
                    "IT", "fuadbei@kbtu.kz");
            Instructor i2 = new Instructor("Beisenbek", "Baisakov",
                    "IT", "beisenbek@kbtu.kz");
            Instructor i3 = new Instructor("Victor", "Verbovskiy",
                    "NOTS MIK", "verbovskiy@kbtu.kz");

            Course c1 = new Course("Calculus", t1, i1);
            Course c2 = new Course("Programming Principles I", t2, i2);
            Course c3 = new Course("Differential Equations", t3, i3);

            ObjectOutputStream ser;
            ser = new ObjectOutputStream(new FileOutputStream(path + "textbook.ser"));
            ArrayList<Textbook> textbooks = new ArrayList<>();
            textbooks.add(t1);
            textbooks.add(t2);
            textbooks.add(t3);
            ser.writeObject(textbooks);


            ser = new ObjectOutputStream(new FileOutputStream(path + "instructor.ser"));
            ArrayList<Instructor> instructors = new ArrayList<>();
            instructors.add(i1);
            instructors.add(i2);
            instructors.add(i3);
            ser.writeObject(instructors);

            ser = new ObjectOutputStream(new FileOutputStream(path + "course.ser"));
            ArrayList<Course> courses = new ArrayList();
            courses.add(c1);
            courses.add(c2);
            courses.add(c3);
            ser.writeObject(courses);

            ser.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }


    private static void showCourseList(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("List of courses\n");

        int i = 1;
        for(Course c : courses){
            System.out.println(i + ") " + c.getCourseTitle());
            i++;
        }
    }


    public static void init(){
        try{
            ObjectInputStream deser =
                    new ObjectInputStream(new FileInputStream(path + "course.ser"));
            courses = (ArrayList<Course>)deser.readObject();

            deser = new ObjectInputStream(new FileInputStream(path + "textbook.ser"));
            textbooks = (ArrayList<Textbook>)deser.readObject();

            deser = new ObjectInputStream(new FileInputStream(path + "instructor.ser"));
            instructors = (ArrayList<Instructor>)deser.readObject();


            FileReader in = new FileReader(path + "admin.txt");
            BufferedReader reader = new BufferedReader(in);

            trueUsername = reader.readLine().split(" ")[1];
            truePassword = reader.readLine().split(" ")[1];

            reader.close();
            in.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }

    public static void logIn(){
        try {
            System.out.println("Welcome to the system! Are you a user or the admin? (u/a)");

            while (true) {
                String s = scanner.nextLine();
                if (s.charAt(0) == 'u') {
                    mode = Mode.USER;

                } else if (s.charAt(0) == 'a') {
                    while (true) {
                        System.out.println("\n\n\n\nPlease enter username and login. (To enter user mode type '\\u')\n");
                        System.out.print("Username: ");
                        String username = scanner.nextLine();
                        if (username.equals("\\u")) {
                            mode = mode.USER;
                            break;
                        }

                        System.out.print("Password: ");
                        String password = scanner.nextLine();

                        if (!username.equals(trueUsername) || !password.equals(truePassword)) {
                            System.out.println("Invalid username or password. Please enter again.");
                            continue;
                        }
                        mode = mode.ADMIN;
                        FileWriter out = new FileWriter(path + "admin.txt", true);
                        BufferedWriter writer = new BufferedWriter(out);

                        String date = format.format(new Date());
                        writer.write(date + " admin logged into the system\n");
                        writer.close();
                        break;
                    }
                } else {
                    System.out.println("Invalid input! Please repeat again!\n" +
                            "Enter 'u' for user mode, and 'a' for admin mode.");
                    continue;
                }
                break;
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void menu(){
        try {
            FileWriter out = new FileWriter(path + "admin.txt", true);
            BufferedWriter writer = new BufferedWriter(out);

            ObjectOutputStream ser;

            showCourseList();
            System.out.println("\n\nFor details type 'view <course number>'. To log out type 'logout'");
            System.out.println("If you want to view list of textbooks or instructors, type 'textbooks' or 'instructors'");
            System.out.println("To view list of courses again, type 'list'\n");
            if (mode == mode.ADMIN) {
                System.out.println("To add a textbook, instructor, or course use" +
                        " 'add <type> <parameters>");
                System.out.println("For more info about the add command, write 'help add'\n");
            }
            while (true) {
                System.out.print(">");
                String cmd = scanner.next();

                if (cmd.equals("view")) {
                    int i = scanner.nextInt();
                    if (i > 0 && i <= courses.size())
                        System.out.println("\n" + courses.get(i - 1));
                    else {
                        System.out.println("Index out of range!");
                    }
                }
                else if(cmd.equals("textbooks")){
                    for(Textbook t : textbooks)
                        System.out.println(t);
                }
                else if(cmd.equals("instructors")){
                    for(Instructor instr : instructors)
                        System.out.println(instr);
                }
                else if(cmd.equals("list")) showCourseList();
                else if (cmd.equals("add") && mode == mode.ADMIN) {
                    String type = scanner.next();
                    if (type.equals("textbook")) {
                        Textbook textbook = new Textbook();

                        String line = scanner.nextLine();
                        String[] parameters = line.split("; ");

                        String isbn = parameters[0].substring(1);
                        textbook.setIsbn(isbn);

                        String title = parameters[1];
                        textbook.setTitle(title);

                        String authors = parameters[2];
                        textbook.setAuthors(authors);
                        //if(textbook == null) System.out.println("null textbook");
                        textbooks.add(textbook);
                        ser = new ObjectOutputStream(new FileOutputStream(path + "textbook.ser"));
                        ser.writeObject(textbooks);
                        ser.close();

                        writer = new BufferedWriter(new FileWriter
                                (path + "admin.txt", true));
                        writer.write(format.format(new Date()) + " admin added" +
                                " new textbook \"" + title + "\"\n");
                        writer.close();
                    }
                    else if(type.equals("instructor")){
                        Instructor instructor = new Instructor();

                        String line = scanner.nextLine();
                        String[] parameters = line.split("; ");

                        String firstName = parameters[0].substring(1);
                        instructor.setFirstName(firstName);

                        String lastName = parameters[1];
                        instructor.setLastName(lastName);

                        String department = parameters[2];
                        instructor.setDepartment(department);

                        String email = parameters[3];
                        instructor.setEmail(email);

                        instructors.add(instructor);
                        ser = new ObjectOutputStream(new FileOutputStream(path + "instructor.ser"));
                        ser.writeObject(instructors);
                        ser.close();

                        writer = new BufferedWriter(new FileWriter
                                (path + "admin.txt", true));
                        writer.write(format.format(new Date()) + " admin added" +
                                " new instructor " + instructor.getFullName() + "\n");
                        writer.close();
                    }
                    else if(type.equals("course")){
                        Course course = new Course();

                        String line = scanner.nextLine();
                        String[] parameters = line.split("; ");

                        String courseTitle = parameters[0].substring(1);
                        course.setCourseTitle(!courseTitle.equals("null") ? courseTitle : null);

                        String isbn = parameters[1];
                        Textbook textbook = null;
                        for(Textbook t : textbooks){
                            if(t.getIsbn().equals(isbn)){
                                textbook = t;
                                break;
                            }
                        }
                        if(textbook == null){
                            System.out.println("No such textbook isbn!");
                            break;
                        }
                        course.setTextbook(textbook);

                        String fullName = parameters[2];
                        Instructor instructor = null;
                        for(Instructor instr : instructors){
                            if(instr.getFullName().equals(fullName)){
                                instructor = instr;
                            }
                        }
                        if(instructor == null){
                            System.out.println("No such teacher!");
                            break;
                        }
                        course.setInstructor(instructor);

                        courses.add(course);
                        ser = new ObjectOutputStream(new FileOutputStream(path + "course.ser"));
                        ser.writeObject(courses);
                        ser.close();

                        writer = new BufferedWriter(new FileWriter
                                (path + "admin.txt", true));
                        writer.write(format.format(new Date()) + " admin added " +
                                "new course \"" + courseTitle + "\"\n");
                        writer.close();
                    }
                } else if (cmd.equals("help") && mode == mode.ADMIN) {
                    String command = scanner.next();
                    if (command.equals("add")) {
                        System.out.println("General syntax: add <type> <parameters>");
                        System.out.println("<type> can be textbook, instructor, or course");
                        System.out.println("<parameters> are separated by '; '");
                        System.out.println("<parameters> for textbook: isbn, title, authors");
                        System.out.println("<parameters> for instructor: firstName, lastName, department, email");
                        System.out.println("<parameters> for course: courseTitle, textbook_isbn, instructor_fullName");
                        System.out.println("To create a course, first you need get textbook and instructor from .ser files,\n" +
                                "then you must enter textbook's isbn and instructor's fullName as the parameter list\n"
                        );
                    }
                } else if (cmd.equals("logout")) {
                    if (mode == mode.ADMIN) {
                        writer = new BufferedWriter(new FileWriter
                                (path + "admin.txt", true));
                        writer.write(format.format(new Date()) +
                                " admin logged out of the system\n\n");
                        writer.close();
                    }
                    break;
                } else System.out.println("Invalid command!");
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
