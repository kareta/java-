package kareta.laboratoryworks.lab3;


public class Student extends Person {

    public Student(String name, String surname) {
        super(name, surname);
    }

    void registerInCourse(Course course) {
        course.addStudent(this);
    }
}
