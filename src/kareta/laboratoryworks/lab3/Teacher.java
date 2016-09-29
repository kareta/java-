package kareta.laboratoryworks.lab3;

import java.util.ArrayList;

public class Teacher extends Person {
    private ArrayList<Course> courses = new ArrayList<Course>();

    public Teacher(String name, String surname) {
        super(name, surname);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void announce(Course course) {
        if (courses.contains(course)) {
            System.out.println("I invite you to " + course.toString() + " course!");
        }
    }

    public void evaluate(Course course, Student student, Mark mark) {
        if (courses.contains(course)) {
            course.setStudentMark(student, mark);
        }
    }
}
