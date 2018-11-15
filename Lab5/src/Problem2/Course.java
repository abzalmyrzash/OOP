package Problem2;

import java.io.Serializable;
import java.util.Objects;

public class Course implements Serializable {
    String courseTitle;
    Textbook textbook;
    Instructor instructor;

    public Course(){

    }

    public Course(String courseTitle, Textbook textbook, Instructor instructor) {
        this.courseTitle = courseTitle;
        this.textbook = textbook;
        this.instructor = instructor;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Textbook getTextbook() {
        return textbook;
    }

    public void setTextbook(Textbook textbook) {
        this.textbook = textbook;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return  "Title: " + courseTitle + "\n" +
                "Instructor: " + instructor + "\n" +
                "Textbook: " + textbook + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseTitle, course.courseTitle) &&
                Objects.equals(textbook, course.textbook) &&
                Objects.equals(instructor, course.instructor);
    }
}
